package com.sms.genericutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the generic methods in order to handle all the actions on web page by using javascript executor.
 * @author Deepak
 *
 */
public class JavaScriptUtility {

	JavascriptExecutor js;
	
	public JavaScriptUtility(WebDriver driver)
	{
		js=(JavascriptExecutor)driver;
	}
	
	/**
	 * This method will be used to scroll down till the bottom of web page.
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		 
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");	
	}
	
	/**
	 * This method will be used to scroll up till the header of web page.
	 * @param driver
	 */
	public void scrollUp(WebDriver driver)
	
	{
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	/**
	 * This method will be used to scroll  till the required element on web page.
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	/**
	 * This method will be used to click on web element on web page.
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()",element);
	}
	
	/**
	 * This method will be used to send the keys into the textfield.
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element,String data)
	{
		js.executeScript("arguments[0].value=arguments[1]",element,data);
	}

	/**
	 * This method will be used to launch the application.
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=arguments[0]",url);
	}


	public void highlight(WebElement element)
	{
		js.executeScript("arguments[0].setAttribute('style','border:6px solid black')", element);
	}

}
