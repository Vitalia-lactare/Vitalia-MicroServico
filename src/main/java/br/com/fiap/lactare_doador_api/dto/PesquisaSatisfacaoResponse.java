package br.com.fiap.lactare_doador_api.dto;

import java.time.LocalDateTime;

public class PesquisaSatisfacaoResponse {

    private Long id;
    private Long doadoraId;
    private Long doacaoId;
    private Integer nota;
    private String comentario;
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
