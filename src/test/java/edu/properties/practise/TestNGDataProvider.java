package edu.properties.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sms.genericutility.ExcelUtility;

public class TestNGDataProvider {

	@Test(dataProvider="getMultipleData")
	public void getData(String firstname,String lastname,String runs)
	{
		System.out.println(firstname+" "+lastname+" "+runs);
		
	}

	@DataProvider
	public String[][] getMultipleData() throws EncryptedDocumentException, IOException
	{
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream("./src/test/resources/TestNG.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("TestNG");
		int rowcount=sheet.getLastRowNum();    
		System.out.println(rowcount);       //11
		
		String ar[][]=new String[rowcount][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1; i<=rowcount; i++)  //2 row -12 row =11 rows
		{
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
			{
				ar[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			} // ar[i-1]=bcz array index start from zero if we 
			  //start directly ar[i] that means it will be array 
			  //index out of bound exception.
		} 
		return ar; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
