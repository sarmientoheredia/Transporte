/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.sessionBeans;

import com.transporte.entidades.Pasajero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Local
public interface PasajeroFacadeLocal {

    void create(Pasajero pasajero);

    void edit(Pasajero pasajero);

    void remove(Pasajero pasajero);

    Pasajero find(Object id);
    
    Pasajero findByCedula(String cedula);

    List<Pasajero> findAll();

    List<Pasajero> findRange(int[] range);

    int count();
    
}
