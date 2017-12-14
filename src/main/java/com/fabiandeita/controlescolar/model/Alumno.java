/*
 * POJO Alumno
 *
 */
package com.fabiandeita.controlescolar.model;

import javax.persistence.*;

/**
 *
 * @author fdeitaze
 * 
 */
@Entity
@Table( name = "alumno" )
public class Alumno {
    @Id
    @Column(name="alumno_id")
    private long estudianteId;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidoP")
    private String apellidoP;
    
    @Column(name="apellidoM")
    private String apellidoM;

    
    
    public Alumno(String nombre)
    {
        this.nombre = nombre;
    }
    
    public Alumno()
    {
    }

    public Alumno(long id)
    {
        this.estudianteId = id;
    }

    public Alumno(String nombre, String apellidoP, String apellidoM) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public Alumno(long estudianteId, String nombre, String apellidoP, String apellidoM) {
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
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

    /**
     * @return the estudianteId
     */
    public long getEstudianteId() {
        return estudianteId;
    }

    /**
     * @param estudianteId the estudianteId to set
     */
    public void setEstudianteId(long estudianteId) {
        this.estudianteId = estudianteId;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
