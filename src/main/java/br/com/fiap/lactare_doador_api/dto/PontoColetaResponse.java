package br.com.fiap.lactare_doador_api.dto;

import br.com.fiap.lactare_doador_api.model.NivelEstoque;

public class PontoColetaResponse {

    private Long id;
    private String nomeHospital;
    private String cep;
    private String endereco;
    private String telefone;
    private String horarioFuncionamento;
    private NivelEstoque nivelEstoque;
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
