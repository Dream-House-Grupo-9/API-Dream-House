package com.sptech.dreamhouse.entidade;

import java.time.LocalDate;

public class Cliente {
    private int idCliente;
    private String cpf;
    private LocalDate dtNascimento;
    private String email;
    private String telefone;
    private String whatsapp;

    public Cliente(int idCliente, String cpf,
                   LocalDate dtNascimento, String email,
                   String telefone, String whatsapp)
    {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.telefone = telefone;
        this.whatsapp = whatsapp;
    }



    public LocalDate getDtNascimento() {return dtNascimento;}

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public int getIdCliente() {
        return idCliente;
    }


}
