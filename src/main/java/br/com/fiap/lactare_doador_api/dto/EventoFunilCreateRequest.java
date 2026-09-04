package br.com.fiap.lactare_doador_api.dto;

import jakarta.validation.constraints.NotNull;

import br.com.fiap.lactare_doador_api.model.TipoEvento;

public class EventoFunilCreateRequest {

    @NotNull(message = "Informe o id da sessão")
    private String sessionId;

    private Long doadoraId;

    @NotNull(message = "Informe o tipo do evento")
    private TipoEvento tipoEvento;

    private Integer stepNumber;

    private String cep;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getDoadoraId() {
        return doadoraId;
    }

    public void setDoadoraId(Long doadoraId) {
        this.doadoraId = doadoraId;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
