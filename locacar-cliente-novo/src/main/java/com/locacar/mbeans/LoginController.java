/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.pos.services.LocaService;
import com.pos.services.LocaService_Service;
import com.pos.services.Pessoa;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created on : 11/02/2015, 18:48:49
 *
 * @author Elis Oliveira
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginController {
    private String login;
    private String senha;
    
    private LocaService locaService;

    public LoginController() {
        LocaService_Service service = new LocaService_Service();
        this.locaService = service.getLocaServicePort();
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

    public String doLogin() {
        Map<String, Object> map = new HashMap<String, Object>();
        Pessoa pessoaEncontrada = locaService.loginPessoa(login, senha);
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
}
