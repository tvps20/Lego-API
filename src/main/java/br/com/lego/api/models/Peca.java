package br.com.lego.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;


@Entity(name = "Peca")
@Table(name = "pecas")
public class Peca extends AbstractEntity {

    @NotNull
    @Column(name = "num_peca")
    private int numPeca;

    private String cor;
    private String descricao;

    @Column(name = "set_id", nullable = false)
    private Long setId;

    @OneToMany(mappedBy = "pecaImagemId")
    private List<Imagem> imagemList;


    // Contrutores
    public Peca(int numPeca) {
        this.numPeca = numPeca;
    }

    public Peca() {
    }


    // Getters and Setters
    public int getNumPeca() {
        return numPeca;
    }

    public void setNumPeca(int numPeca) {
        this.numPeca = numPeca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Imagem> getImagemList() {
        return imagemList;
    }

    public void setImagemList(List<Imagem> imagemList) {
        this.imagemList = imagemList;
    }

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }
}
