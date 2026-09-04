package br.com.fiap.lactare_doador_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lactare_doador_api.model.EventoFunil;
import br.com.fiap.lactare_doador_api.model.TipoEvento;

@Repository
public interface EventoFunilRepository extends JpaRepository<EventoFunil, Long> {

    List<EventoFunil> findByTipoEvento(TipoEvento tipoEvento);

    List<EventoFunil> findBySessionId(String sessionId);

    long countByTipoEvento(TipoEvento tipoEvento);

    long countByTipoEventoAndStepNumber(TipoEvento tipoEvento, Integer stepNumber);

}
