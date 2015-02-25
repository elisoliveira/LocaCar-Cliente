/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.pos.services.Carro;
import com.pos.services.LocaService;
import com.pos.services.LocaService_Service;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Loader {
    public static void main(String[] args) {
        LocaService loca;
        LocaService_Service locaService_service = new LocaService_Service();
        loca = locaService_service.getLocaServicePort();
        for (Carro c : loca.getCarrosDisponiveis()) {
            System.out.println(c.getNome());
        }
    }
}
