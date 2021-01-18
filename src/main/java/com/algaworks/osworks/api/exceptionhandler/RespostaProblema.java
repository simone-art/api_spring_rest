package com.algaworks.osworks.api.exceptionhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RespostaProblema {

    private Integer status;
    private LocalDateTime dataHora;
    private String mensagem;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
