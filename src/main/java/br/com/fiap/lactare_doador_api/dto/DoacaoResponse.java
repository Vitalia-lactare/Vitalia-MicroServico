package br.com.fiap.lactare_doador_api.dto;

import java.time.LocalDateTime;

import br.com.fiap.lactare_doador_api.model.EstagioLeite;
import br.com.fiap.lactare_doador_api.model.StatusDoacao;

public class DoacaoResponse {

    private Long id;
    private Long doadoraId;
    private Long pontoColetaId;
    private EstagioLeite estagioLeite;
    private StatusDoacao status;
    private Integer volumeMl;
    private LocalDateTime dataAgendamento;
    private LocalDateTime dataColeta;
    private LocalDateTime dataConclusao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public EstagioLeite getEstagioLeite() {
        return estagioLeite;
    }

    public void setEstagioLeite(EstagioLeite estagioLeite) {
        this.estagioLeite = estagioLeite;
    }

    public StatusDoacao getStatus() {
        return status;
    }

    public void setStatus(StatusDoacao status) {
        this.status = status;
    }

    public Integer getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(Integer volumeMl) {
        this.volumeMl = volumeMl;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDateTime getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDateTime dataColeta) {
        this.dataColeta = dataColeta;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
