package com.sms.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * WebDriverUtility class contains all the reusable method's in order to perform various operation
 * with the help of driver(browser object referance).
 * @author Deepak
 *
 */
public class WebDriverUtility {
	
	private WebDriver driver;
	//String browser="";
	
	public WebDriverUtility()
	{
		
	}
	
	/**
	 * This method will be used for in order to open the browsers.
	 * @param browser
	 * @return 
	 */
	public WebDriver openBrowser(String browser, @Optional String s)
	{
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			 driver=new ChromeDriver();               
		}
		
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();		
		}
		
		else if(browser.equals("ie")){
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}	
		return driver;
	}
	
	/**
	 * This method is used to enter the url navigate to the particular application.
	 */
	public void getURL(String url)
	{
		driver.get(url);
	}
	
	/**
	 * This method is used to close the current tab.
	 */
	public void closeBrowser()
	{
		driver.close();
	}
	
	/**
	 * This method is used to close all the tabs.
	 */
	public void quitBrowser()
	{
		driver.quit();
	}
	
	/**
	 *  maximizing the browser.
	 */
	public void browserMaximize()
	{
		driver.manage().window().maximize();
	}	
	
	
	/**
	 * This method will take screenshot and save it in screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	
	public String taketheScreenShot(String testcasename,DateUtility dateutil)
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/"+testcasename+"_"+dateutil.currentDate()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	
	public String taketheScreenShot()
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
	
	/**
	 * This method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh)
		{
			WebDriver currentWinTitle = driver.switchTo().window(wh);
			String title = currentWinTitle.getTitle();
			if(title.equals(partialWinTitle))
			{
				break;
			}
		}
	}

	/**
	 * This method will be use to get current url
	 * @param driver
	 * @return
	 */
	public String getCurrentURL(WebDriver driver)
	{
		String currenturl=driver.getCurrentUrl();
		return currenturl;
	}
	
	/**
	 *  This Method is used to get the html code of particular web page
	 * @param driver
	 * @return
	 */
	public String getPageSource(WebDriver driver)
	{
		String htmlsourcecode = driver.getPageSource();
		return htmlsourcecode;
	}
	
	/**
	 * This method will be used inorder to click on element on web page
	 * @param driver
	 * @param element
	 */
	
	public void clickOnWebElement(WebElement element)
	{
		element.click();
	}
	
	/** 
	 * This method will be used inorder to click on submit button on web page
	 * @param element
	 */
	public void clickOnSubmitButton(WebElement element)
	{
		element.submit();
	}
	
	/**
	 *  This method will be used inorder to send data in sendkeys method.
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element,String data)
	{
		element.sendKeys(data);
	}
	
	/**
	 *  This method will be used inorder to clear the text field of element on web page 
	 * @param element
	 */
	
	public void clearDataOfWebElement(WebElement element)
	{
		element.clear();
	}
	
	/**
	 * This method will be use to verify whether element(checkbox) is selected or not
	 * @param element
	 * @return
	 */
	public boolean isCheckboxSelected(WebElement element)
	{
		boolean cbx = element.isSelected();
		if(cbx==true) {
			System.out.println("checkbox is selected!");
			return true;
		}
		else {
			System.out.println("checkbox is not selected!");
			return false;
		}
	}
	/**
	 * This method will be use to verify whether element is displayed or not
	 * @param element
	 * @return
	 */
	public boolean isElementDisplayed(WebElement element)
	{
		boolean cbx = element.isDisplayed();
		if(cbx==true) {
			System.out.println("element is displayed!");
			return true;
		}
		else {
			System.out.println("element is not displayed!");
			return false;
		}
	}
	
	/**
	 * This method will be use to verify whether element is enabled or not
	 * @param element
	 * @return
	 */
	
	public boolean isElementEnabled(WebElement element)
	{
		boolean cbx = element.isEnabled();
		if(cbx==true) {
			System.out.println("element is Enabled!");
			return true;
	}
		else {
			System.out.println("element is not Enabled!");
			return false;
		}
		
	}
	
	/**
	 * This method will be use to get the text of web element
	 * @param element
	 * @return
	 */
	public String getText(WebElement element)
	{
		String text = element.getText();
		return text;
	}
	
	/**
	 * This method will be use to get the tagname of web element
	 * @param element
	 * @return
	 */
	public String getTag(WebElement element)
	{
		String text = element.getTagName();
		return text;
	}
	
	/**
	 * This method will be use to get the css value of web element
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public String getCSSValue(WebElement element,String attributeName)
	{
		String text = element.getCssValue("attributeName");
		return text;
	}

	/**
	 * This method is used to launch the application.
	 * we can use navigate().to() method instead of get() method.
	 * @param url
	 */
	public void navigateTo(String url)
	{
		driver.navigate().to(url);
	}
	
	/**
	 * This method is used to navigate on forward page of application.
	 * @param url
	 */
	public void navigateToForward()
	{
		driver.navigate().forward();
	}
	
	
	
	/**
	 * This method is used to navigate on backward page of  application.
	 * @param url
	 */
	public void navigateToBack()
	{
		driver.navigate().back();
	}
	
	/**
	 * This method is used to refresh current page of  application.
	 * @param url
	 */
	public void navigateToRefresh()
	{
		driver.navigate().back();
	}
	
	
	
}