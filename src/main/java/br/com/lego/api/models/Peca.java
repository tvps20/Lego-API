package br.com.lego.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


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

    @OneToMany(mappedBy = "pecaImagemId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Imagem> listaDeImagens;


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

    public List<Imagem> getListaDeImgens() {
        return listaDeImagens;
    }

    public void setListaDeImgens(List<Imagem> listaDeImgens) {
        this.listaDeImagens = listaDeImgens;
    }

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }
}
