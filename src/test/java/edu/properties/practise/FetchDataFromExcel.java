package edu.properties.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream("./src/test/resources/ExecutionDetails.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Execution");
		
		int rowcount = sheet.getLastRowNum();

		//System.out.println(rowcount); //index=0; row 1= index 0
		
		for(int i=1; i<=rowcount; i++)
		{
			short cellcount = sheet.getRow(i).getLastCellNum();
			for(int j=0; j<cellcount; j++)
			{
				String data = df.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println(data);
			}
			
		}
		
	}

}
