package br.com.fiap.lactare_doador_api.dto;

import java.util.Map;

public class IndicadoresResponse {

    private double taxaConclusaoQuiz;
    private double taxaConversaoTotal;
    private String pontoAbandonoPrincipal;
    private Map<String, Long> mapaCalorPorCep;
    private Map<String, Long> regioesComMaiorDeficit;
    private Double idadeMediaDoadoras;
    private Map<Integer, Long> horarioMaiorAcesso;
    private double taxaRetorno;
    private Map<String, Long> motivosAlertaQuiz;

    public double getTaxaConclusaoQuiz() {
        return taxaConclusaoQuiz;
    }

    public void setTaxaConclusaoQuiz(double taxaConclusaoQuiz) {
        this.taxaConclusaoQuiz = taxaConclusaoQuiz;
    }

    public double getTaxaConversaoTotal() {
        return taxaConversaoTotal;
    }

    public void setTaxaConversaoTotal(double taxaConversaoTotal) {
        this.taxaConversaoTotal = taxaConversaoTotal;
    }

    public String getPontoAbandonoPrincipal() {
        return pontoAbandonoPrincipal;
    }

    public void setPontoAbandonoPrincipal(String pontoAbandonoPrincipal) {
        this.pontoAbandonoPrincipal = pontoAbandonoPrincipal;
    }

    public Map<String, Long> getMapaCalorPorCep() {
        return mapaCalorPorCep;
    }

    public void setMapaCalorPorCep(Map<String, Long> mapaCalorPorCep) {
        this.mapaCalorPorCep = mapaCalorPorCep;
    }

    public Map<String, Long> getRegioesComMaiorDeficit() {
        return regioesComMaiorDeficit;
    }

    public void setRegioesComMaiorDeficit(Map<String, Long> regioesComMaiorDeficit) {
        this.regioesComMaiorDeficit = regioesComMaiorDeficit;
    }

    public Double getIdadeMediaDoadoras() {
        return idadeMediaDoadoras;
    }

    public void setIdadeMediaDoadoras(Double idadeMediaDoadoras) {
        this.idadeMediaDoadoras = idadeMediaDoadoras;
    }

    public Map<Integer, Long> getHorarioMaiorAcesso() {
        return horarioMaiorAcesso;
    }

    public void setHorarioMaiorAcesso(Map<Integer, Long> horarioMaiorAcesso) {
        this.horarioMaiorAcesso = horarioMaiorAcesso;
    }

    public double getTaxaRetorno() {
        return taxaRetorno;
    }

    public void setTaxaRetorno(double taxaRetorno) {
        this.taxaRetorno = taxaRetorno;
    }

    public Map<String, Long> getMotivosAlertaQuiz() {
        return motivosAlertaQuiz;
    }

    public void setMotivosAlertaQuiz(Map<String, Long> motivosAlertaQuiz) {
        this.motivosAlertaQuiz = motivosAlertaQuiz;
    }
}
