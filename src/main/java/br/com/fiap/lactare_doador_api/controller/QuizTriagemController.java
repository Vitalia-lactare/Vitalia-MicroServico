package br.com.fiap.lactare_doador_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lactare_doador_api.dto.QuizTriagemCreateRequest;
import br.com.fiap.lactare_doador_api.dto.QuizTriagemMapper;
import br.com.fiap.lactare_doador_api.dto.QuizTriagemResponse;
import br.com.fiap.lactare_doador_api.dto.QuizTriagemVincularRequest;
import br.com.fiap.lactare_doador_api.model.QuizTriagem;
import br.com.fiap.lactare_doador_api.service.QuizTriagemService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/triagens")
public class QuizTriagemController {

    @Autowired
    private QuizTriagemService service;

    @Autowired
    private QuizTriagemMapper mapper;

    @PostMapping
    public ResponseEntity<QuizTriagemResponse> create(@Valid @RequestBody QuizTriagemCreateRequest dtoRequest) {
        QuizTriagem quiz = mapper.toModel(dtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(service.create(quiz)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizTriagemResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<QuizTriagemResponse>> findAll(
            @RequestParam(required = false) Long doadoraId) {
        List<QuizTriagem> triagens = doadoraId != null
                ? service.findByDoadoraId(doadoraId)
                : service.findAll();
        return ResponseEntity.ok(triagens.stream().map(mapper::toDto).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizTriagemResponse> vincularDoadora(@PathVariable Long id,
            @Valid @RequestBody QuizTriagemVincularRequest dtoRequest) {
        return service.vincularDoadora(id, dtoRequest.getDoadoraId())
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
