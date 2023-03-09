package edu.properties.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PractiseExcell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream("./src/test/resources/Common Data/SchoolFile.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("SchoolData");
		int rowcount = sheet.getLastRowNum();
		
		String ExpTestScript="Grade 1";
		String ExpKey = "Student subject";
		String ExpValue = "mauel testing";
		
		for(int i=1; i<=rowcount; i++)
		{
				String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
				 if(testScriptName.equals(ExpTestScript))
				 {
					 for(int j=1; j<sheet.getRow(i).getLastCellNum(); j++)
					 {
						   String key = df.formatCellValue(sheet.getRow(i).getCell(j));
						 if(ExpKey.equals(key))
						 {
							 int count=0;
							for(int k=i+1; k<rowcount; k++)
							{
									String value = df.formatCellValue(sheet.getRow(k).getCell(j));
									System.out.println(value);
									count++;
									
									if(ExpValue.equals(value))
							 		{
										break;
									}												 
							}
						System.out.println(count);	
					     }
			 
				     }
			       }
			
		}
		
	/*	DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream("./src/test/resources/TestScriptData.xlsx");  //physical file converted into java readable format
		Workbook wb = WorkbookFactory.create(fis);  //open the excel sheet.
		Sheet sheet = wb.getSheet("guardian");   // control over excel sheet.
		//System.out.println(sheet);//=sheet.getLastRowNum();
		int rowcount = sheet.getLastRowNum();
		String testscriptname="AddAndVerifyMySonsTimetable";
		Map<String,String> map=new HashMap<>();
		for(int i=1; i<=rowcount; i++)
		{
			String testcasename = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testcasename.equals(testscriptname))
			{
				 short cellcount = sheet.getRow(i).getLastCellNum();
				 for(int j=1; j<=cellcount; j++)
				 {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				 }
				 break;
			}
			
		}
		
	System.out.println(map);   */
	}  

}
