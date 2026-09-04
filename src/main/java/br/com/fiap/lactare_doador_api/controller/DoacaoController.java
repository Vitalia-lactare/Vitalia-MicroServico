package br.com.fiap.lactare_doador_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lactare_doador_api.dto.DoacaoCreateRequest;
import br.com.fiap.lactare_doador_api.dto.DoacaoMapper;
import br.com.fiap.lactare_doador_api.dto.DoacaoResponse;
import br.com.fiap.lactare_doador_api.dto.DoacaoUpdateStatusRequest;
import br.com.fiap.lactare_doador_api.dto.LogDoacaoMapper;
import br.com.fiap.lactare_doador_api.dto.LogDoacaoResponse;
import br.com.fiap.lactare_doador_api.model.Doacao;
import br.com.fiap.lactare_doador_api.service.DoacaoService;
import br.com.fiap.lactare_doador_api.service.LogDoacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoService service;

    @Autowired
    private LogDoacaoService logDoacaoService;

    @Autowired
    private DoacaoMapper mapper;

    @Autowired
    private LogDoacaoMapper logMapper;

    @PostMapping
    public ResponseEntity<DoacaoResponse> create(@Valid @RequestBody DoacaoCreateRequest dtoRequest) {
        Doacao doacao = mapper.toModel(dtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(service.agendar(doacao)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoacaoResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DoacaoResponse>> findAll(@RequestParam(required = false) Long doadoraId) {
        List<Doacao> doacoes = doadoraId != null ? service.findByDoadoraId(doadoraId) : service.findAll();
        return ResponseEntity.ok(doacoes.stream().map(mapper::toDto).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoacaoResponse> atualizarStatus(@PathVariable Long id,
            @Valid @RequestBody DoacaoUpdateStatusRequest dtoRequest) {
        return service.atualizarStatus(id, dtoRequest.getStatus(), dtoRequest.getEstagioLeite(),
                dtoRequest.getVolumeMl(), dtoRequest.getObservacao())
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/logs")
    public ResponseEntity<List<LogDoacaoResponse>> findLogs(@PathVariable Long id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(logDoacaoService.findByDoacaoId(id).stream().map(logMapper::toDto).toList());
    }
}
