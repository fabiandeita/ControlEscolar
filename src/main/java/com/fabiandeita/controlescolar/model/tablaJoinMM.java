/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author ecastrmu
 */

@Entity
@Table(name = "maestroprueba")
public class tablaJoinMM {
    
    @Id
    @Column(name="maestro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maestroId;
    
    @Column(name="nombre")
    private String nombreMaestro;
     
    @Column(name="apellidoP")
    private String apellidoP;
  
    @Column(name="apellidoM")
    private String apellidoM;
    
    
    
    @Column (name = "materia_id")
    private Long materiaId;
    
    @Column (name="nombre")
    private String nombreMateria;

    @ManyToMany(mappedBy = "materias")
    private List<Maestro> maestros = new ArrayList<Maestro>();
    



    
}



