package com.sms.objectRepository.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.ListBoxUtility;
/**
 * this class contains web element of My Sons Exam Page, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class MySonsExamPage {

	WebDriver driver;
	
	@FindBy(xpath="//select[@id='exam']")
	private WebElement examdropdown;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbtn;
	
	String partialxpath="//td[text()='%s']/../td[3]";
	
	private WebElement convertToElement(String partialxpath, String replaceData)
	{
		String axpath=String.format(partialxpath, replaceData);
		return driver.findElement(By.xpath(axpath));
	}

	public MySonsExamPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String fetchSubjectData(String subject1)
	{
	   return  convertToElement(partialxpath,subject1).getText();
	}
	
	
	
	public void selectexamdd(ListBoxUtility dropdown,String examoption1)
	{
		dropdown.selectDropDownVisibilityTextBased(examdropdown, examoption1);
		submitbtn.click();
	}
}
