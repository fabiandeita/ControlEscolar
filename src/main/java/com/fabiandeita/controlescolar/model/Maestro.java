
package com.fabiandeita.controlescolar.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "maestroprueba" )
public class Maestro implements Serializable
{    
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

    
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Materia> materias = new ArrayList<Materia>();

    
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

    
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
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

    public void addMateria(Materia materia){
        this.materias.add(materia);
    }
    
}
