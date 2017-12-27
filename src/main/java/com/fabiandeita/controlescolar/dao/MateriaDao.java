/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.dao;

import com.fabiandeita.controlescolar.model.Materia;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ecastrmu
 */
public class MateriaDao {

    private Materia materia;
    
    public MateriaDao(){    
    }
    
    public void addMateria(Materia materia){
//                System.out.println("Materia DAO ---------------------------------------");
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();                
                session.save(materia); 
                session.getTransaction().commit();
    }
    
    public void deleteMateria(Materia materia){
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();                
                session.delete(materia); 
                session.getTransaction().commit();
    }
    
    public void updateMateria(Materia materia){
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();                
                session.update(materia); 
                session.getTransaction().commit();
    }
        
    public List consultaMateria(){
               Session session = HibernateUtil.getSessionFactory().getCurrentSession();
               session.beginTransaction();
               return session.createQuery(" from Materia").list(); 
    }
    
    public List consultaMateriaJoinMaestros(){
               Session session = HibernateUtil.getSessionFactory().getCurrentSession();
               session.beginTransaction();
               return session.createQuery("from MaestropruebaMateriaprueba ").list(); 
    }
    
/*
SELECT DISTINCT mat.materia_id, mat.nombre, mae.maestro_id 
				from materiaprueba as mat, 
                maestroprueba as mae, 
                maestroprueba_materiaprueba as maemat 
                WHERE maemat.maestros_maestro_id = mae.maestro_id 
                AND maemat.materias_materia_id = mat.materia_id
;
*/
    
}
