package com.sptech.dreamhouse.resposta;



public class CardAnuncioViews {


     private String bairro;

     private String cidade;

     private double valorAluguel;


    public CardAnuncioViews(String bairro, String cidade, double valorAluguel) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.valorAluguel = valorAluguel;
    }



    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }
}
