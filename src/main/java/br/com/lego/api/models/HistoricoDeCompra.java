package br.com.lego.api.models;


import javax.persistence.*;

@Entity
@Table(name = "historicos_de_compras")
public class HistoricoDeCompra extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "historicoDeCompra")
    private Set set;
    private double preco;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "listasDeCompras")
    private java.util.Set<Documento> listasDeDocumentos;


    // Contrutores
    public HistoricoDeCompra(Set set, double preco) {
        this.set = set;
        this.preco = preco;
    }

    public HistoricoDeCompra() {
    }


    // Getters and Setters
    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public java.util.Set<Documento> getListasDeDocumentos() {
        return listasDeDocumentos;
    }

    public void setListasDeDocumentos(java.util.Set<Documento> listasDeDocumentos) {
        this.listasDeDocumentos = listasDeDocumentos;
    }
}
