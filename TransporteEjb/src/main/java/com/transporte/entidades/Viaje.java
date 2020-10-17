/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v"),
    @NamedQuery(name = "Viaje.findById", query = "SELECT v FROM Viaje v WHERE v.id = :id"),
    @NamedQuery(name = "Viaje.findByInicio", query = "SELECT v FROM Viaje v WHERE v.inicio = :inicio"),
    @NamedQuery(name = "Viaje.findByFin", query = "SELECT v FROM Viaje v WHERE v.fin = :fin")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @JoinColumn(name = "id_pasajero", referencedColumnName = "id")
    @ManyToOne
    private Pasajero idPasajero;
    @JoinColumn(name = "id_trayecto", referencedColumnName = "id")
    @ManyToOne
    private Trayecto idTrayecto;

    public Viaje() {
    }

    public Viaje(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Pasajero getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Pasajero idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Trayecto getIdTrayecto() {
        return idTrayecto;
    }

    public void setIdTrayecto(Trayecto idTrayecto) {
        this.idTrayecto = idTrayecto;
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
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.transporte.entidades.Viaje[ id=" + id + " ]";
    }
    
}
