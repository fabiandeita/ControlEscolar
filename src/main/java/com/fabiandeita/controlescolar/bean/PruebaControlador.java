/*
 * Controlador que se comunica con los Dao's, se describe la interaccion con la tabla del alumno 
 */
package com.fabiandeita.controlescolar.bean;

import com.fabiandeita.controlescolar.dao.AlumnoDao;
//import com.fabiandeita.controlescolar.dao.HibernateUtil;
import com.fabiandeita.controlescolar.dao.MaestroDao;
import com.fabiandeita.controlescolar.dao.MateriaDao;
import com.fabiandeita.controlescolar.model.Alumno;
import com.fabiandeita.controlescolar.model.Maestro;
import com.fabiandeita.controlescolar.model.MaestropruebaMateriaprueba;
import com.fabiandeita.controlescolar.model.Materia;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
//import java.util.HashSet;
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
import org.hibernate.Session;
/**
 *
 * @author Emma
 * 
 */
@Stateless
@Path("/pruebaOperacion")
public class PruebaControlador {
   
    private AlumnoDao  alumnoDao;
    private MaestroDao maestroDao;
    private MateriaDao materiaDao;
    //listaAlumnos = alumnoDao.consultaAlumno();
    //Se usa para retornar el valor del dao alumno
    private List       listaAlumnos;
    private List       listaMaestros;
    private List       listaMateria;
    //lista en relacion de los maestros que imparten la materia
    private List       listaMaestrosMateria;
    private List       listaMateriaMaestros;
    
    private List       listaMateriaJoinMaestros;
    private List       nuevaListaMateriaMaestro;
    
    private Alumno     alumno;
    private Alumno     alumnoTemp;
    private Maestro    maestro;
    private Maestro    maestroTemp;
    private Materia    materia;    
    
    private Materia    materiaTemp;
    
    //Se usa para llenar el combo materias
    private List<SelectItem> listaMaterias;
    
    //private List<SelectItem> listaMaestross;

    @GET
    public String pruebaOperacion(@QueryParam("numero") int numero){
        System.out.println("numero: " + numero);
        System.out.println("numero:Integer.toString(numero) " + numero);
        return Integer.toString(numero) ;
    }
    

    
    public PruebaControlador(){   
        alumnoDao   = new AlumnoDao();
        maestroDao  = new MaestroDao();
        materiaDao  = new MateriaDao();
        alumnoTemp  = new Alumno();
        maestroTemp = new Maestro();
        materiaTemp = new Materia();
        // Checar
        //materiaTemp.setMaestro(new  Maestro());
//        cargarMaterias();
//        cargarMaestros();
    }
    
    public void cargarMaterias(){
        listaMaterias = new ArrayList<SelectItem>();
        listaMaterias.clear();
//        listaMateria = materiaDao.consultaMateria();
        // Not supported transection ()
        for(Materia materia : (List<Materia>)materiaDao.consultaMateria())
//        for(Materia materia : (List<Materia>)listaMateria)
            listaMaterias.add(new SelectItem(materia.getMateriaId(), materia.getNombre()));
        
    }
    
    public void estableceMateria(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null){
//            materiaTemp.setMateriaId(Long.parseLong(event.getNewValue().toString()));
//            System.out.println("Evento antes: " );
//            System.out.println("Evento materia: " + materiaTemp.getMateriaId()  + " Termina evento" );     
            System.out.println("Evento DESPUES: " );
        }
    }
      
//    
//    public void cargarMaestros(){
//        listaMaestross = new ArrayList<SelectItem>();
////        listaMaestross.clear();
//        for(Maestro maestro : (List<Maestro>)maestroDao.consultaMaestro())
//            listaMaestross.add(new SelectItem(maestro.getMaestroId(), maestro.getNombre()));
//    }
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
    
    /**********************************************************************/
    /******************     Adiciona Maestro     **************************/
    /**********************************************************************/
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
//        materia.getMaestros();
        fillListaMateria();
    }
    
    public void fillListaMaestrosDeMateria(ActionEvent event){
        Materia materia = (Materia)event.getComponent().getAttributes().get("materia");    
        listaMaestrosMateria = materia.getMaestros();
    }
    
    
    
    
    public void fillListaMateriaDeMaestros(ActionEvent event){
        Maestro maestro = (Maestro)event.getComponent().getAttributes().get("maestro");    
        listaMateriaMaestros = maestro.getMaterias();
    }

    public List getListaMateriaMaestros() {
        return listaMateriaMaestros;
    }
    public void setListaMateriaMaestros(List listaMateriaMaestros) {
        this.listaMateriaMaestros = listaMateriaMaestros;
    }
    
    public List getListaMaestrosMateria() {
        return listaMaestrosMateria;
    }
    public void setListaMaestrosMateria(List listaMaestrosMateria) {
        this.listaMaestrosMateria = listaMaestrosMateria;
    }
    
    
    public void fillListaAlumnos(){
        listaAlumnos = alumnoDao.consultaAlumno();
    }
    
    public void fillListaMaestros(){
        listaMaestros = maestroDao.consultaMaestro();
    }
    
    public void fillListaMateria(){
        listaMateria = materiaDao.consultaMateria();

        for (Materia matMaestro : (List<Materia>)listaMateria) {
            System.out.println("  " + matMaestro.getNombre() );
            
            for (Maestro maestro1 : (List<Maestro>)matMaestro.getMaestros()) {
                System.out.println(" " + maestro1.getNombre() + " " + maestro1.getApellidoM() );
            }            
        }
    }
    
    public void fillListaMateriaJoinMaestros(){
        listaMateriaJoinMaestros = materiaDao.consultaMateriaJoinMaestros();
        System.out.println(" ");
        for (MaestropruebaMateriaprueba listaMateriaMaestros : (List<MaestropruebaMateriaprueba>)listaMateriaJoinMaestros) {
            System.out.println("Registro " + listaMateriaMaestros.getId().getMaestrosMaestroId() + "  "+listaMateriaMaestros.getId().getMateriasMateriaId());
        }
        
        
    }
    
    public void fillConsultaMateriaIdMaestros(){
        nuevaListaMateriaMaestro = materiaDao.consultaMateriaIdMaestros();
        System.out.println(" " );
        for (Object object : nuevaListaMateriaMaestro) {
            System.out.println(" " + object.toString() );
        }
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
    
    public List<SelectItem> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<SelectItem> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List getListaMateriaJoinMaestros() {
        return listaMateriaJoinMaestros;
    }

    public void setListaMateriaJoinMaestros(List listaMateriaJoinMaestros) {
        this.listaMateriaJoinMaestros = listaMateriaJoinMaestros;
    }
  
    
    /**********************************************************************/
    public void registrarMaestro(ActionEvent event){
        System.out.println("");
        System.out.println(" " + maestroTemp.getNombre() + " " + maestroTemp.getApellidoP() + " " + maestroTemp.getApellidoM());
        System.out.println();
    }
    /**********************************************************************/
    public void regitrarMateria(ActionEvent event){
        System.out.println("");
        System.out.println(" " + maestroTemp.getNombre() + " " + maestroTemp.getApellidoP() + " " + maestroTemp.getApellidoM() + " " + materiaTemp.getNombre());
        System.out.println();
        
        Materia materia = new Materia();
        //El id de la materia es incorrecto puesto que se grab el ultimo 
        materia = materiaTemp;
        materia.addMaestro(maestroTemp);
        materiaDao.addMateria(materia);
        
    }

    public List getNuevaListaMateriaMaestro() {
        return nuevaListaMateriaMaestro;
    }

    public void setNuevaListaMateriaMaestro(List nuevaListaMateriaMaestro) {
        this.nuevaListaMateriaMaestro = nuevaListaMateriaMaestro;
    }
    
    public void saveMaestroMateria(ActionEvent event){
    }
    
    public void pruebaMateria(){
        Maestro maestro1 = new Maestro();
        maestro1.setNombre("maestro1");
        maestro1.setApellidoM("materno1");

        Materia materia1 = new Materia();
        materia1.setNombre("materia1");
    
        Materia materia2 = new Materia();
        materia2.setNombre("materia2");

        Materia materia3 = new Materia();
        materia3.setNombre("materia3");

        materia1.addMaestro(maestro1);
        materia2.addMaestro(maestro1);
        materia3.addMaestro(maestro1);

        Maestro maestro2 = new Maestro();
        maestro2.setNombre("maestro2");

        Materia materia4 = new Materia();
        materia4.setNombre("materia4");
    
        Materia materia5 = new Materia();
        materia5.setNombre("materia5");
    
        Materia materia6 = new Materia();
        materia6.setNombre("materia6");

        materia4.addMaestro(maestro2);
        materia5.addMaestro(maestro2);
        materia6.addMaestro(maestro2);

        materiaDao.addMateria(materia1);
        materiaDao.addMateria(materia2);
        materiaDao.addMateria(materia3);

        maestroDao.addMaestro(maestro1);
        maestroDao.addMaestro(maestro2);
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
