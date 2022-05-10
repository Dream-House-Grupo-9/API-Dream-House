package com.sptech.dreamhouse.entidade;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity

public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnuncio;

    @PastOrPresent
    private LocalDate dtPublicacao;

    @Length(min = 20, max = 300)
    @NotBlank
    private String descricao;

    @FutureOrPresent
    private LocalDate inicioDisponibilidade;

    @FutureOrPresent
    private LocalDate finalDisponibilidade;

    @NotBlank
    @Length(min = 3, max = 60)
    private String cidade;

    @NotBlank
    @Length(min = 3, max = 60)
    private String bairro;

    @NotBlank
    @Length(min = 8, max = 60)
    private String logradouro;

    @Positive
//    @Length( max = 10)
    private int numero;

    public Anuncio(Integer idAnuncio, String dtPublicacao, String descricao, String inicioDisponibilidade,
                   String finalDisponibilidade, String cidade, String bairro, String logradouro, Integer numero) {
    }


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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public String getLogradouro() {
        return logradouro;
    }

}
