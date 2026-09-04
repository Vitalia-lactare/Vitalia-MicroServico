package br.com.fiap.lactare_doador_api.dto;

import java.time.LocalDateTime;

import br.com.fiap.lactare_doador_api.model.StatusDoacao;

public class LogDoacaoResponse {

    private Long id;
    private Long doacaoId;
    private StatusDoacao statusAnterior;
    private StatusDoacao statusNovo;
    private String observacao;
    private LocalDateTime dataHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoacaoId() {
        return doacaoId;
    }

    public void setDoacaoId(Long doacaoId) {
        this.doacaoId = doacaoId;
    }

    public StatusDoacao getStatusAnterior() {
        return statusAnterior;
    }

    public void setStatusAnterior(StatusDoacao statusAnterior) {
        this.statusAnterior = statusAnterior;
    }

    public StatusDoacao getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(StatusDoacao statusNovo) {
        this.statusNovo = statusNovo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
