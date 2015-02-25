/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.locacar.dao.Dao;
import com.pos.services.Carro;
import com.pos.services.LocaService;
import com.pos.services.LocaService_Service;
import com.pos.services.ManterPessoaService;
import com.pos.services.ManterPessoaService_Service;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Magdiel Ildefonso
 */
@Named(value = "reservaController")
@RequestScoped
public class ReservaController {
    @PersistenceContext(name = "LOCACAR-CLIENTE-PU")
    private EntityManager manager;
    @Resource
    private UserTransaction transaction;
    private Dao dao;
    private LocaService locaService;
    
    /**
     * Creates a new instance of ReservaController
     */
    public ReservaController() {
    }
    
    public List<Carro> getListCarrosDisponiveis(){
        LocaService_Service locaService_service = new LocaService_Service();
        this.locaService = locaService_service.getLocaServicePort();
        return this.locaService.getCarrosDisponiveis();
    }
}
