package com.sptech.dreamhouse.strategy;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;

import java.util.List;

public class Mensal implements ICalcular{

    public double calcularPorPeriodo(DetalhesAnuncio d, Integer qtdlocacao) {

        return d.getValoMensal() * qtdlocacao;
    }
}
