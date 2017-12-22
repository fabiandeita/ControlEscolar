
package com.fabiandeita.controlescolar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// implement Serializable
@Entity
@Table( name = "maestro" )
public class Maestro{
    
    @Id
    @Column(name="maestro_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maestroId;
    
    @Column(name="nombre")
    private String nombre;
     
    @Column(name="apellidoP")
    private String apellidoP;
  
    @Column(name="apellidoM")
    private String apellidoM;

    
    @ManyToMany(mappedBy = "maestro")
    private Set<Materia> materias = new HashSet<Materia>();
    
    
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

    
    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
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
//    
//    public void addMateria(Materia materia)
//    {
//        this.materias.add(materia);
//        materia.addMaestro(this);
//    }
    
//    public void addMaestro(Maestro maestro)
//    {
//        this.maestros.add(maestro);
//    }
//  
    
}
