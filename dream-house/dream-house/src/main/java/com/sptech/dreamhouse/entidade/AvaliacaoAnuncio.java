package com.sptech.dreamhouse.entidade;

import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AvaliacaoAnuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvaliacao;

    private int fkAnuncio;
    private int fkUsuario;
    private boolean ativarFavorito;

    @NotNull
    @Positive
    @Length (min = 1, max = 5)
    private int notaAnuncio;


    @Length(min = 15, max = 200)
    @NotBlank
    private String comentario;


    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getFkAnuncio() {
        return fkAnuncio;
    }

    public void setFkAnuncio(int fkAnuncio) {
        this.fkAnuncio = fkAnuncio;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public boolean isAtivarFavorito() {
        return ativarFavorito;
    }

    public void setAtivarFavorito(boolean ativarFavorito) {
        this.ativarFavorito = ativarFavorito;
    }

    public int getNotaAnuncio() {
        return notaAnuncio;
    }

    public void setNotaAnuncio(int notaAnuncio) {
        this.notaAnuncio = notaAnuncio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
