package br.com.lego.api.models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "documentos")
public class Documento extends AbstractEntity {

    private String cabecalho;
    private String titulo;
    private String descricao;

    @Column(name = "modelo_id")
    private Long modeloId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "documentos_desejos",
            joinColumns = {@JoinColumn(name = "documento_id")},
            inverseJoinColumns = {@JoinColumn(name = "desejo_id")})
    private java.util.Set<ListaDeDesejo> listasDeDesejos;



    // Contrutores
    // TO DO: Trocar titulo pelo modelo
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

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }


    public Set<ListaDeDesejo> getListasDeDesejos() {
        return listasDeDesejos;
    }

    public void setListasDeDesejos(Set<ListaDeDesejo> listasDeDesejos) {
        this.listasDeDesejos = listasDeDesejos;
    }

}
