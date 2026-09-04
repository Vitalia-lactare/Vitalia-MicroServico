package br.com.fiap.lactare_doador_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lactare_doador_api.dto.EventoFunilCreateRequest;
import br.com.fiap.lactare_doador_api.dto.EventoFunilMapper;
import br.com.fiap.lactare_doador_api.dto.EventoFunilResponse;
import br.com.fiap.lactare_doador_api.dto.IndicadoresResponse;
import br.com.fiap.lactare_doador_api.model.EventoFunil;
import br.com.fiap.lactare_doador_api.model.TipoEvento;
import br.com.fiap.lactare_doador_api.service.EventoFunilService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/eventos")
public class EventoFunilController {

    @Autowired
    private EventoFunilService service;

    @Autowired
    private EventoFunilMapper mapper;

    @PostMapping
    public ResponseEntity<EventoFunilResponse> create(@Valid @RequestBody EventoFunilCreateRequest dtoRequest) {
        EventoFunil evento = mapper.toModel(dtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(service.registrar(evento)));
    }

    @GetMapping
    public ResponseEntity<List<EventoFunilResponse>> findAll(
            @RequestParam(required = false) TipoEvento tipoEvento,
            @RequestParam(required = false) String sessionId) {
        List<EventoFunil> eventos;
        if (tipoEvento != null) {
            eventos = service.findByTipoEvento(tipoEvento);
        } else if (sessionId != null) {
            eventos = service.findBySessionId(sessionId);
        } else {
            eventos = service.findAll();
        }
        return ResponseEntity.ok(eventos.stream().map(mapper::toDto).toList());
    }

    @GetMapping("/indicadores")
    public ResponseEntity<IndicadoresResponse> indicadores() {
        return ResponseEntity.ok(service.calcularIndicadores());
    }
}
