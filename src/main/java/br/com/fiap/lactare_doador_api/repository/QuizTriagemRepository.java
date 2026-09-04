package br.com.fiap.lactare_doador_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lactare_doador_api.model.QuizTriagem;
import br.com.fiap.lactare_doador_api.model.ResultadoTriagem;

@Repository
public interface QuizTriagemRepository extends JpaRepository<QuizTriagem, Long> {

    List<QuizTriagem> findByDoadoraId(Long doadoraId);

    long countByResultado(ResultadoTriagem resultado);

    List<QuizTriagem> findByMotivoAlertaIsNotNull();

}
