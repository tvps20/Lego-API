package br.com.lego.api.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends AbstractEntity{
    private String nome;
    private String email;
    private String password;
    private boolean admin;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
