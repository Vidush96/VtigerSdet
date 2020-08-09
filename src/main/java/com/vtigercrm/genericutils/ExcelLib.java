package com.vtigercrm.genericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author hp
 *
 */
public class ExcelLib 
{
	/*Excel Data sheet file path*/
	String filepath="./testData/testScriptData.xlsx";
	/**
	 * Used get data from Excel Data sheet
	 * @param sheet
	 * @param rownum
	 * @param cellnum
	 * @return cell value
	 * @throws Throwable
	 */
	public String getExcelData(String sheet,int rownum,int cellnum)throws Throwable
	{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(rownum);
		wb.close();
		return rw.getCell(cellnum).getStringCellValue();
	}
	
	/**
	 * Used to store data in excel sheet
	 * @param sheet
	 * @param rownum
	 * @param column
	 * @param Data
	 * @throws Throwable
	 */
	public void setExcelData(String sheet,int rownum,int column,String Data)throws Throwable
	{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(rownum);
		Cell ccell = rw.createCell(column);
		ccell.setCellValue(Data);
		FileOutputStream fout = new FileOutputStream(filepath);
		         wb.write(fout);
		wb.close();
	}
	
	/**
	 * Used to get used row count in excel data sheet
	 * @param sheet
	 * @return Row Count
	 * @throws Throwable
	 */
	public int getRowCount(String sheet)throws Throwable
	{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		wb.close();
		return sh.getLastRowNum();
	}
}


