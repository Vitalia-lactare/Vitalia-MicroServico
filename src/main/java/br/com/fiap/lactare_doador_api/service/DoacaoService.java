package br.com.fiap.lactare_doador_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lactare_doador_api.model.Doacao;
import br.com.fiap.lactare_doador_api.model.StatusDoacao;
import br.com.fiap.lactare_doador_api.repository.DoacaoRepository;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository repository;

    @Autowired
    private LogDoacaoService logDoacaoService;

    public Doacao agendar(Doacao doacao) {
        doacao.setStatus(StatusDoacao.AGENDADA);
        doacao.setDataAgendamento(LocalDateTime.now());
        Doacao salva = repository.save(doacao);
        logDoacaoService.registrar(salva.getId(), null, StatusDoacao.AGENDADA, "Doação agendada");
        return salva;
    }

    public Optional<Doacao> findById(Long id) {
        return repository.findById(id);
    }

    public List<Doacao> findAll() {
        return repository.findAll();
    }

    public List<Doacao> findByDoadoraId(Long doadoraId) {
        return repository.findByDoadoraId(doadoraId);
    }

    public Optional<Doacao> atualizarStatus(Long id, StatusDoacao novoStatus, br.com.fiap.lactare_doador_api.model.EstagioLeite estagioLeite,
            Integer volumeMl, String observacao) {
        return repository.findById(id).map(doacao -> {
            StatusDoacao statusAnterior = doacao.getStatus();
            doacao.setStatus(novoStatus);

            if (estagioLeite != null) {
                doacao.setEstagioLeite(estagioLeite);
            }
            if (volumeMl != null) {
                doacao.setVolumeMl(volumeMl);
            }
            if (novoStatus == StatusDoacao.COLETADA && doacao.getDataColeta() == null) {
                doacao.setDataColeta(LocalDateTime.now());
            }
            if ((novoStatus == StatusDoacao.APROVADA || novoStatus == StatusDoacao.REJEITADA)
                    && doacao.getDataConclusao() == null) {
                doacao.setDataConclusao(LocalDateTime.now());
            }

            Doacao atualizada = repository.save(doacao);
            logDoacaoService.registrar(atualizada.getId(), statusAnterior, novoStatus, observacao);
            return atualizada;
        });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
