package br.com.fiap.lactare_doador_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lactare_doador_api.model.LogDoacao;
import br.com.fiap.lactare_doador_api.model.StatusDoacao;
import br.com.fiap.lactare_doador_api.repository.LogDoacaoRepository;

@Service
public class LogDoacaoService {

    @Autowired
    private LogDoacaoRepository repository;

    public LogDoacao registrar(Long doacaoId, StatusDoacao statusAnterior, StatusDoacao statusNovo, String observacao) {
        LogDoacao log = new LogDoacao();
        log.setDoacaoId(doacaoId);
        log.setStatusAnterior(statusAnterior);
        log.setStatusNovo(statusNovo);
        log.setObservacao(observacao);
        log.setDataHora(LocalDateTime.now());
        return repository.save(log);
    }

    public List<LogDoacao> findByDoacaoId(Long doacaoId) {
        return repository.findByDoacaoIdOrderByDataHoraAsc(doacaoId);
    }
}
