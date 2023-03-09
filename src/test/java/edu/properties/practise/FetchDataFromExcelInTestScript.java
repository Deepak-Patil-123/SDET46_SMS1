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

public class FetchDataFromExcelInTestScript {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String ExpTestScriptName = "";
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream("/src/main/resources/TestCaseExcel/TestScriptData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("guardian");
		int rowcount = sheet.getLastRowNum();
		
		Map<String, String> map=new HashMap<>();
		
		for(int i=1; i<=rowcount; i++)
		{
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equals(ExpTestScriptName))
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
	}

}
 