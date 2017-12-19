/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.model;

import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "materia")
public class Materia {
    
    @Id
    @Column (name = "materia_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materiaId;
    
    @Column (name="nombre")
    private String nombre;

//    @ManyToOne 
    @ManyToOne 
    @JoinColumn(name="maestro_maestro_id") 
    private Maestro maestro;

    
    public Materia() 
    {
        
    }

    public Materia(Long materiaId, String nombre, Maestro maestro) {
        this.materiaId = materiaId;
        this.nombre = nombre;
        this.maestro = maestro;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
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
