package br.com.lego.api.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "modelos_de_documentos")
public class ModeloDeDocumento extends AbstractEntity{

    private boolean nome;
    private boolean historicoDeCompras;
    private boolean listaDeSets;
    private boolean listaDeDesejo;
    private boolean descricao;
    private boolean imagens;

    //getters and setters
    public boolean isNome() {
        return nome;
    }

    public void setNome(boolean nome) {
        this.nome = nome;
    }

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

    public boolean isImagens() {
        return imagens;
    }

    public void setImagens(boolean imagens) {
        this.imagens = imagens;
    }
}
