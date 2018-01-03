/*2
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.bean;


import com.fabiandeita.controlescolar.dao.AlumnoDao;
import com.fabiandeita.controlescolar.model.Alumno;
import java.io.Serializable;
import java.util.Iterator;
import javax.faces.event.ActionEvent;
import java.util.List;
import javax.ejb.Stateless;
    
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ecastrmu
 */
@Stateless
@Path("/getListaAlumno")
public class controladorGet implements Serializable{
    
    AlumnoDao alumnoDao;
    List listaAlumnos;
    
    public controladorGet(){
        alumnoDao = new AlumnoDao();
    }
    
    @GET
    public String getListaAlumno(@QueryParam("numero") int numero){
        
        listaAlumnos = alumnoDao.consultaAlumno();  
        String listaString = "";
        
        for (Alumno listaAlumno : (List<Alumno>)listaAlumnos) {
            //System.out.println(" " + listaAlumno.getAlumnoId() + " " + listaAlumno.getNombre() + " " + listaAlumno.getApellidoP() + " " + listaAlumno.getApellidoM() + ",");
            listaString += listaAlumno.getAlumnoId() +","+ listaAlumno.getNombre() +","+ listaAlumno.getApellidoP() +","+ listaAlumno.getApellidoM() + ";";
        }
        
        System.out.println("");
        System.out.println(listaString);
        
        return listaString ;
    }

}
