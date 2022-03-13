package com.sptech.dreamhouse.entidade;

public class DetalhesAnuncio {

    private int idDetalhesAnuncio;
    private int ativoDiaria;
    private int ativoSemanal;
    private int ativoMensal;
    private double valoDiaria;
    private double valoSemanal;
    private double valoMensal;
    private int qtdDromitorios;
    private int qtdToaletes;
    private boolean garagem;
    private boolean areaDeTrabalho;
    private boolean mobiliada;
    private int fkAnuncio;


    public DetalhesAnuncio(int idDetalhesAnuncio, int ativoDiaria,
                           int ativoSemanal, int ativoMensal,
                           double valoDiaria, double valoSemanal,
                           double valoMensal, int qtdDromitorios,
                           int qtdToaletes, boolean garagem,
                           boolean areaDeTrabalho,
                           boolean mobiliada, int fkAnuncio)
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

    public int getAtivoDiaria() {
        return ativoDiaria;
    }

    public int getAtivoSemanal() {
        return ativoSemanal;
    }

    public int getAtivoMensal() {
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

    public int getFkAnuncio() {
        return fkAnuncio;
    }
}
