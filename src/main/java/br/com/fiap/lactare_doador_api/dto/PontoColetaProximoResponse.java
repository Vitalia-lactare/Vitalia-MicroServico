package br.com.fiap.lactare_doador_api.dto;

public class PontoColetaProximoResponse {

    private PontoColetaResponse pontoColeta;
    private String categoria;

    public PontoColetaProximoResponse() {
    }

    public PontoColetaProximoResponse(PontoColetaResponse pontoColeta, String categoria) {
        this.pontoColeta = pontoColeta;
        this.categoria = categoria;
    }

    public PontoColetaResponse getPontoColeta() {
        return pontoColeta;
    }

    public void setPontoColeta(PontoColetaResponse pontoColeta) {
        this.pontoColeta = pontoColeta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
