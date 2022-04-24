package com.sptech.dreamhouse.obsever;



public class ObservaAnuncio implements Obsever{


    @Override
    public void enviaNotificacao() {
        System.out.println("Seu anuncio foi cadastrado com sucesso!");
    }
}
