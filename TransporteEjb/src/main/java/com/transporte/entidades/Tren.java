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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Tren.findAll", query = "SELECT t FROM Tren t"),
    @NamedQuery(name = "Tren.findById", query = "SELECT t FROM Tren t WHERE t.id = :id"),
    @NamedQuery(name = "Tren.findByModelo", query = "SELECT t FROM Tren t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "Tren.findByCapacidad", query = "SELECT t FROM Tren t WHERE t.capacidad = :capacidad")})
public class Tren implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 80)
    private String modelo;
    private Integer capacidad;
    @OneToMany(mappedBy = "idTren")
    private List<Trayecto> trayectoList;

    public Tren() {
    }

    public Tren(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public List<Trayecto> getTrayectoList() {
        return trayectoList;
    }

    public void setTrayectoList(List<Trayecto> trayectoList) {
        this.trayectoList = trayectoList;
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
        if (!(object instanceof Tren)) {
            return false;
        }
        Tren other = (Tren) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.transporte.entidades.Tren[ id=" + id + " ]";
    }
    
}
