package br.com.fiap.lactare_doador_api.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.fiap.lactare_doador_api.model.EventoFunil;

@Component
public class EventoFunilMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public EventoFunilMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public EventoFunil toModel(EventoFunilCreateRequest dto) {
        return modelMapper.map(dto, EventoFunil.class);
    }

    public EventoFunilResponse toDto(EventoFunil entity) {
        return modelMapper.map(entity, EventoFunilResponse.class);
    }
}
