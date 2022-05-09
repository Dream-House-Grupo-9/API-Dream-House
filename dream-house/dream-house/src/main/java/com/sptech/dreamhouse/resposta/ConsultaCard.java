package com.sptech.dreamhouse.resposta;

public class ConsultaCard {

    private String urlImg;
    private String cidade;
    private double valorMensal;


    public ConsultaCard(String urlImg, String cidade, double valorMensal) {
        this.urlImg = urlImg;
        this.cidade = cidade;
        this.valorMensal = valorMensal;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }
}
