/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.model;

import javax.persistence.*;

/**
 *
 * @author ecastrmu
 */

@Entity
@Table( name = "materia" )
public class Materia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materia_id;
    
    @Column
    private String nombre;

    public Integer getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(Integer materia_id) {
        this.materia_id = materia_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
