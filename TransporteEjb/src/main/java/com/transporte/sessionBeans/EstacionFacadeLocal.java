/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.sessionBeans;

import com.transporte.entidades.Estacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Local
public interface EstacionFacadeLocal {

    void create(Estacion estacion);

    void edit(Estacion estacion);

    void remove(Estacion estacion);

    Estacion find(Object id);

    List<Estacion> findAll();

    List<Estacion> findRange(int[] range);

    int count();
    
}
