/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.sessionBeans;

import com.transporte.entidades.Tren;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Local
public interface TrenFacadeLocal {

    void create(Tren tren);

    void edit(Tren tren);

    void remove(Tren tren);

    Tren find(Object id);

    List<Tren> findAll();

    List<Tren> findRange(int[] range);

    int count();
    
}
