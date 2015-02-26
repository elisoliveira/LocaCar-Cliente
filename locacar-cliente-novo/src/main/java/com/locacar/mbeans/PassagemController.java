/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.pos.services.Carro;
import com.pos.services.Pessoa;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import service.AgenciaService;
import service.Passagens;
import service.Usuario;
import service.Voo;

/**
 *
 * @author Magdiel Ildefonso
 */
@ManagedBean(name = "passagemController")
@RequestScoped
public class PassagemController {
    
    private AgenciaService agencia;
    private DataModel<Voo> dataModelVoosDisponiveis;
    
    /**
     * Creates a new instance of PassagemController
     */
    public PassagemController() {
        Passagens passagens = new Passagens();
        this.agencia = passagens.getAgenciaServicePort();
    }
    
    public DataModel<Voo> getDataModelVoosDisponiveis() {
        if (dataModelVoosDisponiveis == null) {
            List<Voo> listaVoos = agencia.getTodosVoos();
            dataModelVoosDisponiveis = new ListDataModel<>(listaVoos);
            System.out.println("Data model de voos disponíveis");
        }
        return dataModelVoosDisponiveis;
    }
    
    public String comprarPassagem() {
        String result = "index.xhtml?faces-redirect=true";
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Pessoa pessoa = (Pessoa) session.getAttribute("usuarioLogado");

            Voo voo = dataModelVoosDisponiveis.getRowData();
            Usuario usuario = new Usuario();
            usuario.setCpf(pessoa.getDocumento());
            
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataHoje = calendar.getTime();
            calendar.setTime(dataHoje);
            GregorianCalendar cal = new GregorianCalendar();
            XMLGregorianCalendarImpl dtHoje = new XMLGregorianCalendarImpl(cal);
            
            usuario.setDataNascimento(dtHoje);
            usuario.setNome(pessoa.getNome());
            
            this.agencia.salvarUsuario(usuario);
            Usuario user = this.agencia.getUsuario(usuario.getCpf());
            
            this.agencia.venderPassagem(voo.getId(), user);
            
            System.out.println("Passagem comprado");

            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "LocaCar", "Carro reservado com Sucesso!"));
            result = "passagem.xhtml?faces-redirect=true";

        } catch (Exception ex) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao reservar!", "Detalhes do Erro: " + ex.getMessage()));
            result = "index.xhtml?faces-redirect=true";
        }
        return result;
    }
}
