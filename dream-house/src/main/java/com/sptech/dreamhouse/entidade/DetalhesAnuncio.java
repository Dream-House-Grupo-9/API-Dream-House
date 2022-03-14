package com.sptech.dreamhouse.entidade;

public class DetalhesAnuncio {

    private int idDetalhesAnuncio;
    private boolean ativoDiaria;
    private boolean ativoSemanal;
    private boolean ativoMensal;
    private double valoDiaria;
    private double valoSemanal;
    private double valoMensal;
    private int qtdDromitorios;
    private int qtdToaletes;
    private boolean garagem;
    private boolean areaDeTrabalho;
    private boolean mobiliada;
    private Integer fkAnuncio;


    public DetalhesAnuncio(int idDetalhesAnuncio, boolean ativoDiaria,
                           boolean ativoSemanal, boolean ativoMensal,
                           double valoDiaria, double valoSemanal,
                           double valoMensal, int qtdDromitorios,
                           int qtdToaletes, boolean garagem,
                           boolean areaDeTrabalho,
                           boolean mobiliada, Integer fkAnuncio)
    {
        this.idDetalhesAnuncio = idDetalhesAnuncio;
        this.ativoDiaria = ativoDiaria;
        this.ativoSemanal = ativoSemanal;
        this.ativoMensal = ativoMensal;
        this.valoDiaria = valoDiaria;
        this.valoSemanal = valoSemanal;
        this.valoMensal = valoMensal;
        this.qtdDromitorios = qtdDromitorios;
        this.qtdToaletes = qtdToaletes;
        this.garagem = garagem;
        this.areaDeTrabalho = areaDeTrabalho;
        this.mobiliada = mobiliada;
        this.fkAnuncio = fkAnuncio;
    }

    public int getIdDetalhesAnuncio() {
        return idDetalhesAnuncio;
    }

    public boolean isAtivoDiaria() {
        return ativoDiaria;
    }

    public boolean isAtivoSemanal() {
        return ativoSemanal;
    }

    public boolean isAtivoMensal() {
        return ativoMensal;
    }

    public double getValoDiaria() {
        return valoDiaria;
    }

    public double getValoSemanal() {
        return valoSemanal;
    }

    public double getValoMensal() {
        return valoMensal;
    }

    public int getQtdDromitorios() {
        return qtdDromitorios;
    }

    public int getQtdToaletes() {
        return qtdToaletes;
    }

    public boolean isGaragem() {
        return garagem;
    }

    public boolean isAreaDeTrabalho() {
        return areaDeTrabalho;
    }

    public boolean isMobiliada() {
        return mobiliada;
    }

    public Integer getFkAnuncio() {
        return fkAnuncio;
    }
}
