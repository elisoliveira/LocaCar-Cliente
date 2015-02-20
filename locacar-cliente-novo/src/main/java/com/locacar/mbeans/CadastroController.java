/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.pos.services.Carro;
import com.pos.services.Endereco;
import com.pos.services.Locadora;
import com.pos.services.ManterCarroService;
import com.pos.services.ManterCarroService_Service;
import com.pos.services.ManterEnderecoService;
import com.pos.services.ManterEnderecoService_Service;
import com.pos.services.ManterLocadoraService;
import com.pos.services.ManterLocadoraService_Service;
import com.pos.services.ManterPessoaService;
import com.pos.services.ManterPessoaService_Service;
import com.pos.services.Pessoa;
import com.pos.services.TipoStatusReserva;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 * Created on : 19/02/2015, 11:20:00
 *
 * @author Elis Oliveira
 */
@ManagedBean(name = "cadastroMB")
@RequestScoped
public class CadastroController {

    private final ManterPessoaService manterPessoaService;
    private final ManterCarroService manterCarroService;
    private final ManterLocadoraService manterLocadoraService;
    private final ManterEnderecoService manterEnderecoService;
    private Pessoa pessoa;
    private Carro carro;
    private Locadora locadora;
    private Endereco endereco;

    public CadastroController() {
        pessoa = new Pessoa();
        carro = new Carro();
        locadora = new Locadora();
        endereco = new Endereco();

        ManterPessoaService_Service pessoaService = new ManterPessoaService_Service();
        this.manterPessoaService = pessoaService.getManterPessoaServicePort();

        ManterCarroService_Service carroService = new ManterCarroService_Service();
        this.manterCarroService = carroService.getManterCarroServicePort();

        ManterLocadoraService_Service locadoraService = new ManterLocadoraService_Service();
        this.manterLocadoraService = locadoraService.getManterLocadoraServicePort();

        ManterEnderecoService_Service enderecoService = new ManterEnderecoService_Service();
        this.manterEnderecoService = enderecoService.getManterEnderecoServicePort();

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void cadastraPessoa() {
        try {
            manterPessoaService.cadastrarPessoa(pessoa);
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "LocaCar", "Cadastro Realizado com Sucesso!"));
            this.pessoa = new Pessoa();
        } catch (Exception e) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar!", "Detalhes do Erro: " + e.getMessage()));
        }
    }

    public void cadastraCarro() {
        try {
            carro.setStatusReserva(TipoStatusReserva.DISPONIVEL);
            manterCarroService.cadastrarCarro(carro);
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "LocaCar", "Cadastro Realizado com Sucesso!"));
            this.carro = new Carro();
        } catch (Exception e) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar!", "Detalhes do Erro: " + e.getMessage()));
        }

    }

    public void cadastraLocadora() {
        try {
            locadora.setEndereco(endereco);
            manterLocadoraService.cadastrarLocadora(locadora);
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "LocaCar", "Cadastro Realizado com Sucesso!"));
            this.locadora = new Locadora();
            this.endereco = new Endereco();
        } catch (Exception e) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar!", "Detalhes do Erro: " + e.getMessage()));
        }

    }

}
