/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.sessionBeans;

import com.transporte.entidades.Pasajero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Stateless
public class PasajeroFacade extends AbstractFacade<Pasajero> implements PasajeroFacadeLocal {

    @PersistenceContext(unitName = "transportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PasajeroFacade() {
        super(Pasajero.class);
    }

    @Override
    public Pasajero findByCedula(String cedula) {
        Query query=em.createNamedQuery("Pasajero.findByCedula", Pasajero.class);
        query.setParameter("cedula", cedula);
        return (Pasajero) query.getSingleResult();
    }
    
}
