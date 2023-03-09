package com.sms.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * This class contains reusable methods which is use to handle all the popup's.
 * like alert popup, notification popup, file upload popup, authentication popup, child window popup.
 * @author Deepak
 *
 */
public class PopupUtility {

	/**
	 * This method is used to handle alert popup and click on ok button.
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to handle alert popup and click on cancel button.
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to get the text present on alert popup
	 * @param driver
	 * @return
	 */
	
	public String switchToAlertWindowPopupAndGetText(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This method is used to handle notification popup
	 * @param driver
	 * @param browser
	 */
	public void disbaleNotification(WebDriver driver,String browser)
	{
		if(browser.equals("Chrome"))
		{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		}
		
		if(browser.equals("Firefox"))
		{
		FirefoxOptions option=new FirefoxOptions();
		option.addArguments("--disable-notifications");
		driver=new FirefoxDriver(option);
		}	
	}
	 
	/**
	 * This method is used to Handle Authentication popup
	 * @param driver
	 * @param url
	 * @param un
	 * @param pw
	 */
	public void handleAuthenticationPopup(WebDriver driver,String url, String un, String pw)
	{
		driver.get(url);
	}
	
		
	
}
