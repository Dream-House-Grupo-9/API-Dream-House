package com.sptech.dreamhouse.obsever;

import java.util.ArrayList;

public class Subescreve {

    ArrayList<Obsever> observadores = new ArrayList<>();


    public void addObservador(Obsever obs){
        if(!observadores.contains(obs)){

            observadores.add(obs);
        }
    }

    public void deleteObservador(Obsever obs){
        observadores.remove(obs);
    }

    public void notificarObs(){
        for (Obsever obs : observadores) {
            obs.enviaNotificacao();
        }
    }


}
