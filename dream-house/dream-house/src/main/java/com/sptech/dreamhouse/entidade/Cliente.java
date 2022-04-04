package com.sptech.dreamhouse.entidade;

<<<<<<< HEAD
=======
import org.hibernate.validator.constraints.Length;
>>>>>>> dev-anderson
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.validation.constraints.*;
=======
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
>>>>>>> dev-anderson
import java.time.LocalDate;

@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
<<<<<<< HEAD
    @CPF
    private String cpf;
    @PastOrPresent
    @NotNull
    private LocalDate dtNascimento;
    @NotBlank
    @Email
=======

    @CPF
    @NotBlank
    @Length(min = 11)
    private String cpf;
    @Past
    @NotBlank
    private LocalDate dtNascimento;
    @Email
    @NotBlank
    @Length(min = 11, max = 50)
>>>>>>> dev-anderson
    private String email;

    @NotBlank
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
            message = "Informe um telefone válido com ou sem ddd")
    @Length(min = 15, max = 20)

    private String telefone;
<<<<<<< HEAD
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})", message = "Informe um telefone válido com ou sem DDD")
=======
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
            message = "Informe um telefone válido com ou sem ddd")
    @NotBlank
    @Length(min = 15, max = 20)
>>>>>>> dev-anderson
    private String whatsapp;


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

}
