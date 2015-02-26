/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.pos.services.Carro;
import com.pos.services.LocaService;
import com.pos.services.LocaService_Service;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Magdiel Ildefonso
 */
@ManagedBean(name = "reservaMB")
@RequestScoped
public class ReservaController {

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
        System.out.println("oi");
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

    
    //comentario elis
    //pode tirar esse metodo
//    public List<Carro> getListCarrosDisponiveis() {
//        LocaService_Service locaService_service = new LocaService_Service();
//        this.locaService = locaService_service.getLocaServicePort();
//        return this.locaService.getCarrosDisponiveis();
//    }
}
