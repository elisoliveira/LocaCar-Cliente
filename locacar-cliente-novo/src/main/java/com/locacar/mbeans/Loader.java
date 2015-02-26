/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locacar.mbeans;

import com.pos.services.Carro;
import com.pos.services.LocaService;
import com.pos.services.LocaService_Service;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Magdiel Ildefonso
 */
public class Loader {
    public static void main(String[] args) {
//        LocaService loca;
//        LocaService_Service locaService_service = new LocaService_Service();
//        loca = locaService_service.getLocaServicePort();
//        for (Carro c : loca.getCarrosDisponiveis()) {
//            System.out.println(c.getNome());
//        }
        
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date dataHoje = calendar.getTime();
        System.out.println(dataHoje);
        calendar.setTime(dataHoje);
        calendar.add(Calendar.HOUR_OF_DAY, 24);
        Date dataAmanha = calendar.getTime();
        System.out.println(dataAmanha);
    }
}
