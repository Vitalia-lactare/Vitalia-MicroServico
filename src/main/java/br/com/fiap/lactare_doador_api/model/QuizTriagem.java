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
@Table(name = "quiz_triagens")
public class QuizTriagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "doadora_id")
    private Long doadoraId;

    @Column(name = "amamentando_atualmente", nullable = false)
    private Boolean amamentandoAtualmente;

    @Column(name = "idade_bebe_meses")
    private Integer idadeBebeMeses;

    @Column(name = "usa_medicamento", nullable = false)
    private Boolean usaMedicamento;

    @Column(nullable = false)
    private Boolean fumante;

    @Column(name = "realizou_exames_recentes", nullable = false)
    private Boolean realizouExamesRecentes;

    @Column(nullable = false, length = 9)
    private String cep;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ResultadoTriagem resultado;

    @Column(name = "motivo_alerta", length = 50)
    private String motivoAlerta;

    @Column(name = "data_resposta", nullable = false)
    private LocalDateTime dataResposta;

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

    public Boolean getAmamentandoAtualmente() {
        return amamentandoAtualmente;
    }

    public void setAmamentandoAtualmente(Boolean amamentandoAtualmente) {
        this.amamentandoAtualmente = amamentandoAtualmente;
    }

    public Integer getIdadeBebeMeses() {
        return idadeBebeMeses;
    }

    public void setIdadeBebeMeses(Integer idadeBebeMeses) {
        this.idadeBebeMeses = idadeBebeMeses;
    }

    public Boolean getUsaMedicamento() {
        return usaMedicamento;
    }

    public void setUsaMedicamento(Boolean usaMedicamento) {
        this.usaMedicamento = usaMedicamento;
    }

    public Boolean getFumante() {
        return fumante;
    }

    public void setFumante(Boolean fumante) {
        this.fumante = fumante;
    }

    public Boolean getRealizouExamesRecentes() {
        return realizouExamesRecentes;
    }

    public void setRealizouExamesRecentes(Boolean realizouExamesRecentes) {
        this.realizouExamesRecentes = realizouExamesRecentes;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ResultadoTriagem getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoTriagem resultado) {
        this.resultado = resultado;
    }

    public String getMotivoAlerta() {
        return motivoAlerta;
    }

    public void setMotivoAlerta(String motivoAlerta) {
        this.motivoAlerta = motivoAlerta;
    }

    public LocalDateTime getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDateTime dataResposta) {
        this.dataResposta = dataResposta;
    }
}
