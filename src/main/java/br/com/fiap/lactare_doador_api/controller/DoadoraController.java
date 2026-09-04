package br.com.fiap.lactare_doador_api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lactare_doador_api.dto.DoadoraCreateRequest;
import br.com.fiap.lactare_doador_api.dto.DoadoraMapper;
import br.com.fiap.lactare_doador_api.dto.DoadoraResponse;
import br.com.fiap.lactare_doador_api.dto.DoadoraUpdateRequest;
import br.com.fiap.lactare_doador_api.model.Doadora;
import br.com.fiap.lactare_doador_api.service.DoadoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/doadoras")
public class DoadoraController {

    @Autowired
    private DoadoraService service;

    @Autowired
    private DoadoraMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DoadoraCreateRequest dtoRequest) {
        if (service.existsByEmail(dtoRequest.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("mensagem", "Esse e-mail já está cadastrado"));
        }
        Doadora doadora = mapper.toModel(dtoRequest);
        Doadora criada = service.create(doadora, dtoRequest.getSenha());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(criada));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoadoraResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DoadoraResponse>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream().map(mapper::toDto).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoadoraResponse> update(@PathVariable Long id,
            @Valid @RequestBody DoadoraUpdateRequest dtoRequest) {
        Optional<Doadora> existente = service.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Doadora doadora = mapper.toModel(id, dtoRequest);
        return ResponseEntity.ok(mapper.toDto(service.update(id, doadora)));
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
