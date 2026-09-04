package br.com.fiap.lactare_doador_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pesquisas_satisfacao")
public class PesquisaSatisfacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "doadora_id", nullable = false)
    private Long doadoraId;

    @Column(name = "doacao_id")
    private Long doacaoId;

    @Column(nullable = false)
    private Integer nota;

    @Column(length = 500)
    private String comentario;

    @Column(name = "data_resposta", nullable = false)
    private LocalDateTime dataResposta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoadoraId() {
        return doadoraId;
    }

    public void setDoadoraId(Long doadoraId) {
        this.doadoraId = doadoraId;
    }

    public Long getDoacaoId() {
        return doacaoId;
    }

    public void setDoacaoId(Long doacaoId) {
        this.doacaoId = doacaoId;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(LocalDateTime dataResposta) {
        this.dataResposta = dataResposta;
    }
}
