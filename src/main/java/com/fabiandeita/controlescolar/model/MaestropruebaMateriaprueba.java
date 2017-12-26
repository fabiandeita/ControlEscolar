/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table( name = "maestroprueba_materiaprueba" )
public class MaestropruebaMateriaprueba implements Serializable{
    
    
    @Column(name="maestro_maestro_id")
    private Long maestroMaestroId;
    
    @Id
    @Column(name="materia_materia_id")
    private Long materiaMateriaId;

    public MaestropruebaMateriaprueba() {
    }

    public MaestropruebaMateriaprueba(Long maestroMaestroId, Long materiaMateriaId) {
        this.maestroMaestroId = maestroMaestroId;
        this.materiaMateriaId = materiaMateriaId;
    }

    public Long getMaestroMaestroId() {
        return maestroMaestroId;
    }

    public void setMaestroMaestroId(Long maestroMaestroId) {
        this.maestroMaestroId = maestroMaestroId;
    }

    public Long getMateriaMateriaId() {
        return materiaMateriaId;
    }

    public void setMateriaMateriaId(Long materiaMateriaId) {
        this.materiaMateriaId = materiaMateriaId;
    }
    
    
    
    
}
