/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.locacar.dao.Dao;
import com.locacar.dao.DaoImpl;
import com.locacar.entidades.Pessoa;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 * Created on : 11/02/2015, 18:48:49
 *
 * @author Elis Oliveira
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginController {

    @PersistenceContext(name = "LOCACAR-CLIENTE-PU")
    private EntityManager manager;
    @Resource
    private UserTransaction transaction;
    private Dao dao;
    private String login;
    private String senha;

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

    public String doLogin() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("login", login);
        map.put("senha", senha);
            
        Object pessoaEncontrada = dao.buscaObjetoComNamedQuery(Pessoa.BUSCAR_LOGIN_SENHA, map);
        if (pessoaEncontrada == null) {
            System.out.println("usuario nulo");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Falha na autenticação", "Login ou senha inválido!"));
            return "index.xhtml";

        } else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("usuarioLogado", pessoaEncontrada);
            return "home.xhtml?faces-redirect=true";
        }

    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioLogado");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("deslogou");
        return "index.xhtml?faces-redirect=true";
    }

    @PostConstruct
    public void onConstruct() {
        dao = new DaoImpl(manager, transaction);
    }

    @PreDestroy
    public void onDestroy() {
        manager = null;
        dao = null;
    }

}
