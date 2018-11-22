package br.com.lego.api.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "listas_de_desejos")
public class ListaDeDesejo extends AbstractEntity {

    @OneToMany(mappedBy = "listaDeDesejoId")
    private java.util.Set<Set> setList;

    //getters and setters

    public java.util.Set<Set> getSetList() {
        return setList;
    }

    public void setSetList(java.util.Set<Set> setList) {
        this.setList = setList;
    }
}
