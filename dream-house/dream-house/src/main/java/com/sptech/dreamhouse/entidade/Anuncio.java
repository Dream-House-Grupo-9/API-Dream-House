package com.sptech.dreamhouse.entidade;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private LocalDate inicioDisponibilidade;
    private LocalDate finalDisponibilidade;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 60)
    private String cidade;
    @NotBlank
    @NotNull
    @Length(min = 3, max = 60)
    private String bairro;
    @NotBlank
    @NotNull
    @Length(min = 8, max = 60)
    private String lougadoro;
    @Positive
    @NotBlank
    @NotNull
    @Length( max = 10)
    private String numero;
    @NotNull
    private int fkCategoria;
    @NotNull
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
