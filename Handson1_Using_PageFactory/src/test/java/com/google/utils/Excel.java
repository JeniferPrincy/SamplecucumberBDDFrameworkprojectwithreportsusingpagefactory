package com.google.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excel {
	public Excel(WebDriver driver) {
	}

	public  void excelData(int value )throws IOException{

			String filepath= (".\\Data.xlsx");
			File file= new File(filepath);
			FileOutputStream fos=new FileOutputStream(file);
		        //create the blank workbook
			Workbook wb= new XSSFWorkbook();
		        //create the blank excel sheet
			Sheet sh= wb.createSheet("Data");
			//define the position in the excel sheet where write operation needs to perform
		        Row rw= sh.createRow(0);
			Cell cl=rw.createCell(0);
			Cell cl1=rw.createCell(1);
		        //define input type
			cl.setCellType(CellType.forInt(0));
			cl1.setCellType(CellType.forInt(0));
		        //define the data value
			cl.setCellValue("The number of links available is");
			sh.autoSizeColumn(0);
			cl1.setCellValue(value);
		        //write the workbook
			wb.write(fos);
		
	}





}