package com.sptech.dreamhouse.observer;

import java.util.ArrayList;

public class Subscreve {

    ArrayList<Observer> observadores = new ArrayList<>();


    public void addObservador(Observer obs){
        if(!observadores.contains(obs)){

            observadores.add(obs);
        }
    }

    public void deleteObservador(Observer obs){
        observadores.remove(obs);
    }

    public void notificarObs(){
        for (Observer obs : observadores) {
            obs.enviaNotificacao();
        }
    }


}
