package br.com.fiap.lactare_doador_api.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.fiap.lactare_doador_api.model.PesquisaSatisfacao;

@Component
public class PesquisaSatisfacaoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PesquisaSatisfacaoMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public PesquisaSatisfacao toModel(PesquisaSatisfacaoCreateRequest dto) {
        return modelMapper.map(dto, PesquisaSatisfacao.class);
    }

    public PesquisaSatisfacaoResponse toDto(PesquisaSatisfacao entity) {
        return modelMapper.map(entity, PesquisaSatisfacaoResponse.class);
    }
}
