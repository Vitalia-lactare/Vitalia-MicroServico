package br.com.fiap.lactare_doador_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lactare_doador_api.model.QuizTriagem;
import br.com.fiap.lactare_doador_api.model.ResultadoTriagem;
import br.com.fiap.lactare_doador_api.repository.QuizTriagemRepository;

@Service
public class QuizTriagemService {

    @Autowired
    private QuizTriagemRepository repository;

    public QuizTriagem create(QuizTriagem quizTriagem) {
        quizTriagem.setDataResposta(LocalDateTime.now());
        aplicarRegraDeTriagem(quizTriagem);
        return repository.save(quizTriagem);
    }

    public Optional<QuizTriagem> findById(Long id) {
        return repository.findById(id);
    }

    public List<QuizTriagem> findAll() {
        return repository.findAll();
    }

    public List<QuizTriagem> findByDoadoraId(Long doadoraId) {
        return repository.findByDoadoraId(doadoraId);
    }

    public Optional<QuizTriagem> vincularDoadora(Long id, Long doadoraId) {
        return repository.findById(id).map(quiz -> {
            quiz.setDoadoraId(doadoraId);
            return repository.save(quiz);
        });
    }

    private void aplicarRegraDeTriagem(QuizTriagem quiz) {
        if (Boolean.TRUE.equals(quiz.getFumante())) {
            quiz.setResultado(ResultadoTriagem.ALERTA);
            quiz.setMotivoAlerta("FUMANTE");
        } else if (Boolean.TRUE.equals(quiz.getUsaMedicamento())) {
            quiz.setResultado(ResultadoTriagem.ALERTA);
            quiz.setMotivoAlerta("MEDICAMENTO");
        } else if (Boolean.FALSE.equals(quiz.getRealizouExamesRecentes())) {
            quiz.setResultado(ResultadoTriagem.ALERTA);
            quiz.setMotivoAlerta("EXAMES_PENDENTES");
        } else {
            quiz.setResultado(ResultadoTriagem.APROVADA);
            quiz.setMotivoAlerta(null);
        }
    }
}
