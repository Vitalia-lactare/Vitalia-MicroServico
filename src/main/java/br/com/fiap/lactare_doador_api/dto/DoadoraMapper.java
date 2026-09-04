package br.com.fiap.lactare_doador_api.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.fiap.lactare_doador_api.model.Doadora;

@Component
public class DoadoraMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public DoadoraMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public Doadora toModel(DoadoraCreateRequest dto) {
        return modelMapper.map(dto, Doadora.class);
    }

    public Doadora toModel(Long id, DoadoraUpdateRequest dto) {
        Doadora doadora = modelMapper.map(dto, Doadora.class);
        doadora.setId(id);
        return doadora;
    }

    public DoadoraResponse toDto(Doadora entity) {
        return modelMapper.map(entity, DoadoraResponse.class);
    }
}
