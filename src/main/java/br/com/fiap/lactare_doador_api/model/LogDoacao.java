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
@Table(name = "logs_doacao")
public class LogDoacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "doacao_id", nullable = false)
    private Long doacaoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_anterior", length = 20)
    private StatusDoacao statusAnterior;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_novo", nullable = false, length = 20)
    private StatusDoacao statusNovo;

    @Column(length = 255)
    private String observacao;

    @Column(name = "data_hora", nullable = false)
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
