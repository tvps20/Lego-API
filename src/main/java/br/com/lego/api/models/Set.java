package br.com.lego.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "sets")
public class Set extends AbstractEntity {
    @NotEmpty
    @Size(max = 100)
    @Column(unique = true)
    private String nome;
    private int ano;
    private double preco;

    @Column(name = "qtd_pecas")
    private int qtdPecas;

    @Column(name = "lista_desejo_id")
    private Long listaDeDesejoId;

    @OneToMany(mappedBy = "setId", fetch = FetchType.LAZY)
    private java.util.Set<Peca> pecaList;

    @OneToMany(mappedBy = "setImagemId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private java.util.Set<Imagem> imagemList;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "compra_id", nullable = false)
    private HistoricoDeCompra historicoDeCompra;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "listaDeSets")
    private java.util.Set<Documento> listasDeDocumentos;


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

    public int getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(int qtdPecas) {
        this.qtdPecas = qtdPecas;
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

    public java.util.Set<Peca> getPecaList() {
        return pecaList;
    }

    public void setPecaList(java.util.Set<Peca> pecaList) {
        this.pecaList = pecaList;
    }

    public java.util.Set<Imagem> getImagemList() {
        return imagemList;
    }

    public void setImagemList(java.util.Set<Imagem> imagemList) {
        this.imagemList = imagemList;
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
