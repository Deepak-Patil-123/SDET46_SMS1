package com.sms.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * This class contains the generic methods which will be used to handle the mouse actions.
 * @author Deepak
 *
 */
public class IntractionUtility {

	WebDriver driver;
	/**This method will be use to handle the mouse hover property
	 * @param element
	 * @param driver
	 */
	public void mouseHoverAction(WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/** 
	 * This method will be use to handle the mover hover property at an offset
	 * @param element
	 * @param driver
	 */
	public void mouseHoverActionOffset(WebElement element, WebDriver driver, int x, int y)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element, x, y).perform();
	}
	
	/**
	 * This method will be use to contextClick Action randomly on webpage
	 * @param driver
	 */
	public void rightClickAction()
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method will be use to contextClick action on particular element on webpage
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method will be use to doubleClick action on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * This method will be use to doubleClick action on particular element on webpage
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/** 
	 * This method will be use inorder to perform drag and drop action
	 * @param driver
	 * @param srcelement
	 */
	public void dragAndDrop( WebElement srcElement, WebElement tarElement)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(srcElement, tarElement).perform();
	}
	
	/** 
	 * This method will press and release enter key
	 * @Abstract window toolkit Exception 
	 */
	public void pressEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
}
