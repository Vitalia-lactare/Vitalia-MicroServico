package br.com.fiap.lactare_doador_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.lactare_doador_api.dto.IndicadoresResponse;
import br.com.fiap.lactare_doador_api.model.EventoFunil;
import br.com.fiap.lactare_doador_api.model.ResultadoTriagem;
import br.com.fiap.lactare_doador_api.model.TipoEvento;
import br.com.fiap.lactare_doador_api.repository.DoadoraRepository;
import br.com.fiap.lactare_doador_api.repository.EventoFunilRepository;
import br.com.fiap.lactare_doador_api.repository.PontoColetaRepository;
import br.com.fiap.lactare_doador_api.repository.QuizTriagemRepository;

@Service
public class EventoFunilService {

    private static final int QUIZ_TOTAL_PERGUNTAS = 6;

    @Autowired
    private EventoFunilRepository repository;

    @Autowired
    private QuizTriagemRepository quizTriagemRepository;

    @Autowired
    private DoadoraRepository doadoraRepository;

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    public EventoFunil registrar(EventoFunil evento) {
        evento.setDataHora(LocalDateTime.now());
        return repository.save(evento);
    }

    public List<EventoFunil> findAll() {
        return repository.findAll();
    }

    public List<EventoFunil> findByTipoEvento(TipoEvento tipoEvento) {
        return repository.findByTipoEvento(tipoEvento);
    }

    public List<EventoFunil> findBySessionId(String sessionId) {
        return repository.findBySessionId(sessionId);
    }

    public IndicadoresResponse calcularIndicadores() {
        IndicadoresResponse indicadores = new IndicadoresResponse();

        long totalSessions = repository.countByTipoEvento(TipoEvento.SESSION_START);
        long quizCompleted = repository.countByTipoEvento(TipoEvento.QUIZ_COMPLETED);
        long cadastroCompleted = repository.countByTipoEvento(TipoEvento.CADASTRO_COMPLETED);
        long encaminhamentoClicked = repository.countByTipoEvento(TipoEvento.ENCAMINHAMENTO_CLICKED);

        indicadores.setTaxaConclusaoQuiz(percentual(quizCompleted, totalSessions));
        indicadores.setTaxaConversaoTotal(percentual(encaminhamentoClicked, totalSessions));

        indicadores.setPontoAbandonoPrincipal(calcularPontoAbandonoPrincipal());

        List<EventoFunil> todos = repository.findAll();

        indicadores.setMapaCalorPorCep(todos.stream()
                .filter(e -> e.getCep() != null)
                .collect(Collectors.groupingBy(EventoFunil::getCep, Collectors.counting())));

        indicadores.setRegioesComMaiorDeficit(calcularDeficitPorRegiao(indicadores.getMapaCalorPorCep()));

        java.util.OptionalDouble idadeMedia = doadoraRepository.findAll().stream()
                .filter(d -> d.getDataNascimento() != null)
                .mapToInt(d -> java.time.Period.between(d.getDataNascimento(), java.time.LocalDate.now()).getYears())
                .average();
        indicadores.setIdadeMediaDoadoras(idadeMedia.isPresent() ? idadeMedia.getAsDouble() : null);

        indicadores.setHorarioMaiorAcesso(todos.stream()
                .filter(e -> e.getDataHora() != null)
                .collect(Collectors.groupingBy(e -> e.getDataHora().getHour(), Collectors.counting())));

        indicadores.setTaxaRetorno(calcularTaxaRetorno(todos));

        Map<String, Long> motivosAlerta = quizTriagemRepository.findByMotivoAlertaIsNotNull().stream()
                .collect(Collectors.groupingBy(q -> q.getMotivoAlerta(), Collectors.counting()));
        indicadores.setMotivosAlertaQuiz(motivosAlerta);

        return indicadores;
    }

    private double percentual(long parte, long total) {
        return total == 0 ? 0.0 : (parte * 100.0) / total;
    }

    private String calcularPontoAbandonoPrincipal() {
        long maiorQueda = -1;
        String stepComMaiorAbandono = null;
        for (int step = 1; step < QUIZ_TOTAL_PERGUNTAS; step++) {
            long noStep = repository.countByTipoEventoAndStepNumber(TipoEvento.QUIZ_STEP, step);
            long noProximo = repository.countByTipoEventoAndStepNumber(TipoEvento.QUIZ_STEP, step + 1);
            long queda = noStep - noProximo;
            if (queda > maiorQueda) {
                maiorQueda = queda;
                stepComMaiorAbandono = "Pergunta " + step;
            }
        }
        return stepComMaiorAbandono;
    }

    private Map<String, Long> calcularDeficitPorRegiao(Map<String, Long> demandaPorCep) {
        return demandaPorCep.entrySet().stream()
                .filter(entry -> {
                    String prefixo = entry.getKey().substring(0, Math.min(5, entry.getKey().length()));
                    long oferta = pontoColetaRepository.countByCepStartingWith(prefixo);
                    return entry.getValue() > oferta;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private double calcularTaxaRetorno(List<EventoFunil> todos) {
        Map<Long, Long> sessionsPorDoadora = todos.stream()
                .filter(e -> e.getDoadoraId() != null)
                .collect(Collectors.groupingBy(EventoFunil::getDoadoraId,
                        Collectors.mapping(EventoFunil::getSessionId, Collectors.collectingAndThen(
                                Collectors.toSet(), set -> (long) set.size()))));

        long doadorasComRetorno = sessionsPorDoadora.values().stream().filter(qtd -> qtd > 1).count();
        return percentual(doadorasComRetorno, sessionsPorDoadora.size());
    }
}
