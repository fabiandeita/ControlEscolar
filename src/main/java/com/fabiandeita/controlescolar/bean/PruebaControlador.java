/*
 * Controlador que se comunica con los Dao's, se describe la interaccion con la tabla del alumno 
 */
package com.fabiandeita.controlescolar.bean;

import com.fabiandeita.controlescolar.dao.AlumnoDao;
import com.fabiandeita.controlescolar.dao.HibernateUtil;
import com.fabiandeita.controlescolar.dao.MaestroDao;
import com.fabiandeita.controlescolar.dao.MateriaDao;
import com.fabiandeita.controlescolar.model.Alumno;
import com.fabiandeita.controlescolar.model.Maestro;
import com.fabiandeita.controlescolar.model.Materia;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.event.ActionEvent;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
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
   
    private AlumnoDao  alumnoDao;
    private MaestroDao maestroDao;
    private MateriaDao materiaDao;
    private List       listaAlumnos;
    private List       listaMaestros;
    private List       listaMateria;
    private Alumno     alumno;
    private Alumno     alumnoTemp;
    private Maestro    maestro;
    private Maestro    maestroTemp;
    private Materia    materia;
    private Materia    materiaTemp;
    private List<SelectItem> listaMaterias;
    private List<SelectItem> listaMaestross;

    
    public PruebaControlador(){   
        alumnoDao   = new AlumnoDao();
        maestroDao  = new MaestroDao();
        materiaDao  = new MateriaDao();
        alumnoTemp  = new Alumno();
        maestroTemp = new Maestro();
        materiaTemp = new Materia();
        
        materiaTemp.setMaestro(new  Maestro());
        cargarMaterias();
        //cargarMaestros();
    }
    
    public void cargarMaterias(){
        listaMaterias = new ArrayList<SelectItem>();
        listaMaterias.clear();
        for(Materia materia : (List<Materia>)materiaDao.consultaMateria())
            listaMaterias.add(new SelectItem(materia.getMateriaId(), materia.getNombre()));
    }
    
    public void estableceMateria(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null){
            //materiaTemp.setMateriaId(Long.parseLong(event.getNewValue().toString()));
            System.out.println("Evento antes: " );
//            System.out.println("Evento: " + event.getNewValue()  + " Termina evento" );     
            System.out.println("Evento DESPUES: " );
        }
    }
      
    
    public void cargarMaestros(){
        listaMaestross = new ArrayList<SelectItem>();
        listaMaestross.clear();
        for(Maestro maestro : (List<Maestro>)maestroDao.consultaMaestro())
            listaMaestross.add(new SelectItem(maestro.getMaestroId(), maestro.getNombre()));
    }
//    
    public void estableceMaestro(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null){
            System.out.println("String 1: " + event.getNewValue().toString());
            System.out.println("String 2: " + event.getNewValue().toString());
//            long id = Long.parseLong(event.getNewValue().toString());
//            System.out.println("ID: " + id);
        }
    }
    
    
    public void addEstudiante(ActionEvent event){
        alumnoDao.addAlumno(alumnoTemp);
        fillListaAlumnos();
    }
    
    public void addMaestro(ActionEvent event){
        maestroDao.addMaestro(maestroTemp);
        fillListaMaestros();
    }
    
    public void addMateria(ActionEvent event){
        materiaDao.addMateria(materiaTemp);
        fillListaMateria();
    }
    
    public void updateEstudiante(ActionEvent event){
        alumno = (Alumno)event.getComponent().getAttributes().get("alumno");
        alumnoDao.updateAlumno(alumno);
    }
    
    public void updateMaestro(ActionEvent event){
        maestro = (Maestro)event.getComponent().getAttributes().get("maestro");
        maestroDao.updateMaestro(maestro);
    }
    
    public void updateMateria(ActionEvent event){
        materia = (Materia)event.getComponent().getAttributes().get("materia");
        materiaDao.updateMateria(materia);
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
    
    public void deleteMateria(ActionEvent event){
        Materia materia = (Materia)event.getComponent().getAttributes().get("materia");
        materiaDao.deleteMateria(materia); 
        fillListaMateria();
    }
    
    public void fillListaAlumnos(){
        listaAlumnos = alumnoDao.consultaAlumno();
    }
    
    public void fillListaMaestros(){
        listaMaestros = maestroDao.consultaMaestro();
    }
    
    public void fillListaMateria(){
        listaMateria = materiaDao.consultaMateria();
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
    
    public Maestro getMaestroTemp() {
        return maestroTemp;
    }

    public void setMaestroTemp(Maestro maestroTemp) {
        this.maestroTemp = maestroTemp;
    }

    public Materia getMateriaTemp() {
        return materiaTemp;
    }

    public void setMateriaTemp(Materia materiaTemp) {
        this.materiaTemp = materiaTemp;
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
    
    
    public List getListaMateria() {
        return listaMateria;
    }
    public void setListaMateria(List listaMateria) {
        this.listaMateria = listaMateria;
    }
    
    private synchronized void init(){
    }
    
    
    public List<SelectItem> getListaMaestross() {
        return listaMaestross;
    }

    public void setListaMaestross(List<SelectItem> listaMaestross) {
        this.listaMaestross = listaMaestross;
    }

    public List<SelectItem> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<SelectItem> listaMaterias) {
        this.listaMaterias = listaMaterias;
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
    
}
