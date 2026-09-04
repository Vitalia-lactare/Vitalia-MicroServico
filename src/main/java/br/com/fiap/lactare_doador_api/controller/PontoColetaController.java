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

import br.com.fiap.lactare_doador_api.dto.PontoColetaCreateRequest;
import br.com.fiap.lactare_doador_api.dto.PontoColetaMapper;
import br.com.fiap.lactare_doador_api.dto.PontoColetaProximoResponse;
import br.com.fiap.lactare_doador_api.dto.PontoColetaResponse;
import br.com.fiap.lactare_doador_api.dto.PontoColetaUpdateRequest;
import br.com.fiap.lactare_doador_api.model.PontoColeta;
import br.com.fiap.lactare_doador_api.service.PontoColetaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/pontos-coleta")
public class PontoColetaController {

    @Autowired
    private PontoColetaService service;

    @Autowired
    private PontoColetaMapper mapper;

    @PostMapping
    public ResponseEntity<PontoColetaResponse> create(@Valid @RequestBody PontoColetaCreateRequest dtoRequest) {
        PontoColeta salvo = service.createOrUpdate(mapper.toModel(dtoRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(salvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoColetaResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PontoColetaResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::toDto).toList());
    }

    @GetMapping("/proximos")
    public ResponseEntity<List<PontoColetaProximoResponse>> encontrarProximos(@RequestParam String cep) {
        return ResponseEntity.ok(service.encontrarProximos(cep));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoColetaResponse> update(@PathVariable Long id,
            @Valid @RequestBody PontoColetaUpdateRequest dtoRequest) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        PontoColeta atualizado = service.createOrUpdate(mapper.toModel(id, dtoRequest));
        return ResponseEntity.ok(mapper.toDto(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
