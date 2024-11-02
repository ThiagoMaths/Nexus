package br.com.control.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final String TABLE_USUARIOS_ROLES = "usuario_roles";
    private static final String TABLE_USUARIO = "usuario";
    private static final String TABLE_ROLE = "role";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String login;
    private String senha;
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
