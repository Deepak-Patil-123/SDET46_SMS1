package com.sms.genericutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the generic methods in order to switch the frames, based on index,String value based.
 * @author Deepak
 *
 */
public class FrameUtility {

	WebDriver driver;
	/**
	 * This method will be use to switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 *  This method will be use to switch the frame based on name or id
	 * @param driver
	 * @param name or id
	 */
	public void switchToFrame(String nameORid)
	{
		driver.switchTo().frame(nameORid);
	}
	
	/**
	 *  This method will be use to switch the frame based on webelement
	 * @param driver
	 * @param element
	 */	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/** 
	 * This method will be use to switch to default frame.
	 * @param driver 
	 */
	public void switchToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will be use to scroll down to 500 units
	 * @param driver
	 */
	public void scrollAction()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
	/**
	 * This method will scroll untill a particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollTo(0,"+y+")",element);
	}
	
}
