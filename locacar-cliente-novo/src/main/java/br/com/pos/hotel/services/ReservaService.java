
package br.com.pos.hotel.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ReservaService", targetNamespace = "http://services.hotel.pos.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReservaService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.com.pos.hotel.services.Quarto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getListaQuartosDesocupados", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetListaQuartosDesocupados")
    @ResponseWrapper(localName = "getListaQuartosDesocupadosResponse", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetListaQuartosDesocupadosResponse")
    @Action(input = "http://services.hotel.pos.com.br/ReservaService/getListaQuartosDesocupadosRequest", output = "http://services.hotel.pos.com.br/ReservaService/getListaQuartosDesocupadosResponse")
    public List<Quarto> getListaQuartosDesocupados(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<br.com.pos.hotel.services.Quarto>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getListaQuartosDesocupadosPorIdHotel", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetListaQuartosDesocupadosPorIdHotel")
    @ResponseWrapper(localName = "getListaQuartosDesocupadosPorIdHotelResponse", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetListaQuartosDesocupadosPorIdHotelResponse")
    @Action(input = "http://services.hotel.pos.com.br/ReservaService/getListaQuartosDesocupadosPorIdHotelRequest", output = "http://services.hotel.pos.com.br/ReservaService/getListaQuartosDesocupadosPorIdHotelResponse")
    public List<Quarto> getListaQuartosDesocupadosPorIdHotel(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<br.com.pos.hotel.services.Hotel>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHoteis", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetHoteis")
    @ResponseWrapper(localName = "getHoteisResponse", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetHoteisResponse")
    @Action(input = "http://services.hotel.pos.com.br/ReservaService/getHoteisRequest", output = "http://services.hotel.pos.com.br/ReservaService/getHoteisResponse")
    public List<Hotel> getHoteis();

    /**
     * 
     * @param arg0
     * @return
     *     returns br.com.pos.hotel.services.Hotel
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHotelById", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetHotelById")
    @ResponseWrapper(localName = "getHotelByIdResponse", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetHotelByIdResponse")
    @Action(input = "http://services.hotel.pos.com.br/ReservaService/getHotelByIdRequest", output = "http://services.hotel.pos.com.br/ReservaService/getHotelByIdResponse")
    public Hotel getHotelById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns br.com.pos.hotel.services.Quarto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getQuartoByID", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetQuartoByID")
    @ResponseWrapper(localName = "getQuartoByIDResponse", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetQuartoByIDResponse")
    @Action(input = "http://services.hotel.pos.com.br/ReservaService/getQuartoByIDRequest", output = "http://services.hotel.pos.com.br/ReservaService/getQuartoByIDResponse")
    public Quarto getQuartoByID(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "Reservar")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Reservar", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.Reservar")
    @ResponseWrapper(localName = "ReservarResponse", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.ReservarResponse")
    @Action(input = "http://services.hotel.pos.com.br/ReservaService/ReservarRequest", output = "http://services.hotel.pos.com.br/ReservaService/ReservarResponse")
    public boolean reservar(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        XMLGregorianCalendar arg5);

    /**
     * 
     * @return
     *     returns java.util.List<br.com.pos.hotel.services.Reserva>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getListaReservas", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetListaReservas")
    @ResponseWrapper(localName = "getListaReservasResponse", targetNamespace = "http://services.hotel.pos.com.br/", className = "br.com.pos.hotel.services.GetListaReservasResponse")
    @Action(input = "http://services.hotel.pos.com.br/ReservaService/getListaReservasRequest", output = "http://services.hotel.pos.com.br/ReservaService/getListaReservasResponse")
    public List<Reserva> getListaReservas();

}