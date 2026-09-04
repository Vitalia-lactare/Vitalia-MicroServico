package br.com.fiap.lactare_doador_api.dto;

import jakarta.validation.constraints.NotNull;

public class QuizTriagemVincularRequest {

    @NotNull(message = "Informe o id da doadora")
    private Long doadoraId;

    public Long getDoadoraId() {
        return doadoraId;
    }

    public void setDoadoraId(Long doadoraId) {
        this.doadoraId = doadoraId;
    }
}
