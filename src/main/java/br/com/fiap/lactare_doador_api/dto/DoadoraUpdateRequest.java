package br.com.fiap.lactare_doador_api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoadoraUpdateRequest {

    @NotNull
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    private String nome;

    @NotNull
    @Email(message = "E-mail inválido")
    private String email;

    private String telefone;

    @NotNull
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido")
    private String cep;

    @NotNull
    @Past(message = "Data de nascimento deve estar no passado")
    private LocalDate dataNascimento;

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
}
