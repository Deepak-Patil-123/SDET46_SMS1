package com.sms.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains reusable methods which is used for creating the data,reading the data,updating the data,
 * and saving the data into excel sheet.
 * @author Deepak patil.
 */
public class ExcelUtility {

	Workbook wb;
	DataFormatter df;
	FileInputStream fis;

	public ExcelUtility()
	{
		
	}

	/**
	 * This constructor is used for initializing the non static member's of class.
	 * @param ExcelPath
	 */
	public  ExcelUtility(String ExcelPath)
	{ 
		try {
			
		df=new DataFormatter();
		fis=new FileInputStream(ExcelPath);
		wb=WorkbookFactory.create(fis);
	       }
		
		catch(EncryptedDocumentException e1){
			e1.printStackTrace();
		   }
		catch(IOException e2){
			e2.printStackTrace();
		 }
	}
	
	/**
	 * This method will be use inorder to Initializing the excel data.
	 * @param ExcelPath
	 */
	@Deprecated
	public void initializeExcel(String ExcelPath)
	{ 
		try {
			
		df=new DataFormatter();
		fis=new FileInputStream(ExcelPath);
		wb=WorkbookFactory.create(fis);
	       }
		
		catch(EncryptedDocumentException e1){
			e1.printStackTrace();
		   }
		catch(IOException e2){
			e2.printStackTrace();
		 }
	}
	
	/**
	 * This method will be use to fetch the data from excel based on map hierarchy.
	 * @param sheetName
	 * @param testcasename
	 * @return
	 */
	public Map<String,String> getExcelData(String sheetName,String testcasename)
	{
		Sheet sheet = wb.getSheet(sheetName);
		
		int rowcount = sheet.getLastRowNum();
		//String testcasename="AddandVerifyExamMarks";
		
		Map<String,String> map=new HashMap<>();
		for(int i=0; i<=rowcount; i++)
		{
			String testscriptname = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testscriptname.equalsIgnoreCase(testcasename))
			{
				short cellcount = sheet.getRow(i).getLastCellNum();
				for(int j=1; j<=cellcount; j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value=df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		return map;
	}
	/**
	 * This method will be use to fetch the data from excel based on index
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 */
	public String getExcelDataFromIndex(String sheetname,int row, int cell)
	{
		Sheet sheet = wb.getSheet(sheetname);
		String value = df.formatCellValue(sheet.getRow(row).getCell(cell));
		return value;
	}
	
	/**
	 * This method is use to retrieve the data which is assigned with expected key.
	 * @param sheetname
	 * @param testcasename
	 * @param expkey
	 * @return
	 */
	public String getExcelData(String sheetname, String testcasename,String expkey)
	{
		Sheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		String value="";
		for(int i=0; i<rowcount; i++)
		{
			String testscriptname = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testscriptname.equals(testcasename))
			{
				short cellcount = sheet.getRow(i).getLastCellNum();
				for(int j=1; j<=cellcount; j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equals(expkey))
					{
						 value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;
			}
		}
		return value;
	}
	/**
	 * This method is used to close the excel file.
	 */
	public void close()
	{
		try {
			fis.close();
		}
		catch(IOException e)
		{
			
		}
	}
	
	/**
	 * This method is used to write the data in excel file based on given index
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 */
	public void setData(String sheetname,int rownum, int cellnum)
	{
		wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
	}
	
	
	public List<String> getMultipleExcelData(String sheetname, String testcasename,String expkey)
	{
		Sheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		String value="";
		
		List<String> datalist=new ArrayList<>();
		for(int i=0; i<rowcount; i++)
		{
			String testscriptname = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testscriptname.equals(testcasename))
			{
				short cellcount = sheet.getRow(i).getLastCellNum();
				for(int j=1; j<=cellcount; j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equals(expkey))
					{
						for(int k=i+1; ;k++) {
						 String data = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						if(data.equals(""))
						{
							break;
						}
						else
						{
							datalist.add(data);
						}
						}
						break;
					}
				}
				break;
			}
		}
		return datalist;
	}
	
	/**
	 * This method is used to fetch the multiple data from the excel based on 2D array concept.
	 * This method is used to execute single testcase with multiple test data. 
	 * @param sheetname
	 * @return
	 */
	public String[][] getMultipleData(String sheetname)
	{
		Sheet sheet = wb.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		String ar[][]=new String[rowcount][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
			{
				ar[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return ar;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
