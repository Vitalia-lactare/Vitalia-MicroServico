package br.com.fiap.lactare_doador_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lactare_doador_api.model.Doadora;

@Repository
public interface DoadoraRepository extends JpaRepository<Doadora, Long> {

    boolean existsByEmail(String email);

}
