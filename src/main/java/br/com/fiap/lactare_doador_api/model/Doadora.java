package br.com.fiap.lactare_doador_api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doadoras")
public class Doadora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "senha_hash", nullable = false, length = 64)
    private String senhaHash;

    @Column(length = 20)
    private String telefone;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "consentimento_lgpd", nullable = false)
    private Boolean consentimentoLgpd;

    @Column(name = "data_consentimento_lgpd", nullable = false)
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

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
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
