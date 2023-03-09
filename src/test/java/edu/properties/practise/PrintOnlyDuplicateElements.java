package edu.properties.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintOnlyDuplicateElements {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Deepak/OneDrive/Desktop/Hotel.html");
		
		WebElement element = driver.findElement(By.id("mtr"));
		Select s=new Select(element);
		
		List<WebElement> alloptions = s.getOptions();
		int count=alloptions.size();
		
		ArrayList<String> al=new ArrayList<>();
		
		for(int i=0; i<count; i++)
		{
			String text = alloptions.get(i).getText();
			al.add(text);
		}
	//	System.out.println(al);
	HashSet<String> hs=new HashSet<>();
		for(String print:al)
		{
			if((hs.add(print))==false)
				System.out.print(print);
		}  
	
	}
	

}
