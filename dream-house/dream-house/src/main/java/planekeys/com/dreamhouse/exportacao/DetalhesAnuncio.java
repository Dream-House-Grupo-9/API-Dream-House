package planekeys.com.dreamhouse.exportacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

@Entity
public class DetalhesAnuncio {

    @Id // do pacote javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean ativoDiaria;
    private boolean ativoSemanal;
    private boolean ativoMensal;
    private boolean garagem;
    private boolean mobiliada;

    @Positive
    private Double valorDiaria;

    @Positive
    private Double valorSemanal;

    @Positive
    private Double valorMensal;

    @Positive
    private Integer qtdDormitorios;

    @Positive
    private Integer qtdToaletes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAtivoDiaria() {
        return ativoDiaria;
    }

    public void setAtivoDiaria(boolean ativoDiaria) {
        this.ativoDiaria = ativoDiaria;
    }

    public boolean isAtivoSemanal() {
        return ativoSemanal;
    }

    public void setAtivoSemanal(boolean ativoSemanal) {
        this.ativoSemanal = ativoSemanal;
    }

    public boolean isAtivoMensal() {
        return ativoMensal;
    }

    public void setAtivoMensal(boolean ativoMensal) {
        this.ativoMensal = ativoMensal;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Double getValorSemanal() {
        return valorSemanal;
    }

    public void setValorSemanal(Double valorSemanal) {
        this.valorSemanal = valorSemanal;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Integer getQtdDormitorios() {
        return qtdDormitorios;
    }

    public void setQtdDormitorios(Integer qtdDormitorios) {
        this.qtdDormitorios = qtdDormitorios;
    }

    public Integer getQtdToaletes() {
        return qtdToaletes;
    }

    public void setQtdToaletes(Integer qtdToaletes) {
        this.qtdToaletes = qtdToaletes;
    }

    public boolean isGaragem() {
        return garagem;
    }

    public void setGaragem(boolean garagem) {
        this.garagem = garagem;
    }

    public boolean isMobiliada() {
        return mobiliada;
    }

    public void setMobiliada(boolean mobiliada) {
        this.mobiliada = mobiliada;
    }
}
