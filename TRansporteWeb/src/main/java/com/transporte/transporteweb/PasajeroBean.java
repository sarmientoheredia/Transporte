package com.transporte.transporteweb;

import com.transporte.entidades.Pasajero;
import com.transporte.sessionBeans.PasajeroFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Cbos- Com. Sarmiento H. Luis A.
 */
@Named(value = "pasajeroBean")
@ViewScoped
public class PasajeroBean implements Serializable {

//INICIO DE LAS VARIABLES 
    private List<Pasajero> pasajeroList;
    private Pasajero pasajero;
    private boolean modoEdicion;
//INICIO DE LAS VARIABLES 

//    INICIO INYECCION
    @EJB
    private PasajeroFacadeLocal pasajeroFacadeLocal;
//  FIN INYECCION

    public PasajeroBean() {
    }

    @PostConstruct
    public void init() {
        pasajeroList = pasajeroFacadeLocal.findAll();
    }

//INICIO GETTERS Y SETTERS 
    public List<Pasajero> getPasajeroList() {
        return pasajeroList;
    }

    public void setPasajeroList(List<Pasajero> pasajeroList) {
        this.pasajeroList = pasajeroList;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }
//FIN GETTERS Y SETTERS 

//INICIO DE LOS METODOS
    //metodo para mostrar el panel de registro
    public void nuevo() {
        pasajero = new Pasajero();
        modoEdicion = false;
    }

    //metdodo para crear nuevo pasajero
    public void crear() {
        try {
            if (modoEdicion) {
                pasajeroFacadeLocal.edit(pasajero);
            } else {
                pasajeroFacadeLocal.create(pasajero);
            }
            pasajero = null;
            init();
        } catch (Exception e) {
            System.out.println("primer nivel: " + e.getMessage());
            System.out.println("primera clase: " + e.getClass().getName());

            System.out.println("segundo nivel: " + e.getCause().getMessage());
            System.out.println("primera clase: " + e.getCause().getClass().getName());

            System.out.println("tercer nivel: " + e.getCause().getCause().getMessage());
            System.out.println("primera clase: " + e.getCause().getCause().getClass().getName());
            if(e.getCause().getCause().getClass().getName().equals("org.hibernate.exception.ConstraintViolationException")){
                if(e.getCause().getCause().getMessage().contains("could not execute statement")){
                    FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "el pasajero ya existe"));
                    
                }
                
            }
        }

    }

    //metodo para cancelar la creacion
    public void cancelar() {
        init();
        pasajero = null;
    }

    //metodo para seleccionar el usuario a editar
    public void seleccionar(Pasajero pasajero) {
        this.pasajero = pasajero;
        modoEdicion = true;
    }

    //metodod para eliminar un pasajero
    public void eliminar(Pasajero pasajero) {
        pasajeroFacadeLocal.remove(pasajero);
        init();
    }

    //metodo para validar si el usuario con el numero de cedula ya esta registrado
    public void varificarExistencia() {
        Pasajero pas = pasajeroFacadeLocal.findByCedula(pasajero.getCedula());
        if (pas != null) {
            FacesContext.getCurrentInstance().addMessage(":form1:txtCedula", new FacesMessage(FacesMessage.SEVERITY_WARN, "Existe", "El pasajero ya existe"));
        }
    }

//    FIN DE LOS METODOS
}
