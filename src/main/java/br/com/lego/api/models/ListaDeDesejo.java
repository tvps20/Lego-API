package br.com.lego.api.models;

import javax.persistence.*;


@Entity
@Table(name = "listas_de_desejos")
public class ListaDeDesejo extends AbstractEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "listaDeDesejoId")
    private java.util.Set<Set> listaDeSets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "listasDeDesejos")
    private java.util.Set<Documento> listasDeDocumentos;


    // Getters and Setters
    public java.util.Set<Set> getListaDeSets() {
        return listaDeSets;
    }

    public void setListaDeSets(java.util.Set<Set> listaDeSets) {
        this.listaDeSets = listaDeSets;
    }

    public java.util.Set<Documento> getListasDeDocumentos() {
        return listasDeDocumentos;
    }

    public void setListasDeDocumentos(java.util.Set<Documento> listasDeDocumentos) {
        this.listasDeDocumentos = listasDeDocumentos;
    }
}
