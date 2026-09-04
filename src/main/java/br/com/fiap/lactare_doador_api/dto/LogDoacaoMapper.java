package br.com.fiap.lactare_doador_api.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.fiap.lactare_doador_api.model.LogDoacao;

@Component
public class LogDoacaoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public LogDoacaoMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public LogDoacaoResponse toDto(LogDoacao entity) {
        return modelMapper.map(entity, LogDoacaoResponse.class);
    }
}
