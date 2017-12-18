/*
 * Controlador que se comunica con los Dao's, se describe la interaccion con la tabla del alumno 
 */
package com.fabiandeita.controlescolar.bean;

import com.fabiandeita.controlescolar.dao.AlumnoDao;
import com.fabiandeita.controlescolar.dao.HibernateUtil;
import com.fabiandeita.controlescolar.dao.MaestroDao;
import com.fabiandeita.controlescolar.model.Alumno;
import com.fabiandeita.controlescolar.model.Maestro;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.event.ActionEvent;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
/**
 *
 * @author Emma
 * 
 */
public class PruebaControlador {
    private String     message;
    private AlumnoDao  alumnoDao;
    private MaestroDao maestroDao;
    private List       listaAlumnos;
    private List       listaMaestros;
    private Alumno     alumno;
    private Alumno     alumnoTemp;
    private Maestro    maestro;
    private Maestro    maestroTemp;

    
    public PruebaControlador(){
        message     = "Hello mundo";
        alumnoDao   = new AlumnoDao();
        maestroDao  = new MaestroDao();
        alumnoTemp  = new Alumno();
        maestroTemp = new Maestro();
    }
    
    public void addEstudiante(ActionEvent event){
        alumnoDao.addAlumno(alumnoTemp);
        fillListaAlumnos();
    }
    
    public void addMaestro(ActionEvent event){
        maestroDao.addMaestro(maestroTemp);
        fillListaMaestros();
    }
    
    public void updateEstudiante(ActionEvent event){
        alumno = (Alumno)event.getComponent().getAttributes().get("alumno");
        alumnoDao.updateAlumno(alumno);
    }
    
    public void updateMaestro(ActionEvent event){
        maestro = (Maestro)event.getComponent().getAttributes().get("maestro");
        maestroDao.updateMaestro(maestro);
    }
    
    public void deleteEstudiante(ActionEvent event){
        Alumno alumno = (Alumno)event.getComponent().getAttributes().get("alumno");
        alumnoDao.deleteAlumno(alumno); 
        fillListaAlumnos();
    }
    
    public void deleteMaestro(ActionEvent event){
        Maestro maestro = (Maestro)event.getComponent().getAttributes().get("maestro");
        maestroDao.deleteMaestro(maestro); 
        fillListaAlumnos();
    }
    
    public void fillListaAlumnos(){
        listaAlumnos = alumnoDao.consultaAlumno();
    }
    
    public void fillListaMaestros(){
        listaMaestros = maestroDao.consultaMaestro();
    }
    
    public void clicMaestro(){
        listaMaestros = maestroDao.consultaMaestro();
        for (Maestro maestro : (List<Maestro>)listaMaestros) {
            System.out.println("nombre: " + maestro.getNombre() + " " + maestro.getApellidoP()+ " " + maestro.getApellidoM());
        }
    }
    
    public void listaAlumnos(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();    	
        List studentResult = session.createQuery("select a.nombre, a.apellidoP from " + "alumno a").list();        
        session.getTransaction().commit();
    }
    
    public void leerArchivosDeExcel(){
     
        File f = new File("C:/Users/ecastrmu/Desktop/Relacion.xlsx");
        
        if(f.exists()){
            System.out.println("Si existe");
        }else{
            System.out.println("No existe");
        }
        
        List cellData = new ArrayList();
        try{
            FileInputStream fileInputStream = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet hssfSheet = workbook.getSheetAt(0);
            
            Iterator rowIterator = hssfSheet.rowIterator();
            
            int contadorRow = 0;
            while(rowIterator.hasNext()){
                
                
                XSSFRow hssRow = (XSSFRow) rowIterator.next();
                Iterator iterator = hssRow.cellIterator();
                List cellTemp = new ArrayList();
                
                while(iterator.hasNext()){
                    XSSFCell hssfCell = (XSSFCell) iterator.next();
                    cellTemp.add(hssfCell);
                }
                cellData.add(cellTemp);   
            }         
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("antes del obtener");
        
        obtener(cellData);
        
        System.out.println("después del obtener");
    }
    
    private void obtener(List cellDataList){
        System.out.println("cambio 4 ");
        String nombre = " ";
        float  promedio = 0;
        List nombreAlumnos   = new ArrayList();
        List promedioAlumnos = new ArrayList();
        
        for(int i = 6; i < cellDataList.size(); i++){
            List cellTempList = (List) cellDataList.get(i);
            
            for(int j = 0; j < cellTempList.size(); j++){        
                if(j == 1 || j==2 || j==3 || j==4 || j==5 || j==7 || j==8 || j==9){
                    
                    XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                    String stringCellValue = hssfCell.toString();  
//                  System.out.println(stringCellValue + " ");
                    if(j == 1){
                        nombre = stringCellValue;
                    }
                    if(j==2||j==3||j==4||j==5||j==7||j==8||j==9){
                        promedio += Float.parseFloat(stringCellValue);
                    }
                }
            }
            System.out.println("nombre: " + nombre + " promedio: " + promedio/2);
            
            String [] arrayString = nombre.split(" ");
            String apellidoPaterno = arrayString[0];
            String apellidoMaterno = arrayString[1];
            String nombreAlumno    = arrayString[2];
            
            System.out.println(" " + apellidoPaterno +" " + apellidoMaterno +" " +  nombreAlumno);
            Alumno alumno = new Alumno();
            alumno.setNombre(nombreAlumno);
            alumno.setApellidoP(apellidoPaterno);
            alumno.setApellidoM(apellidoMaterno);
            alumnoDao.addAlumno(alumno);
            
            promedio = 0;
            System.out.println("");        
        }
        fillListaAlumnos();
    }
    
    public Maestro getMaestroTemp() {
        return maestroTemp;
    }

    public void setMaestroTemp(Maestro maestroTemp) {
        this.maestroTemp = maestroTemp;
    }
    

    public Alumno getAlumnoTemp() {
        return alumnoTemp;
    }

    public void setAlumnoTemp(Alumno alumnoTemp) {
        this.alumnoTemp = alumnoTemp;
    }                                 
    
    public List getListaMaestros() {
        return listaMaestros;
    }
    public void setListaMaestros(List listaMaestros) {
        this.listaMaestros = listaMaestros;
    }
    
    public List getListaAlumnos() {
        return listaAlumnos;
    }
    public void setListaAlumnos(List listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    private synchronized void init(){
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}
