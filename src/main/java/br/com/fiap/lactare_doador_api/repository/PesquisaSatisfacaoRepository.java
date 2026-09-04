package br.com.fiap.lactare_doador_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lactare_doador_api.model.PesquisaSatisfacao;

@Repository
public interface PesquisaSatisfacaoRepository extends JpaRepository<PesquisaSatisfacao, Long> {

    List<PesquisaSatisfacao> findByDoadoraId(Long doadoraId);

}
