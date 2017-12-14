/*
 * To change this license header, choose License Headers in Project Properties.
 */
package com.fabiandeita.controlescolar.dao;

import com.fabiandeita.controlescolar.dao.HibernateUtil;
import com.fabiandeita.controlescolar.model.Maestro;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author ecastrmu
 */
public class MaestroDao {
    private Maestro maestro;
    private String message;
    
    public MaestroDao(){
        message = "Hello mundo";
        
    }
    
    public void addMaestro(Maestro maestro){
        System.out.println("Adicionar------Maestro");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        maestro = new Maestro(11l, "Ruben","Castro","M.");
        session.save(maestro); 
        session.getTransaction().commit(); 
        //init();
    }
    
    public void updateMaestro(Maestro maestro){
        System.out.println("update------Maestro");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        maestro = new Maestro(11l,"Emma","C.","M.");
        session.update(maestro); 
        session.getTransaction().commit(); 
    }
    
    public void deleteMaestro(Maestro maestro){
        System.out.println("delete------Maestro");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
//      maestro = new Maestro(11);
        session.delete(maestro); 
        session.getTransaction().commit();
    }
    
    public List consultaMaestro(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session.createQuery(" from Maestro").list();
    }
    
    private synchronized void init(){ 
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List studentResult = session.createQuery("select m.maestro_Id from " +
                "maestro as m").list();        
        session.getTransaction().commit(); 
    }

    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
