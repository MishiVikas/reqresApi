package com.restAssured.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook book ;
	
	
	
	public static int getRowCount (String xlFile, String xlSheet) throws IOException
	{
		fi = new FileInputStream(xlFile);
		book = new XSSFWorkbook(fi);
		int rowCount =  book.getSheet(xlSheet).getLastRowNum();
		book.close();
		fi.close();
		return rowCount;		
	}
	
	public static int getcellCount (String xlFile, String xlSheet, int rownum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		book = new XSSFWorkbook(fi);
		int cellCount =  book.getSheet(xlSheet).getRow(rownum).getLastCellNum();
		book.close();
		fi.close();
		return cellCount;		
	}
	
	public static String getCellData (String xlFile, String xlSheet, int rownum,int cellNum) throws IOException
	{
		fi = new FileInputStream(xlFile);
		book = new XSSFWorkbook(fi);
		String data;
		try
		{
		String cellData =  book.getSheet(xlSheet).getRow(rownum).getCell(cellNum).getStringCellValue();
		return cellData;
		}
		catch (Exception e)
		{
			data = "";
		}
		book.close();
		fi.close();
		return data;			
	}
	
	public static void setCellData (String xlFile, String xlSheet, int rownum,int cellNum, String data) throws IOException
	{
		fi = new FileInputStream(xlFile);
		book = new XSSFWorkbook(fi);
	    book.getSheet(xlSheet).getRow(rownum).createCell(cellNum).setCellValue(data);
	    fo = new FileOutputStream(xlFile);
	    book.write(fo);
		book.close();
		fi.close();	
		fo.close();
	}
	
	
	
	
	
	
	
	
}
