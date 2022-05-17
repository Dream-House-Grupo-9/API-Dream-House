package com.sptech.dreamhouse.estrutura;

public class ListaObj <T> {

    private T[] vetor;
    private int nroElem;

    public ListaObj(int tam) {
        vetor = (T[]) new Object[tam];
        nroElem = 0;
    }


    public void adiciona(T valor) {
        if (nroElem < vetor.length) {
            vetor[nroElem] = valor;
            nroElem++;
        } else {
            System.out.println("Você atingiu o limite da lista, não é possível adicionar um novo valor");
        }
    }


    public void exibe() {
        if (nroElem == 0) {
            System.out.println("A lista esta vazia!");
        } else {
            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
        }
    }


    public int busca(T valorABuscar) {

        if (nroElem >= 1) {
            for (int i = 0; i < nroElem; i++) {
                if (valorABuscar.equals(vetor[i])){
                    return i;
                }
            }
        }

        return -1;
    }


    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }

        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i+1];
        }
        nroElem--;
        return true;
    }


    public boolean removeElemento(T valorBuscado) {
        return removePeloIndice(busca(valorBuscado));
    }

    public boolean subistitui(T vlrAntigo, T vlrNovo){

        for(int i = 0; i < nroElem; i++){
            if(vlrAntigo.equals(vetor[i])){
                vetor[i] = vlrNovo;
                return true;
            }
        }

        return false;
    }


    public int contaOcorrencias(T valor){
        int contador = 0;

        if(nroElem < 1){
            return contador;
        }else{
            for(int i = 0; i < nroElem -1; i++){
                if(vetor[i].equals(valor)){
                    contador ++;
                }
            }

            return contador;
        }
    }

    public boolean adicionaNoInicio(T valor){
        if(nroElem < vetor.length){
            for(int i = nroElem -1;i > -1;i--){
                vetor[i + 1] = vetor[i];
            }
            vetor[0] = valor;
            nroElem ++;

            return true;
        }

        System.out.println("“Lista cheia");
        return false;
    }

    public int getTamanho(){
        return nroElem;
    }

    public T getElemento(int indice){
        if (indice < 0 || indice >= nroElem) {
            return  null;
        }
        return vetor[indice];
    }

    public void limpar(){
        nroElem = 0;
    }


}
