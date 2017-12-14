/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiandeita.controlescolar.bean;

import com.sun.org.apache.xerces.internal.impl.dv.XSSimpleType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import javafx.scene.input.DataFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.DataFormat;

/**
 *
 * @author ecastrmu
 */
public class LeerArchivosDeExcel {
 
    public LeerArchivosDeExcel() throws IOException{
 //  FileInputStream fileName
 
//        List cellData = new ArrayList();
//        try{
//            FileInputStream fileInputStream = new FileInputStream(fileName);
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
    
    public void leerEscribir()throws IOException{
        
        System.out.println("Leyo la clase");
        System.out.println("Leyo la clase");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("FirstExcelSheet");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("1, Cell");
        
        cell = row.createCell(1);
        DataFormat format = workbook.createDataFormat();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        cell.setCellStyle(dateStyle);
        cell.setCellValue(new Date());
        
        row.createCell(2).setCellValue("3. Cell");
        
        sheet.autoSizeColumn(1);
        
        workbook.write(new FileOutputStream("file/excel.xlsx"));
        workbook.close();
        
        System.out.println("Leyo la clase fin");
        System.out.println("Leyo la clase fin");
    }
}
