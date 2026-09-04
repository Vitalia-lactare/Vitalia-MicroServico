package br.com.fiap.lactare_doador_api.dto;

import java.time.LocalDateTime;

import br.com.fiap.lactare_doador_api.model.ResultadoTriagem;

public class QuizTriagemResponse {

    private Long id;
    private Long doadoraId;
    private Boolean amamentandoAtualmente;
    private Integer idadeBebeMeses;
    private Boolean usaMedicamento;
    private Boolean fumante;
    private Boolean realizouExamesRecentes;
    private String cep;
    private ResultadoTriagem resultado;
    private String motivoAlerta;
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
