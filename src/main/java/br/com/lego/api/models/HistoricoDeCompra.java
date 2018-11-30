package br.com.lego.api.models;


import javax.persistence.*;

@Entity
@Table(name = "historicos_de_compras")
public class HistoricoDeCompra extends AbstractEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "set_id", nullable = false)
    private Set set;

    private double preco;


    // Contrutores
    public HistoricoDeCompra(Set set) {
        this.set = set;
        this.preco = set.getPreco();
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
}
