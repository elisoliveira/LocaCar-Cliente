
package com.pos.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pos.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AtualizarEndereco_QNAME = new QName("http://services.pos.com/", "atualizarEndereco");
    private final static QName _OnConstructResponse_QNAME = new QName("http://services.pos.com/", "onConstructResponse");
    private final static QName _CadastrarEndereco_QNAME = new QName("http://services.pos.com/", "cadastrarEndereco");
    private final static QName _OnDestroy_QNAME = new QName("http://services.pos.com/", "onDestroy");
    private final static QName _ExcluirEndereco_QNAME = new QName("http://services.pos.com/", "excluirEndereco");
    private final static QName _AtualizarEnderecoResponse_QNAME = new QName("http://services.pos.com/", "atualizarEnderecoResponse");
    private final static QName _CadastrarEnderecoResponse_QNAME = new QName("http://services.pos.com/", "cadastrarEnderecoResponse");
    private final static QName _ExcluirEnderecoResponse_QNAME = new QName("http://services.pos.com/", "excluirEnderecoResponse");
    private final static QName _OnConstruct_QNAME = new QName("http://services.pos.com/", "onConstruct");
    private final static QName _OnDestroyResponse_QNAME = new QName("http://services.pos.com/", "onDestroyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pos.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OnDestroyResponse }
     * 
     */
    public OnDestroyResponse createOnDestroyResponse() {
        return new OnDestroyResponse();
    }

    /**
     * Create an instance of {@link CadastrarEnderecoResponse }
     * 
     */
    public CadastrarEnderecoResponse createCadastrarEnderecoResponse() {
        return new CadastrarEnderecoResponse();
    }

    /**
     * Create an instance of {@link AtualizarEnderecoResponse }
     * 
     */
    public AtualizarEnderecoResponse createAtualizarEnderecoResponse() {
        return new AtualizarEnderecoResponse();
    }

    /**
     * Create an instance of {@link ExcluirEnderecoResponse }
     * 
     */
    public ExcluirEnderecoResponse createExcluirEnderecoResponse() {
        return new ExcluirEnderecoResponse();
    }

    /**
     * Create an instance of {@link OnConstruct }
     * 
     */
    public OnConstruct createOnConstruct() {
        return new OnConstruct();
    }

    /**
     * Create an instance of {@link OnConstructResponse }
     * 
     */
    public OnConstructResponse createOnConstructResponse() {
        return new OnConstructResponse();
    }

    /**
     * Create an instance of {@link CadastrarEndereco }
     * 
     */
    public CadastrarEndereco createCadastrarEndereco() {
        return new CadastrarEndereco();
    }

    /**
     * Create an instance of {@link OnDestroy }
     * 
     */
    public OnDestroy createOnDestroy() {
        return new OnDestroy();
    }

    /**
     * Create an instance of {@link ExcluirEndereco }
     * 
     */
    public ExcluirEndereco createExcluirEndereco() {
        return new ExcluirEndereco();
    }

    /**
     * Create an instance of {@link AtualizarEndereco }
     * 
     */
    public AtualizarEndereco createAtualizarEndereco() {
        return new AtualizarEndereco();
    }

    /**
     * Create an instance of {@link Endereco }
     * 
     */
    public Endereco createEndereco() {
        return new Endereco();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AtualizarEndereco }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "atualizarEndereco")
    public JAXBElement<AtualizarEndereco> createAtualizarEndereco(AtualizarEndereco value) {
        return new JAXBElement<AtualizarEndereco>(_AtualizarEndereco_QNAME, AtualizarEndereco.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnConstructResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "onConstructResponse")
    public JAXBElement<OnConstructResponse> createOnConstructResponse(OnConstructResponse value) {
        return new JAXBElement<OnConstructResponse>(_OnConstructResponse_QNAME, OnConstructResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarEndereco }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "cadastrarEndereco")
    public JAXBElement<CadastrarEndereco> createCadastrarEndereco(CadastrarEndereco value) {
        return new JAXBElement<CadastrarEndereco>(_CadastrarEndereco_QNAME, CadastrarEndereco.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnDestroy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "onDestroy")
    public JAXBElement<OnDestroy> createOnDestroy(OnDestroy value) {
        return new JAXBElement<OnDestroy>(_OnDestroy_QNAME, OnDestroy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcluirEndereco }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "excluirEndereco")
    public JAXBElement<ExcluirEndereco> createExcluirEndereco(ExcluirEndereco value) {
        return new JAXBElement<ExcluirEndereco>(_ExcluirEndereco_QNAME, ExcluirEndereco.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AtualizarEnderecoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "atualizarEnderecoResponse")
    public JAXBElement<AtualizarEnderecoResponse> createAtualizarEnderecoResponse(AtualizarEnderecoResponse value) {
        return new JAXBElement<AtualizarEnderecoResponse>(_AtualizarEnderecoResponse_QNAME, AtualizarEnderecoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarEnderecoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "cadastrarEnderecoResponse")
    public JAXBElement<CadastrarEnderecoResponse> createCadastrarEnderecoResponse(CadastrarEnderecoResponse value) {
        return new JAXBElement<CadastrarEnderecoResponse>(_CadastrarEnderecoResponse_QNAME, CadastrarEnderecoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcluirEnderecoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "excluirEnderecoResponse")
    public JAXBElement<ExcluirEnderecoResponse> createExcluirEnderecoResponse(ExcluirEnderecoResponse value) {
        return new JAXBElement<ExcluirEnderecoResponse>(_ExcluirEnderecoResponse_QNAME, ExcluirEnderecoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnConstruct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "onConstruct")
    public JAXBElement<OnConstruct> createOnConstruct(OnConstruct value) {
        return new JAXBElement<OnConstruct>(_OnConstruct_QNAME, OnConstruct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnDestroyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.pos.com/", name = "onDestroyResponse")
    public JAXBElement<OnDestroyResponse> createOnDestroyResponse(OnDestroyResponse value) {
        return new JAXBElement<OnDestroyResponse>(_OnDestroyResponse_QNAME, OnDestroyResponse.class, null, value);
    }

}
