package br.com.lego.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Entity(name = "Set")
@Table(name = "sets")
public class Set extends AbstractEntity {

    @NotEmpty
    @Size(max = 100)
    @Column(unique = true)
    private String nome;

    private int ano;
    private double preco;


    @Column(name = "lista_desejo_id")
    private Long listaDeDesejoId;

    @OneToMany(mappedBy = "setId", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Peca> listaDePecas;

    @OneToMany(mappedBy = "setImagemId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Imagem> listaDeImagens;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH , mappedBy = "set")
    @JsonIgnore
    private HistoricoDeCompra historicoDeCompra;



    // Contrutores
    public Set(String nome) {
        this.nome = nome;
    }

    public Set() {
    }


    /// Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Peca> getListaDePecas() {
        return listaDePecas;
    }

    public void setListaDePecas(List<Peca> listaDePecas) {
        this.listaDePecas = listaDePecas;
    }

    public List<Imagem> getListaDeImagens() {
        return listaDeImagens;
    }

    public void setListaDeImagens(List<Imagem> listaDeImagens) {
        this.listaDeImagens = listaDeImagens;
    }

    public Long getListaDeDesejoId() {
        return listaDeDesejoId;
    }

    public void setListaDeDesejoId(Long listaDeDesejoId) {
        this.listaDeDesejoId = listaDeDesejoId;
    }

    public HistoricoDeCompra getHistoricoDeCompra() {
        return historicoDeCompra;
    }

    public void setHistoricoDeCompra(HistoricoDeCompra historicoDeCompra) {
        this.historicoDeCompra = historicoDeCompra;
    }

}
