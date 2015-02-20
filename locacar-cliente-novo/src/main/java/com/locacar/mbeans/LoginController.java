/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.locacar.dao.Dao;
import com.locacar.dao.DaoImpl;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
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

//    public String doLogin(String login, String senha) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("login", login);
//        map.put("senha", senha);
//        Object usuarioEncontrado = dao.buscaObjetoComNamedQuery("Pessoa.", map);
//        if (usuarioEncontrado != null) {
//            return (Usuario) usuarioEncontrado;
//        } else {
//            return null;
//        }
        
        
        
        
//        Pessoa pessoa = loginLocal.find(login, senha);
//        if (usuario == null) {
//            System.out.println("usuario nulo");
//            return "index.jsf";
//
//        } else {
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            session.setAttribute("usuarioLogado", usuario);
//            if (usuario instanceof Administrador) {
//                return "cadastrar_prof.jsf";
//            } else {
//                return "cadastrar_projetos.jsf";
//            }
//        }
//    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.removeAttribute("usuarioLogado");
        session.invalidate();
        return "index.jsf";
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
