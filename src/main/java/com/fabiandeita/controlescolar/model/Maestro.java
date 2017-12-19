/*
 * To change this licens.
 * To change this templa
 * and open the template.
 */
package com.fabiandeita.controlescolar.model;

import javax.persistence.*;

/**
 *
 * @author ecastrmu
 * 
 */

@Entity
@Table( name = "maestro" )
public class Maestro {
    
    @Id
    @Column(name="maestro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maestroId;
    
    @Column(name="nombre")
    private String nombre;
     
    @Column(name="apellidoP")
    private String apellidoP;
  
    @Column(name="apellidoM")
    private String apellidoM;

    public Maestro(Long maestroId, String nombre, String apellidoP, String apellidoM) {
        this.maestroId = maestroId;
        this.nombre     = nombre;
        this.apellidoP  = apellidoP;
        this.apellidoM  = apellidoM;
    }

    public Maestro( String nombre, String apellidoP, String apellidoM) {
        this.nombre     = nombre;
        this.apellidoP  = apellidoP;
        this.apellidoM  = apellidoM;
    }
    
    public Maestro(String nombre) {
        this.nombre = nombre;
    }
    
    public Maestro() {
    }
    
    public Maestro(Long maestroId) {
        this.maestroId = maestroId;
    }
   
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Long getMaestroId() {
        return maestroId;
    }

    public void setMaestroId(Long maestroId) {
        this.maestroId = maestroId;
    }
}
