package br.com.lego.api.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "modelos_de_documentos")
public class ModeloDeDocumento extends AbstractEntity {

    @Column(name = "historico_compras")
    private boolean historicoDeCompras;

    @Column(name = "listas_sets")
    private boolean listaDeSets;

    @Column(name = "litas_desejo")
    private boolean listaDeDesejo;

    @Column(name = "listas_pecas")
    private boolean listaDePecas;

    private boolean descricao;


    // Getters and Setters
    public boolean isHistoricoDeCompras() {
        return historicoDeCompras;
    }

    public void setHistoricoDeCompras(boolean historicoDeCompras) {
        this.historicoDeCompras = historicoDeCompras;
    }

    public boolean isListaDeSets() {
        return listaDeSets;
    }

    public void setListaDeSets(boolean listaDeSets) {
        this.listaDeSets = listaDeSets;
    }

    public boolean isListaDeDesejo() {
        return listaDeDesejo;
    }

    public void setListaDeDesejo(boolean listaDeDesejo) {
        this.listaDeDesejo = listaDeDesejo;
    }

    public boolean isDescricao() {
        return descricao;
    }

    public void setDescricao(boolean descricao) {
        this.descricao = descricao;
    }

    public boolean isListaDePecas() {
        return listaDePecas;
    }

    public void setListaDePecas(boolean listaDePecas) {
        this.listaDePecas = listaDePecas;
    }
}
