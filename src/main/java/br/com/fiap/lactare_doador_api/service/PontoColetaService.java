package br.com.fiap.lactare_doador_api.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lactare_doador_api.dto.PontoColetaMapper;
import br.com.fiap.lactare_doador_api.dto.PontoColetaProximoResponse;
import br.com.fiap.lactare_doador_api.model.NivelEstoque;
import br.com.fiap.lactare_doador_api.model.PontoColeta;
import br.com.fiap.lactare_doador_api.repository.PontoColetaRepository;

@Service
public class PontoColetaService {

    @Autowired
    private PontoColetaRepository repository;

    @Autowired
    private PontoColetaMapper mapper;

    public PontoColeta createOrUpdate(PontoColeta pontoColeta) {
        return repository.save(pontoColeta);
    }

    public Optional<PontoColeta> findById(Long id) {
        return repository.findById(id);
    }

    public List<PontoColeta> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    /**
     * MVP (Versão A do desenho da solução): proximidade calculada pela diferença
     * numérica entre CEPs, sem chamadas a serviços externos de geocodificação.
     */
    public List<PontoColetaProximoResponse> encontrarProximos(String cepInformado) {
        long cepBase = cepParaNumero(cepInformado);

        List<PontoColeta> ativos = repository.findByAtivoTrue();
        List<PontoColeta> ordenados = ativos.stream()
                .sorted(Comparator.comparingLong(p -> Math.abs(cepParaNumero(p.getCep()) - cepBase)))
                .toList();

        List<PontoColetaProximoResponse> resultado = new ArrayList<>();
        for (int i = 0; i < ordenados.size(); i++) {
            PontoColeta ponto = ordenados.get(i);
            String categoria;
            if (i == 0) {
                categoria = "MAIS_PROXIMO";
            } else if (ponto.getNivelEstoque() == NivelEstoque.BAIXO) {
                categoria = "PRIORITARIO";
            } else {
                categoria = "OUTRA_OPCAO";
            }
            resultado.add(new PontoColetaProximoResponse(mapper.toDto(ponto), categoria));
        }
        return resultado;
    }

    private long cepParaNumero(String cep) {
        String digitos = cep.replaceAll("\\D", "");
        return digitos.isEmpty() ? 0L : Long.parseLong(digitos);
    }
}
