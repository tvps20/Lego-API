package br.com.lego.api.models;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="users")
public class User extends AbstractEntity{
    private String nome;
    @NotEmpty(message = "O campo email é obrigatório")
    @Email
    private String email;
    @NotEmpty(message = "O campo password é obrigatório")
    private String password;
    private boolean admin;


    // Contrutores
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.admin = false;
    }

    public User() {
    }


    // Getters and Setters
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
