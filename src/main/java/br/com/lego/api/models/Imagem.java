package br.com.lego.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "imagens")
public class Imagem extends AbstractEntity {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String path;

    @Column(name = "set_imagem_id")
    private Long setImagemId;

    @Column(name = "peca_imagem_id")
    private Long pecaImagemId;


    // Contrutores
    public Imagem(String nome, String path) {
        this.nome = nome;
        this.path = path;
    }

    public Imagem() {
    }


    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSetImagemId() {
        return setImagemId;
    }

    public void setSetImagemId(Long setImagemId) {
        this.setImagemId = setImagemId;
    }

    public Long getPecaImagemId() {
        return pecaImagemId;
    }

    public void setPecaImagemId(Long pecaImagemId) {
        this.pecaImagemId = pecaImagemId;
    }
}
