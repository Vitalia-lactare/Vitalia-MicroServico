package br.com.fiap.lactare_doador_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lactare_doador_api.model.LogDoacao;

@Repository
public interface LogDoacaoRepository extends JpaRepository<LogDoacao, Long> {

    List<LogDoacao> findByDoacaoIdOrderByDataHoraAsc(Long doacaoId);

}
