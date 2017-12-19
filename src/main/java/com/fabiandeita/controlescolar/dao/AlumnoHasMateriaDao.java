/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.dao;

import com.fabiandeita.controlescolar.model.AlumnoHasMateria;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ecastrmu
 */
public class AlumnoHasMateriaDao {
    
    
    private AlumnoHasMateria alumnoHasMateria;
    
    public AlumnoHasMateriaDao(){        
    }
    
    public void addAlumnoHasMateria(AlumnoHasMateria alumnoHasMateria){
        System.out.println("Adicionar------AlumnoHasMateria");
//        maestro.setMaestro_id(11l);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(alumnoHasMateria); 
        session.getTransaction().commit(); 
       
    }

    public void updateMaestro(AlumnoHasMateria alumnoHasMateria){
        System.out.println("update------AlumnoHasMateria");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(alumnoHasMateria); 
        session.getTransaction().commit(); 
    }
    
    public void deleteMaestro(AlumnoHasMateria alumnoHasMateria){
        System.out.println("delete------AlumnoHasMateria");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(alumnoHasMateria); 
        session.getTransaction().commit();
    }
    
    public List consultaMaestro(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //select * from alumno_has_materia;
        //select * from Alumno_has_materia;
        return session.createQuery(" from alumno_has_materia").list();
    }
    
    private synchronized void init(){ 
    }
    
    
    
    
    
    
}
