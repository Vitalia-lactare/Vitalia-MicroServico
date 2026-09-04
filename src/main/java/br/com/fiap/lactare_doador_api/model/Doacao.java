package br.com.fiap.lactare_doador_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doacoes")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "doadora_id", nullable = false)
    private Long doadoraId;

    @Column(name = "ponto_coleta_id", nullable = false)
    private Long pontoColetaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "estagio_leite", length = 20)
    private EstagioLeite estagioLeite;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusDoacao status;

    @Column(name = "volume_ml")
    private Integer volumeMl;

    @Column(name = "data_agendamento", nullable = false)
    private LocalDateTime dataAgendamento;

    @Column(name = "data_coleta")
    private LocalDateTime dataColeta;

    @Column(name = "data_conclusao")
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
