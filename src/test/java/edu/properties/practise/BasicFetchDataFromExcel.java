package edu.properties.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class BasicFetchDataFromExcel {
  
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//Step 1:- converting physical file into java readable file.
		
		FileInputStream fis=new FileInputStream("./src/test/resources/ExecutionDetails.xlsx");
		
		// Step 2:- Open Excel
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3:- Get control on excel sheet
		
		Sheet sheet = wb.getSheet("Execution");
		
		//step 4:- Get control on row
		
		Row row = sheet.getRow(1);
		
		// Step 5:- Get control on cell
		
		Cell cell = row.getCell(0);
		
		//Step 6:- fetch the data from cell
		
		String data = cell.getStringCellValue();
		
		//Step 7:- Utilize the data
		
		System.out.println(data);
		
		//Step 8:- Close the excel work book
		
		wb.close();
		
		
		
		
		
	}

}
