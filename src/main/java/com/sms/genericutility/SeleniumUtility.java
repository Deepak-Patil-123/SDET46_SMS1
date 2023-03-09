package com.sms.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {

	WebDriver driver=null;
	
	public WebDriver launchBrowser(String browser,String...s)
	{
		switch(browser)
		{
		case "chrome":
		{
			if(s[0].equals("option"))
			{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
			}
			else
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();			
			}
			break;
		}
		case "firefox":
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		}
		case "edge":
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		}
		default :
		{
			System.out.println("invalid browser entered!");
		}
		}
		return driver;
	}
}
