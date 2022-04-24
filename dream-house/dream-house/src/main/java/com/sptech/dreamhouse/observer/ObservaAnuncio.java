package com.sptech.dreamhouse.observer;



public class ObservaAnuncio implements Observer {


    @Override
    public void enviaNotificacao() {
        System.out.println("Seu anuncio foi cadastrado com sucesso!");
    }
}
