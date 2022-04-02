package com.sptech.dreamhouse.entidade;

public class AvaliacaoAnuncio {

    private int fkAnuncio;
    private int fkUsuario;
    private boolean ativarFavorito;
    private int notaAnuncio;
    private String comentario;

    public AvaliacaoAnuncio(int fkAnuncio, int fkUsuario,
                            boolean ativarFavorito, int notaAnuncio,
                            String comentario)
    {
        this.fkAnuncio = fkAnuncio;
        this.fkUsuario = fkUsuario;
        this.ativarFavorito = ativarFavorito;
        this.notaAnuncio = notaAnuncio;
        this.comentario = comentario;
    }

    public void setAtivarFavorito(boolean ativarFavorito) {
        this.ativarFavorito = ativarFavorito;
    }

    public int getFkAnuncio() {
        return fkAnuncio;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public boolean isAtivarFavorito() {
        return ativarFavorito;
    }

    public int getNotaAnuncio() {
        return notaAnuncio;
    }

    public String getComentario() {
        return comentario;
    }
}
