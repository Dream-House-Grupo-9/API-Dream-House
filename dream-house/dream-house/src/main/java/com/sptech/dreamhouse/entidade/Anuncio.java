package com.sptech.dreamhouse.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
            message = "Informe um telefone válido com ou sem ddd")
    private String telefoneLocatario;

    @PastOrPresent
    private LocalDate dtPublicacao;

    @Length(min = 10, max = 300)
    @NotBlank
    private String descricao;

    @FutureOrPresent
    private LocalDate inicioDisponibilidade;

    @FutureOrPresent
    private LocalDate finalDisponibilidade;

    @NotBlank
    @Length(min = 3, max = 60)
    private String cidade;

    @NotBlank
    @Length(min = 3, max = 60)
    private String bairro;

    @NotBlank
    @Length(min = 8, max = 60)
    private String logradouro;

    @Positive
//    @Length( max = 10)
    private int numero;

    @JsonIgnore
    @Column(length = 50 * 1024 * 1024) // 50 Mb
    private byte[] foto;

    @ManyToOne
    @NotNull
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private DetalhesAnuncio detalhe;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalhesAnuncio getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(DetalhesAnuncio detalhe) {
        this.detalhe = detalhe;
    }

    public Integer getId() { return id;}

    public void setId(Integer id) {this.id = id;}

    public String getTelefoneLocatario() {
        return telefoneLocatario;
    }

    public void setTelefoneLocatario(String telefoneLocatario) {
        this.telefoneLocatario = telefoneLocatario;
    }

    public LocalDate getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(LocalDate dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getInicioDisponibilidade() {
        return inicioDisponibilidade;
    }

    public void setInicioDisponibilidade(LocalDate inicioDisponibilidade) {
        this.inicioDisponibilidade = inicioDisponibilidade;
    }

    public LocalDate getFinalDisponibilidade() {
        return finalDisponibilidade;
    }

    public void setFinalDisponibilidade(LocalDate finalDisponibilidade) {
        this.finalDisponibilidade = finalDisponibilidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
