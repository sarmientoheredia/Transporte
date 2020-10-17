/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Trayecto.findAll", query = "SELECT t FROM Trayecto t"),
    @NamedQuery(name = "Trayecto.findById", query = "SELECT t FROM Trayecto t WHERE t.id = :id")})
public class Trayecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "id_estacion", referencedColumnName = "id")
    @ManyToOne
    private Estacion idEstacion;
    @JoinColumn(name = "id_tren", referencedColumnName = "id")
    @ManyToOne
    private Tren idTren;
    @OneToMany(mappedBy = "idTrayecto")
    private List<Viaje> viajeList;

    public Trayecto() {
    }

    public Trayecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estacion getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(Estacion idEstacion) {
        this.idEstacion = idEstacion;
    }

    public Tren getIdTren() {
        return idTren;
    }

    public void setIdTren(Tren idTren) {
        this.idTren = idTren;
    }

    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trayecto)) {
            return false;
        }
        Trayecto other = (Trayecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.transporte.entidades.Trayecto[ id=" + id + " ]";
    }
    
}
