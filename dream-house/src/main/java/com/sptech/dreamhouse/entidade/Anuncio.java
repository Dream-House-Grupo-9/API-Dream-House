package com.sptech.dreamhouse.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity

public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnuncio;

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
