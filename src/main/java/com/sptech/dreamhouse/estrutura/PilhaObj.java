package com.sptech.dreamhouse.estrutura;

public class PilhaObj<T> {

    private Integer topo;
    private T[] pilha;

    public PilhaObj(Integer tamanhoPilha) {
        topo = -1;
        pilha = (T[]) new Object[tamanhoPilha];
    }

    public boolean isEmpyt() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(T valor) {
        if (isFull()) {
            System.out.println("\nA pilha esta cheia!\n");
        } else {
            pilha[++topo] = valor;
        }

    }

    public T pop() {
        if (isEmpyt()) {
            return null;
        }

        return pilha[topo--];
    }

    public T peek() {
        if (isEmpyt()) {
            return null;
        }

        return pilha[topo];
    }

    public void exibe() {
        if (isEmpyt()) {
            System.out.println("\nA pilha esta vazia!\n");
        } else {
            for (int i = 0; i <= topo; i++) {
                System.out.println(pilha[i]);
            }

            System.out.println("\n");
        }
    }
}
