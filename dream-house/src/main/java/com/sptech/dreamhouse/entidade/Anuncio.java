package com.sptech.dreamhouse.entidade;

import java.time.LocalDate;

public class Anuncio {
    private int idAnuncio;
    private LocalDate dtPublicacao;
    private String descricao;
    private LocalDate inicioDisponibilidade;
    private LocalDate finalDisponibilidade;
    private String cidade;
    private String bairro;
    private String lougadoro;
    private String numero;
    private int fkCategoria;
    private int fkCliente;

    public Anuncio(int idAnuncio, LocalDate dtPublicacao,
                   String descricao, LocalDate inicioDisponibilidade,
                   LocalDate finalDisponibilidade, String cidade,
                   String bairro, String lougadoro,
                   String numero, int fkCategoria, int fkCliente)
    {
        this.idAnuncio = idAnuncio;
        this.dtPublicacao = dtPublicacao;
        this.descricao = descricao;
        this.inicioDisponibilidade = inicioDisponibilidade;
        this.finalDisponibilidade = finalDisponibilidade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.lougadoro = lougadoro;
        this.numero = numero;
        this.fkCategoria = fkCategoria;
        this.fkCliente = fkCliente;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public LocalDate getDtPublicacao() {
        return dtPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getInicioDisponibilidade() {
        return inicioDisponibilidade;
    }

    public LocalDate getFinalDisponibilidade() {
        return finalDisponibilidade;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLougadoro() {
        return lougadoro;
    }

    public String getNumero() {
        return numero;
    }

    public int getFkCategoria() {
        return fkCategoria;
    }

    public int getFkCliente() {
        return fkCliente;
    }
}
