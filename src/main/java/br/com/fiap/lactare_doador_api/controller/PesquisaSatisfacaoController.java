package br.com.fiap.lactare_doador_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lactare_doador_api.dto.PesquisaSatisfacaoCreateRequest;
import br.com.fiap.lactare_doador_api.dto.PesquisaSatisfacaoMapper;
import br.com.fiap.lactare_doador_api.dto.PesquisaSatisfacaoResponse;
import br.com.fiap.lactare_doador_api.model.PesquisaSatisfacao;
import br.com.fiap.lactare_doador_api.service.PesquisaSatisfacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/pesquisas-satisfacao")
public class PesquisaSatisfacaoController {

    @Autowired
    private PesquisaSatisfacaoService service;

    @Autowired
    private PesquisaSatisfacaoMapper mapper;

    @PostMapping
    public ResponseEntity<PesquisaSatisfacaoResponse> create(
            @Valid @RequestBody PesquisaSatisfacaoCreateRequest dtoRequest) {
        PesquisaSatisfacao pesquisa = mapper.toModel(dtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(service.create(pesquisa)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PesquisaSatisfacaoResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PesquisaSatisfacaoResponse>> findAll(
            @RequestParam(required = false) Long doadoraId) {
        List<PesquisaSatisfacao> pesquisas = doadoraId != null
                ? service.findByDoadoraId(doadoraId)
                : service.findAll();
        return ResponseEntity.ok(pesquisas.stream().map(mapper::toDto).toList());
    }
}
