package br.com.fiap.lactare_doador_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lactare_doador_api.model.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

    List<Doacao> findByDoadoraId(Long doadoraId);

}
