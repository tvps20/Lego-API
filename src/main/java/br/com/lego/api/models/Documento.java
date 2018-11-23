package br.com.lego.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "documentos")
public class Documento extends AbstractEntity {

    private String cabecalho;
    private String titulo;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "modelo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ModeloDeDocumento modeloDeDocumento;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "documentos_compras",
            joinColumns = {@JoinColumn(name = "documento_id")},
            inverseJoinColumns = {@JoinColumn(name = "compra_id")})
    private java.util.Set<HistoricoDeCompra> listasDeCompras;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "documentos_sets",
            joinColumns = {@JoinColumn(name = "documento_id")},
            inverseJoinColumns = {@JoinColumn(name = "set_id")})
    private java.util.Set<br.com.lego.api.models.Set> listaDeSets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "documentos_desejos",
            joinColumns = {@JoinColumn(name = "documento_id")},
            inverseJoinColumns = {@JoinColumn(name = "desejo_id")})
    private java.util.Set<ListaDeDesejo> listasDeDesejos;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "documentos_pecas",
            joinColumns = {@JoinColumn(name = "documento_id")},
            inverseJoinColumns = {@JoinColumn(name = "pecas_id")})
    private java.util.Set<Peca> listaDePecas;


    // Contrutores
    public Documento(String titulo) {
        this.titulo = titulo;
    }

    public Documento() {
    }


    // Getters and Setters
    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ModeloDeDocumento getModeloDeDocumento() {
        return modeloDeDocumento;
    }

    public void setModeloDeDocumento(ModeloDeDocumento modeloDeDocumento) {
        this.modeloDeDocumento = modeloDeDocumento;
    }

    public Set<HistoricoDeCompra> getListasDeCompras() {
        return listasDeCompras;
    }

    public void setListasDeCompras(Set<HistoricoDeCompra> listasDeCompras) {
        this.listasDeCompras = listasDeCompras;
    }

    public Set<br.com.lego.api.models.Set> getListaDeSets() {
        return listaDeSets;
    }

    public void setListaDeSets(Set<br.com.lego.api.models.Set> listaDeSets) {
        this.listaDeSets = listaDeSets;
    }

    public Set<ListaDeDesejo> getListasDeDesejos() {
        return listasDeDesejos;
    }

    public void setListasDeDesejos(Set<ListaDeDesejo> listasDeDesejos) {
        this.listasDeDesejos = listasDeDesejos;
    }

    public Set<Peca> getListaDePecas() {
        return listaDePecas;
    }

    public void setListaDePecas(Set<Peca> listaDePecas) {
        this.listaDePecas = listaDePecas;
    }
}
