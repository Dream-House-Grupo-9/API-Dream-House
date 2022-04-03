package com.sptech.dreamhouse.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class DetalhesAnuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalhesAnuncio;

    private boolean ativoDiaria;
    private boolean ativoSemanal;
    private boolean ativoMensal;
    @Positive
    @NotBlank
    private double valorDiaria;
    @Positive
    @NotBlank
    private double valorSemanal;
    @Positive
    @NotBlank
    private double valorMensal;
    @Positive
    @NotBlank
    private int qtdDromitorios;
    @Positive
    @NotBlank
    private int qtdToaletes;
    private boolean garagem;
    private boolean areaDeTrabalho;
    private boolean mobiliada;
    private Integer fkAnuncio;


    public Integer getIdDetalhesAnuncio() {
        return idDetalhesAnuncio;
    }

    public void setIdDetalhesAnuncio(Integer idDetalhesAnuncio) {
        this.idDetalhesAnuncio = idDetalhesAnuncio;
    }

    public boolean isAtivoDiaria() {
        return ativoDiaria;
    }

    public void setAtivoDiaria(boolean ativoDiaria) {
        this.ativoDiaria = ativoDiaria;
    }

    public boolean isAtivoSemanal() {
        return ativoSemanal;
    }

    public void setAtivoSemanal(boolean ativoSemanal) {
        this.ativoSemanal = ativoSemanal;
    }

    public boolean isAtivoMensal() {
        return ativoMensal;
    }

    public void setAtivoMensal(boolean ativoMensal) {
        this.ativoMensal = ativoMensal;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorSemanal() {
        return valorSemanal;
    }

    public void setValorSemanal(double valorSemanal) {
        this.valorSemanal = valorSemanal;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getQtdDromitorios() {
        return qtdDromitorios;
    }

    public void setQtdDromitorios(int qtdDromitorios) {
        this.qtdDromitorios = qtdDromitorios;
    }

    public int getQtdToaletes() {
        return qtdToaletes;
    }

    public void setQtdToaletes(int qtdToaletes) {
        this.qtdToaletes = qtdToaletes;
    }

    public boolean isGaragem() {
        return garagem;
    }

    public void setGaragem(boolean garagem) {
        this.garagem = garagem;
    }

    public boolean isAreaDeTrabalho() {
        return areaDeTrabalho;
    }

    public void setAreaDeTrabalho(boolean areaDeTrabalho) {
        this.areaDeTrabalho = areaDeTrabalho;
    }

    public boolean isMobiliada() {
        return mobiliada;
    }

    public void setMobiliada(boolean mobiliada) {
        this.mobiliada = mobiliada;
    }

    public Integer getFkAnuncio() {
        return fkAnuncio;
    }

    public void setFkAnuncio(Integer fkAnuncio) {
        this.fkAnuncio = fkAnuncio;
    }
}
