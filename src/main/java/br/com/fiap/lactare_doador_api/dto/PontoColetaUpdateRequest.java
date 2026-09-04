package br.com.fiap.lactare_doador_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import br.com.fiap.lactare_doador_api.model.NivelEstoque;

public class PontoColetaUpdateRequest {

    @NotNull
    @Size(min = 3, message = "Nome do hospital deve ter no mínimo 3 caracteres")
    private String nomeHospital;

    @NotNull
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido")
    private String cep;

    private String endereco;

    private String telefone;

    private String horarioFuncionamento;

    @NotNull(message = "Informe o nível de estoque")
    private NivelEstoque nivelEstoque;

    @NotNull
    private Boolean ativo;

    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public NivelEstoque getNivelEstoque() {
        return nivelEstoque;
    }

    public void setNivelEstoque(NivelEstoque nivelEstoque) {
        this.nivelEstoque = nivelEstoque;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
