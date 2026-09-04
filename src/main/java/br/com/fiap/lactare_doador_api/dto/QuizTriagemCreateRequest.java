package br.com.fiap.lactare_doador_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class QuizTriagemCreateRequest {

    @NotNull(message = "Informe se está amamentando atualmente")
    private Boolean amamentandoAtualmente;

    @PositiveOrZero
    private Integer idadeBebeMeses;

    @NotNull(message = "Informe se usa algum medicamento")
    private Boolean usaMedicamento;

    @NotNull(message = "Informe se é fumante")
    private Boolean fumante;

    @NotNull(message = "Informe se realizou exames recentes")
    private Boolean realizouExamesRecentes;

    @NotNull
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido")
    private String cep;

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
}
