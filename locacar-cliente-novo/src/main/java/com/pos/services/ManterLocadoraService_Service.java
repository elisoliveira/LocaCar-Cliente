
package com.pos.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ManterLocadoraService", targetNamespace = "http://services.pos.com/", wsdlLocation = "http://localhost:8080/LocaCar-App/ManterLocadoraService?WSDL")
public class ManterLocadoraService_Service
    extends Service
{

    private final static URL MANTERLOCADORASERVICE_WSDL_LOCATION;
    private final static WebServiceException MANTERLOCADORASERVICE_EXCEPTION;
    private final static QName MANTERLOCADORASERVICE_QNAME = new QName("http://services.pos.com/", "ManterLocadoraService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/LocaCar-App/ManterLocadoraService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MANTERLOCADORASERVICE_WSDL_LOCATION = url;
        MANTERLOCADORASERVICE_EXCEPTION = e;
    }

    public ManterLocadoraService_Service() {
        super(__getWsdlLocation(), MANTERLOCADORASERVICE_QNAME);
    }

    public ManterLocadoraService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MANTERLOCADORASERVICE_QNAME, features);
    }

    public ManterLocadoraService_Service(URL wsdlLocation) {
        super(wsdlLocation, MANTERLOCADORASERVICE_QNAME);
    }

    public ManterLocadoraService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MANTERLOCADORASERVICE_QNAME, features);
    }

    public ManterLocadoraService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ManterLocadoraService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ManterLocadoraService
     */
    @WebEndpoint(name = "ManterLocadoraServicePort")
    public ManterLocadoraService getManterLocadoraServicePort() {
        return super.getPort(new QName("http://services.pos.com/", "ManterLocadoraServicePort"), ManterLocadoraService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ManterLocadoraService
     */
    @WebEndpoint(name = "ManterLocadoraServicePort")
    public ManterLocadoraService getManterLocadoraServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.pos.com/", "ManterLocadoraServicePort"), ManterLocadoraService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MANTERLOCADORASERVICE_EXCEPTION!= null) {
            throw MANTERLOCADORASERVICE_EXCEPTION;
        }
        return MANTERLOCADORASERVICE_WSDL_LOCATION;
    }

}
