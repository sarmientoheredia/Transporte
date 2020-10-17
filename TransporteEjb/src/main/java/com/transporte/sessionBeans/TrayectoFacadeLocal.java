/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.sessionBeans;

import com.transporte.entidades.Trayecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Local
public interface TrayectoFacadeLocal {

    void create(Trayecto trayecto);

    void edit(Trayecto trayecto);

    void remove(Trayecto trayecto);

    Trayecto find(Object id);

    List<Trayecto> findAll();

    List<Trayecto> findRange(int[] range);

    int count();
    
}
