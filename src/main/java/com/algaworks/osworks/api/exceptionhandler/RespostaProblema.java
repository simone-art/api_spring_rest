package com.algaworks.osworks.api.exceptionhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class RespostaProblema {

    private Integer status;
    private LocalDateTime dataHora;
    private String mensagem;
    private List<Campo> campos;

    public static class Campo{
        private String nome;
        private String mensagemCampo;

        //Feito constructoer para pegar o nome e a mensagem do campo
        public Campo(String nome, String mensagemCampo) {
            this.nome = nome;
            this.mensagemCampo = mensagemCampo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMensagemCampo() {
            return mensagemCampo;
        }

        public void setMensagemCampo(String mensagemCampo) {
            this.mensagemCampo = mensagemCampo;
        }
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

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
