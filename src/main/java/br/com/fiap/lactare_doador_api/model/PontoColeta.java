package br.com.fiap.lactare_doador_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pontos_coleta")
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_hospital", nullable = false, length = 150)
    private String nomeHospital;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(length = 200)
    private String endereco;

    @Column(length = 20)
    private String telefone;

    @Column(name = "horario_funcionamento", length = 100)
    private String horarioFuncionamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_estoque", nullable = false, length = 10)
    private NivelEstoque nivelEstoque;

    @Column(nullable = false)
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
