package br.com.fiap.lactare_doador_api.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.fiap.lactare_doador_api.model.PontoColeta;

@Component
public class PontoColetaMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PontoColetaMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public PontoColeta toModel(PontoColetaCreateRequest dto) {
        PontoColeta pontoColeta = modelMapper.map(dto, PontoColeta.class);
        pontoColeta.setAtivo(true);
        return pontoColeta;
    }

    public PontoColeta toModel(Long id, PontoColetaUpdateRequest dto) {
        PontoColeta pontoColeta = modelMapper.map(dto, PontoColeta.class);
        pontoColeta.setId(id);
        return pontoColeta;
    }

    public PontoColetaResponse toDto(PontoColeta entity) {
        return modelMapper.map(entity, PontoColetaResponse.class);
    }
}
