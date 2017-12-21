/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Table(name = "materia")
public class Materia {
//public class Materia implements Serializable {
    @Id
    @Column (name = "materia_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materiaId;
    
    @Column (name="nombre")
    private String nombre;
      @OneToOne
    @JoinColumn(name="maestro_maestro_id") 
    private Maestro maestro;     

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }
    
   
//    
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "maestro_asigned_materia", 
//        joinColumns = { @JoinColumn(name = "materia_materia_id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "maestro_maestro_id") }
//    )
//    Set<Maestro> maestros = new HashSet<Maestro>();
//    
//    
//
//    public Set<Maestro> getMaestros() {
//        return maestros;
//    }
//
//    public void setMaestros(Set<Maestro> maestros) {
//        this.maestros = maestros;
//    }
    
    public Materia() 
    {    }

    public Materia(Long materiaId, String nombre,  Maestro maestros) {
//    public Materia(Long materiaId, String nombre, Set< Maestro> maestros) {
        this.materiaId = materiaId;
        this.nombre = nombre;
        this.maestro = maestros;
//        this.maestros = maestros;
    }

    
    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
