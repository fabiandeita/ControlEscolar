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
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long alumnoId;
    
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
        this.alumnoId = id;
    }

    public Alumno(String nombre, String apellidoP, String apellidoM) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public Alumno(long alumnoId, String nombre, String apellidoP, String apellidoM) {
        this.alumnoId = alumnoId;
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
     * @return the alumnoId
     */
    public long getAlumnoId() {
        return alumnoId;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumnoId(long alumnoId) {
        this.alumnoId = alumnoId;
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
