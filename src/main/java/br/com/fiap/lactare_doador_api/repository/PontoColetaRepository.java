package br.com.fiap.lactare_doador_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lactare_doador_api.model.PontoColeta;

@Repository
public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {

    List<PontoColeta> findByAtivoTrue();

    long countByCepStartingWith(String prefixoCep);

}
