package br.com.lego.api.models;


import javax.persistence.*;

@Entity
@Table(name = "historicos_de_compras")
public class HistoricoDeCompra extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "historicoDeCompra")
    private Set set;
    private double preco;

    public HistoricoDeCompra(Set set, double preco) {
        this.set = set;
        this.preco = preco;
    }

    public HistoricoDeCompra() {
    }

    //getters and setters

}
