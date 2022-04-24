package planekeys.com.dreamhouse.exportacao;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String dtPublicacao;

    @NotBlank
    @Length(min = 7, max = 120)
    private String descricao;

    @NotNull
    @NotBlank
    private String inicioDisponibilidade;

    @NotNull
    @NotBlank
    private String fimDisponibilidade;

    @NotBlank
    @NotNull
    private String cidade;

    @NotNull
    private String bairro;

    @NotNull
    private String logradouro;

    @Positive
    private String numero;

    @NotNull
    @Size(max = 5)
    private String notaAnuncio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(String dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInicioDisponibilidade() {
        return inicioDisponibilidade;
    }

    public void setInicioDisponibilidade(String inicioDisponibilidade) {
        this.inicioDisponibilidade = inicioDisponibilidade;
    }

    public String getFimDisponibilidade() {
        return fimDisponibilidade;
    }

    public void setFimDisponibilidade(String fimDisponibilidade) {
        this.fimDisponibilidade = fimDisponibilidade;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNotaAnuncio() {
        return notaAnuncio;
    }

    public void setNotaAnuncio(String notaAnuncio) {
        this.notaAnuncio = notaAnuncio;
    }
}
