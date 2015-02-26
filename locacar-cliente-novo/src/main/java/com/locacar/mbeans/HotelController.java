/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import br.com.pos.hotel.services.Quarto;
import br.com.pos.hotel.services.ReservaService;
import br.com.pos.hotel.services.ReservaServiceService;
import com.pos.services.Pessoa;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Magdiel Ildefonso
 */
@ManagedBean(name = "hotelController")
@RequestScoped
public class HotelController {
    private ReservaService reservaService;
    private DataModel<Quarto> dataModelQuartosDisponiveis;

    /**
     * Creates a new instance of HotelController
     */
    public HotelController() {
        ReservaServiceService service = new ReservaServiceService();
        reservaService = service.getReservaServicePort();
    }
    
    public DataModel<Quarto> getDataModelQuartosDisponiveis() {
        if (dataModelQuartosDisponiveis == null) {
            List<Quarto> listaQuartos = reservaService.getListaQuartosDesocupadosPorIdHotel(1);
            dataModelQuartosDisponiveis = new ListDataModel<>(listaQuartos);
            System.out.println("Data model de quartos disponíveis");
        }
        return dataModelQuartosDisponiveis;
    }
    
    public String reservarQuarto() {
        String result = "index.xhtml?faces-redirect=true";
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Pessoa pessoa = (Pessoa) session.getAttribute("usuarioLogado");
            Quarto quarto = dataModelQuartosDisponiveis.getRowData();

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

            reservaService.reservar(1, quarto.getId(), pessoa.getNome(), pessoa.getDocumento(), dtHoje, dtAmanha);
            System.out.println("Carro reservado");

            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "LocaCar", "Carro reservado com Sucesso!"));
            result = "hotel.xhtml?faces-redirect=true";

        } catch (Exception ex) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao reservar!", "Detalhes do Erro: " + ex.getMessage()));
            result = "index.xhtml?faces-redirect=true";
        }
        return result;
    }
}
