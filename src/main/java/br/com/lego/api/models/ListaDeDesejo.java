package br.com.lego.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "listas_de_desejos")
public class ListaDeDesejo extends AbstractEntity {

    @NotEmpty
    private String nome;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "listaDeDesejoId")
    private java.util.Set<Set> listaDeSets;


    // Getters and Setters
    public java.util.Set<Set> getListaDeSets() {
        return listaDeSets;
    }

    public void setListaDeSets(java.util.Set<Set> listaDeSets) {
        this.listaDeSets = listaDeSets;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
