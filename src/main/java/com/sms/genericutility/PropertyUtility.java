package com.sms.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.sms.genericutility.Enums.PropertyKey;

/**
 * This class contains all the reusable methods in order to retrieve the data from property files.
 * the data is store in key,value pair format.
 * @author Deepak
 *
 */
public class PropertyUtility {

	private Properties p;
	/**
	 * Constructor to initialize the data
	 * @param filepath
	 */
	public PropertyUtility(String filepath)
	{
		FileInputStream fis2=null;
		
		try {
			   fis2=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			p=new Properties();
			p.load(fis2);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public PropertyUtility()
	{
		
	}
	
	/** Initializing the property data;
	 * @param FilePath
	 * @author Deepak Patil
	 */
	
	@Deprecated
	public void initializePropertyFile(String FilePath)   
	{
		FileInputStream fis2=null;
		
		try {
			   fis2=new FileInputStream(FilePath);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			p=new Properties();
			p.load(fis2);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is use to fetch the data from excel based on excel.	
	 * @param key
	 * @return
	 * @author Deepak Patil
	 */
	public String getPropertyData(PropertyKey key)
	{
		String keyString=key.name().toLowerCase();
		String value = p.getProperty(keyString,"please give proper key"+"keyString").trim();
		return value;
	} 
	
	/*public String getPropertydata(String key)
	{
		 String value = p.getProperty(key);
		 return value;
 	}*/
	
}
