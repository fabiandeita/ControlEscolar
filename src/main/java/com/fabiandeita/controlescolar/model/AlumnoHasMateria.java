/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ecastrmu
 */

@Entity
@Table
public class AlumnoHasMateria {

    @Id
    @Column (name = "calificacion_id")
    private Long calificacionId;
    
    @Column (name = "calificacion")
    private int  calificacion;
    
    @Column
    private Long alumnoAlumnoId;
    
    @Column
    private Long materiaMateriaId;

    public AlumnoHasMateria() {
    }

    public AlumnoHasMateria(Long calificacion_id, int calificacion, Long alumno_alumno_id, Long materia_materia_id) {
        this.calificacionId = calificacionId;
        this.calificacion = calificacion;
        this.alumnoAlumnoId = alumnoAlumnoId;
        this.materiaMateriaId = materiaMateriaId;
    }

    public Long getCalificacionId() {
        return calificacionId;
    }

    public void setCalificacionId(Long calificacionId) {
        this.calificacionId = calificacionId;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Long getAlumnoAlumnoId() {
        return alumnoAlumnoId;
    }

    public void setAlumnoAlumnoId(Long alumnoAlumnoId) {
        this.alumnoAlumnoId = alumnoAlumnoId;
    }

    public Long getMateriaMateriaId() {
        return materiaMateriaId;
    }

    public void setMateriaMateriaId(Long materiaMateriaId) {
        this.materiaMateriaId = materiaMateriaId;
    }

    
    
    
}
