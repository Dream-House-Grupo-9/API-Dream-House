package com.sptech.dreamhouse.entidade;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private boolean autenticado;


    public Usuario(int idUsuario, String nome, String email, String senha, boolean autenticado) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.autenticado = autenticado;
    }

    public boolean autenticarUsuario(String email, String senha) {
        if (email.equals(this.email) && email.equals(this.senha)) {
            return true;
        }
        return false;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}


