/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created on : 11/02/2015, 18:05:30
 *
 * @author Elis Oliveira
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Pessoa.BUSCAR_LOGIN_SENHA, query = "SELECT p FROM Pessoa p WHERE p.login=:login AND p.senha=:senha")
})
public class Pessoa implements Serializable {

    public static final String BUSCAR_LOGIN_SENHA = "buscar.login.senha";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String login;
    private String senha;

    public Pessoa() {
    }

    public Pessoa(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", login=" + login + ", senha=" + senha + '}';
    }

}
