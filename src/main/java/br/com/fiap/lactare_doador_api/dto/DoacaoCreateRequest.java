package br.com.fiap.lactare_doador_api.dto;

import jakarta.validation.constraints.NotNull;

public class DoacaoCreateRequest {

    @NotNull(message = "Informe o id da doadora")
    private Long doadoraId;

    @NotNull(message = "Informe o id do ponto de coleta")
    private Long pontoColetaId;

    public Long getDoadoraId() {
        return doadoraId;
    }

    public void setDoadoraId(Long doadoraId) {
        this.doadoraId = doadoraId;
    }

    public Long getPontoColetaId() {
        return pontoColetaId;
    }

    public void setPontoColetaId(Long pontoColetaId) {
        this.pontoColetaId = pontoColetaId;
    }
}
