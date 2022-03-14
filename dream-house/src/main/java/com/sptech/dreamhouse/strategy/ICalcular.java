package com.sptech.dreamhouse.strategy;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;

import java.util.List;

public interface ICalcular {
    public double calcularPorPeriodo(DetalhesAnuncio d, Integer qtdlocacao);
}


