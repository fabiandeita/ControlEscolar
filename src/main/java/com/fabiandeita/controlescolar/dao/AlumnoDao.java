/*
 * To .
 * and .
 */
package com.fabiandeita.controlescolar.dao;
import com.fabiandeita.controlescolar.bean.PruebaControlador;
import com.fabiandeita.controlescolar.model.Alumno;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 * @author ecastrmu
 */
public class AlumnoDao {
    
    private Alumno alumno;
    public AlumnoDao(){    
    }
    
    public void addAlumno(Alumno alumno){
//                System.out.println("Alumno DAO ---------------------------------------");
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();                
                session.save(alumno); 
                session.getTransaction().commit();
    }
    
    public void updateAlumno(Alumno  alumno){
                System.out.println("id: " + alumno.getEstudianteId());
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("apP: " + alumno.getApellidoP());
                System.out.println("apM: "+  alumno.getApellidoM());
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
                session.update(alumno); 
                session.getTransaction().commit();
    }
    
    public void deleteAlumno(Alumno alumno){
                System.out.println("Delete Alumno ----------");
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction(); 
                session.delete(alumno);
                session.getTransaction().commit();           
    }
    
    public List consultaAlumno(){
               Session session = HibernateUtil.getSessionFactory().getCurrentSession();
               session.beginTransaction();
               return session.createQuery(" from Alumno").list(); 
//              List studentResult = session.createQuery("select a.nombre from " + "alumno a").list();            
    }
    
    private synchronized void init()
    { 
    }
}
