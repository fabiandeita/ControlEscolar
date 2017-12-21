/*
 *  .
 *  .
 */
package com.fabiandeita.controlescolar.dao;
import com.fabiandeita.controlescolar.model.Alumno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
//                session.close();
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
                System.out.println("Delete Alumno 2----------");
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction(); 
                session.delete(alumno);
                session.getTransaction().commit();
//                //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//                Transaction t = session.getTransaction();
//                t.begin();
//                session.delete(alumno);
//                t.commit();
////                session.close();
//                

//                final Session session = HibernateUtil.getSession();
//                try {
//                  final Transaction transaction = session.beginTransaction();
//                  try {
//                    // The real work is here
//                    transaction.commit();
//                  } catch (Exception ex) {
//                    // Log the exception here
//                    transaction.rollback();
//                    throw ex;
//                  }
//                } finally {
//                  HibernatilUtil.closeSession();
//                }


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
