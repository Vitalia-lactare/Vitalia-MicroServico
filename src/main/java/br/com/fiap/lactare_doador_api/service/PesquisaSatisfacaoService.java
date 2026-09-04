package br.com.fiap.lactare_doador_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lactare_doador_api.model.PesquisaSatisfacao;
import br.com.fiap.lactare_doador_api.repository.PesquisaSatisfacaoRepository;

@Service
public class PesquisaSatisfacaoService {

    @Autowired
    private PesquisaSatisfacaoRepository repository;

    public PesquisaSatisfacao create(PesquisaSatisfacao pesquisa) {
        pesquisa.setDataResposta(LocalDateTime.now());
        return repository.save(pesquisa);
    }

    public Optional<PesquisaSatisfacao> findById(Long id) {
        return repository.findById(id);
    }

    public List<PesquisaSatisfacao> findAll() {
        return repository.findAll();
    }

    public List<PesquisaSatisfacao> findByDoadoraId(Long doadoraId) {
        return repository.findByDoadoraId(doadoraId);
    }
}
