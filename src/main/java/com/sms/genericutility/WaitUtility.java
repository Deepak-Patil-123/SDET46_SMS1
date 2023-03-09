package com.sms.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains reusable method's for synchronization of application speed with selenium speed.
 * bcz selenium speed is faster than application speed, hence we have to do synchronization.
 * @author Deepak Patil
 *
 */
public class WaitUtility {

	WebDriver driver;
	WebDriverWait wait;
	
	/*public WaitUtility(WebDriver driver,long timeouts) // Constructor to initialize the non static member of class.
	{
		this.driver=driver;
		 wait=new WebDriverWait(driver, 10);
	}*/
	
	/**
	 * This method is used to stop the execution of selenium for particular duration. this is one of the way to
	 * synchronization of selenium speed with application speed. 
	 * @param duration
	 */
	public void pause(Long duration)
	{
		try {
			Thread.sleep(duration);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/** using implicit wait for synchronization puprpose
	 * @param driver
	 */
	public void implicitWait(WebDriver driver,long timeouts)
	{
		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will be use to wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeInVisible(WebDriver driver,long time,WebElement element) // String xpath 
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/** This method will wait for entire page to load for 20 seconds.
	 * @param driver
	 */
	public void waitForPageLoad()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	/** This Method will be use to wait until the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitElementToBeClicked(WebElement Element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/** This method will be use as Custom wait just to ensure that wait for while until
	 * element to be become clickable.
	 * @param driver
	 * @param element
	 * @param duration
	 */
	public void customWaitTillClick(long pollingTime,int duration,WebElement Element) throws InterruptedException
	{
		int count=0;
		while(count<duration)
		{
			try {
				Element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(pollingTime);
				count++;
			}
		}
		
	/*	public void waitElementToBevisible(WebDriver driver,int time,WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			wait.until(ExpectedConditions.invisibilityOf(Element));
		}   */
	} 
	
	
		
	
	
}
