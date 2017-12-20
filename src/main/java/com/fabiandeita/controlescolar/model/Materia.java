/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Table(name = "materia")
public class Materia {
    
    @Id
    @Column (name = "materia_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materiaId;
    
    @Column (name="nombre")
    private String nombre;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Role.class)
//    @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
   
//    @ManyToOne //Checar
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
    
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="curso_id")
//    private Set<Curso> cursos;

    
//    @OneToMany 
    @OneToOne
    @JoinColumn(name="maestro_maestro_id") 
    private Maestro maestro;
//    private Set<Maestro> maestro;

//    public Set<Maestro> getMaestro() {
//        return maestro;
//    }
//
//    public void setMaestro(Set<Maestro> maestro) {
//        this.maestro = maestro;
//    }

    
    public Materia() 
    {    }

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
