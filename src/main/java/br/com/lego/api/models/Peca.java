package br.com.lego.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
@Table(name = "pecas")
public class Peca extends AbstractEntity {
    @NotEmpty
    @Column(name = "num_peca")
    private int numPeca;
    private String cor;
    private String descricao;
    @Column(name = "set_id")
    private Long setId;
    @OneToMany(mappedBy = "pecaImagemId")
    private java.util.Set<Imagem> imagemList;


    public Peca(int numPeca) {
        this.numPeca = numPeca;
    }

    public Peca() {
    }

    //getters and setters
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

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public Set<Imagem> getImagemList() {
        return imagemList;
    }

    public void setImagemList(Set<Imagem> imagemList) {
        this.imagemList = imagemList;
    }
}
