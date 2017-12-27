
package com.fabiandeita.controlescolar.model;

//import java.io.Serializable;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;



@Entity
@Table(name = "materiaprueba")
public class Materia  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "materia_id")
    private Long materiaId;
    
    @Column (name="nombre")
    private String nombre;

    @ManyToMany(mappedBy = "materias")
    private List<Maestro> maestros = new ArrayList<Maestro>();
    
    
    public Materia() 
    {    }

    public Materia(Long materiaId, String nombre) {
//        this.maestro = new HashSet<Maestro>();
        this.materiaId = materiaId;
        this.nombre = nombre; 
    }

    public List<Maestro> getMaestros() {
        return maestros;
    }

    public void setMaestros(List<Maestro> maestros) {
        this.maestros = maestros;
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
    
    public void addMaestro(Maestro maestro){
        this.maestros.add(maestro);
        maestro.addMateria(this);
    }

}
