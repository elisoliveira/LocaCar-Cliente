/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.pos.services.Carro;
import com.pos.services.LocaService;
import com.pos.services.LocaService_Service;
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

/**
 *
 * @author Magdiel Ildefonso
 */
@ManagedBean(name = "reservaMB")
@RequestScoped
public class ReservaController {

    private int idCarro;

    //Comentario Elis
    //Isso aqui não vai precisar no cliente pq ja é feito no servidor.
    //Eu usei no login pq eu fiz um banco pro clienteApp so com pessoa tendo login e senha
//    @PersistenceContext(name = "LOCACAR-CLIENTE-PU")
//    private EntityManager manager;
//    @Resource
//    private UserTransaction transaction;
//    private Dao dao;
    private LocaService locaService;
    private DataModel<Carro> dataModelCarrosDisponiveis;

    public ReservaController() {
        //Comentario Elis
        //Pra poder acessar os serviços do outro projeto, tem que instanciar essa
        //classe que ele gera e pegar esse metodo que ele tbm gera pra pegar a porta
        //e isso tem que ser feito no construtor
        LocaService_Service service = new LocaService_Service();
        this.locaService = service.getLocaServicePort();
    }

    public DataModel<Carro> getDataModelCarrosDisponiveis() {
        if (dataModelCarrosDisponiveis == null) {
            List<Carro> listaCarros = locaService.getCarrosDisponiveis();
            dataModelCarrosDisponiveis = new ListDataModel<>(listaCarros);
            System.out.println("Data model de carros disponíveis");
        }
        return dataModelCarrosDisponiveis;
    }

    public void setDataModelCarrosDisponiveis(DataModel<Carro> dataModelCarrosDisponiveis) {
        this.dataModelCarrosDisponiveis = dataModelCarrosDisponiveis;
    }

    public String reservarCarro() {
        String result = "index.xhtml?faces-redirect=true";
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Pessoa pessoa = (Pessoa) session.getAttribute("usuarioLogado");

            Carro carro = dataModelCarrosDisponiveis.getRowData();

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataHoje = calendar.getTime();
            calendar.setTime(dataHoje);
            GregorianCalendar cal = new GregorianCalendar();
            XMLGregorianCalendarImpl dtHoje = new XMLGregorianCalendarImpl(cal);

            cal.setTime(dataHoje);
            calendar.add(Calendar.HOUR_OF_DAY, 24);
            Date dataAmanha = calendar.getTime();
            GregorianCalendar cal2 = new GregorianCalendar();
            cal2.setTime(dataAmanha);
            XMLGregorianCalendarImpl dtAmanha = new XMLGregorianCalendarImpl(cal2);

            locaService.reservarCarro(carro.getId(), pessoa, dtHoje, dtAmanha);
            System.out.println("Carro reservado");
            
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "LocaCar", "Carro reservado com Sucesso!"));
            result = "reservar_carros.xhtml?faces-redirect=true";
            
        } catch (Exception ex){
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao reservar!", "Detalhes do Erro: " + ex.getMessage()));
            result = "index.xhtml?faces-redirect=true";
        }
        return result;
    }
}
