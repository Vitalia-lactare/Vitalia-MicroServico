package br.com.fiap.lactare_doador_api.dto;

import jakarta.validation.constraints.NotNull;

import br.com.fiap.lactare_doador_api.model.EstagioLeite;
import br.com.fiap.lactare_doador_api.model.StatusDoacao;

public class DoacaoUpdateStatusRequest {

    @NotNull(message = "Informe o novo status da doação")
    private StatusDoacao status;

    private EstagioLeite estagioLeite;

    private Integer volumeMl;

    private String observacao;

    public StatusDoacao getStatus() {
        return status;
    }

    public void setStatus(StatusDoacao status) {
        this.status = status;
    }

    public EstagioLeite getEstagioLeite() {
        return estagioLeite;
    }

    public void setEstagioLeite(EstagioLeite estagioLeite) {
        this.estagioLeite = estagioLeite;
    }

    public Integer getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(Integer volumeMl) {
        this.volumeMl = volumeMl;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
