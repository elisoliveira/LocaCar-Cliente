
package com.pos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for reserva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reserva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carro" type="{http://services.pos.com/}carro" minOccurs="0"/>
 *         &lt;element name="dataFimReserva" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataInicioReserva" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pessoa" type="{http://services.pos.com/}pessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserva", propOrder = {
    "carro",
    "dataFimReserva",
    "dataInicioReserva",
    "id",
    "pessoa"
})
public class Reserva {

    protected Carro carro;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFimReserva;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInicioReserva;
    protected int id;
    protected Pessoa pessoa;

    /**
     * Gets the value of the carro property.
     * 
     * @return
     *     possible object is
     *     {@link Carro }
     *     
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * Sets the value of the carro property.
     * 
     * @param value
     *     allowed object is
     *     {@link Carro }
     *     
     */
    public void setCarro(Carro value) {
        this.carro = value;
    }

    /**
     * Gets the value of the dataFimReserva property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFimReserva() {
        return dataFimReserva;
    }

    /**
     * Sets the value of the dataFimReserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFimReserva(XMLGregorianCalendar value) {
        this.dataFimReserva = value;
    }

    /**
     * Gets the value of the dataInicioReserva property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInicioReserva() {
        return dataInicioReserva;
    }

    /**
     * Sets the value of the dataInicioReserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInicioReserva(XMLGregorianCalendar value) {
        this.dataInicioReserva = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the pessoa property.
     * 
     * @return
     *     possible object is
     *     {@link Pessoa }
     *     
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Sets the value of the pessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pessoa }
     *     
     */
    public void setPessoa(Pessoa value) {
        this.pessoa = value;
    }

}
