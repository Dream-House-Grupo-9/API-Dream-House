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

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public void setDtPublicacao(LocalDate dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setInicioDisponibilidade(LocalDate inicioDisponibilidade) {
        this.inicioDisponibilidade = inicioDisponibilidade;
    }

    public void setFinalDisponibilidade(LocalDate finalDisponibilidade) {
        this.finalDisponibilidade = finalDisponibilidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLougadoro(String lougadoro) {
        this.lougadoro = lougadoro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setFkCategoria(int fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    public void setFkCliente(int fkCliente) {
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
