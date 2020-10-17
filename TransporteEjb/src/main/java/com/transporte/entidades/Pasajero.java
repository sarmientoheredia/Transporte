/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transporte.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Pasajero.findAll", query = "SELECT p FROM Pasajero p"),
    @NamedQuery(name = "Pasajero.findById", query = "SELECT p FROM Pasajero p WHERE p.id = :id"),
    @NamedQuery(name = "Pasajero.findByNombre", query = "SELECT p FROM Pasajero p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pasajero.findByDireccion", query = "SELECT p FROM Pasajero p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Pasajero.findByFechaNacimiento", query = "SELECT p FROM Pasajero p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Pasajero.findByCedula", query = "SELECT p FROM Pasajero p WHERE p.cedula = :cedula")})
public class Pasajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 100)
    private String nombre;
    @Size(max = 2147483647)
    private String direccion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 10)
    private String cedula;
    
    @OneToMany(mappedBy = "idPasajero")
    private List<Viaje> viajeList;

    public Pasajero() {
    }

    public Pasajero(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
        if (!(object instanceof Pasajero)) {
            return false;
        }
        Pasajero other = (Pasajero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.transporte.entidades.Pasajero[ id=" + id + " ]";
    }
    
}
