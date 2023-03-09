package edu.properties.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchingFromProperty {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream("./src/test/resources/Common Data/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String url = p.getProperty("url".trim());
		System.out.println(url);
		
		fis.close();
		p.clear();
		
		
	}

}
