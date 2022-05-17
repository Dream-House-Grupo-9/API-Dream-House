package com.sptech.dreamhouse.estrutura;

public class FilaObj<T> {

    private int tamanho;
    private T[] fila;


    public FilaObj(int capacidade) {
        fila = (T[]) new Object[capacidade];
        tamanho = 0;
    }


    public boolean isEmpty() {
        return tamanho == 0;
    }


    public boolean isFull() {
        return tamanho == fila.length;
    }


    public void insert(T info) {
        if (!isFull()) {
            fila[tamanho++] = info;
        } else {
            throw new IllegalStateException("Fila Cheia");
        }
    }


    public T peek() {
        return fila[0];
    }


    public T poll() {
        if (!isEmpty()) {

            T retorno = fila[0];

            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[tamanho - 1] = null;

            tamanho--;

            return retorno;
        }
        return null;
    }


    public ListaObj<T> exibe() {
        ListaObj<T> exibeFila = new ListaObj<>(tamanho);

        for (int i = 0; i < tamanho; i++) {
            exibeFila.adiciona(fila[i]);
        }

        return exibeFila;
    }

    public int getTamanho() {
        return tamanho;
    }

}
