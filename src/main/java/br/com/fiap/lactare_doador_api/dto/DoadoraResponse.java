package br.com.fiap.lactare_doador_api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DoadoraResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cep;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;
    private Boolean consentimentoLgpd;
    private LocalDateTime dataConsentimentoLgpd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getConsentimentoLgpd() {
        return consentimentoLgpd;
    }

    public void setConsentimentoLgpd(Boolean consentimentoLgpd) {
        this.consentimentoLgpd = consentimentoLgpd;
    }

    public LocalDateTime getDataConsentimentoLgpd() {
        return dataConsentimentoLgpd;
    }

    public void setDataConsentimentoLgpd(LocalDateTime dataConsentimentoLgpd) {
        this.dataConsentimentoLgpd = dataConsentimentoLgpd;
    }
}
