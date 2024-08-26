package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtils {

public static String getCellData(String xlpath,String SheetName,int row,int cell)
{
	String v ="";
	
	try {
		FileInputStream fis = new FileInputStream(xlpath);
		Workbook wb = WorkbookFactory.create(fis);
		v = wb.getSheet(SheetName).getRow(row).getCell(cell).toString();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return v;
	
}

	public static int getRowCount(String Xlpath,String SheetName)
	{
		int rc = 0;
		try {
			FileInputStream fis = new FileInputStream(Xlpath);
			Workbook wb = WorkbookFactory.create(fis);
			rc = wb.getSheet(SheetName).getLastRowNum();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rc;
		
	}
	
	public static int getCellCount(String Xlpath,String SheetName,int row)
	{
		int cc = 0;
		try {
			FileInputStream fis = new FileInputStream(Xlpath);
			Workbook wb = WorkbookFactory.create(fis);
			cc = wb.getSheet(SheetName).getRow(row).getLastCellNum();
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return cc;
	}
	}
