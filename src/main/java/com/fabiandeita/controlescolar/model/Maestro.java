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
    private Long maestro_id;
    
    @Column(name="nombre")
    private String nombre;
     
    @Column(name="apellidoP")
    private String apellidoP;
  
    @Column(name="apellidoM")
    private String apellidoM;

    public Maestro(Long maestroId, String nombre, String apellidoP, String apellidoM) {
        this.maestro_id = maestroId;
        this.nombre     = nombre;
        this.apellidoP  = apellidoP;
        this.apellidoM  = apellidoM;
    }
    
    public Maestro(String nombre) {
        this.nombre = nombre;
    }
    
    public Maestro() {
    }
    
    public Maestro(Long id) {
        this.maestro_id = id;
    }
   
    public Long getMaestro_id() {
        return maestro_id;
    }

    public void setMaestro_id(Long maestro_id) {
        this.maestro_id = maestro_id;
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
}
