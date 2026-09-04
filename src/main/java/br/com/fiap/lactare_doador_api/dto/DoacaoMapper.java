package br.com.fiap.lactare_doador_api.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.fiap.lactare_doador_api.model.Doacao;

@Component
public class DoacaoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public DoacaoMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public Doacao toModel(DoacaoCreateRequest dto) {
        return modelMapper.map(dto, Doacao.class);
    }

    public DoacaoResponse toDto(Doacao entity) {
        return modelMapper.map(entity, DoacaoResponse.class);
    }
}
