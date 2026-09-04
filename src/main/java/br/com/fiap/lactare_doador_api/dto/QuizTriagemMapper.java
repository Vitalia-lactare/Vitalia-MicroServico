package br.com.fiap.lactare_doador_api.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import br.com.fiap.lactare_doador_api.model.QuizTriagem;

@Component
public class QuizTriagemMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public QuizTriagemMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public QuizTriagem toModel(QuizTriagemCreateRequest dto) {
        return modelMapper.map(dto, QuizTriagem.class);
    }

    public QuizTriagemResponse toDto(QuizTriagem entity) {
        return modelMapper.map(entity, QuizTriagemResponse.class);
    }
}
