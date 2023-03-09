package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.ListBoxUtility;
import com.sms.genericutility.WaitUtility;

/**
 * this class contains web element of AdminSubjectRoutePage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class AdminSubjectRoutePage {
	 
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-sm pull-right']")
	private WebElement addbutton;
	
	@FindBy(xpath="//select[@id='grade']")
	private WebElement gradedropdown;
	
	@FindBy(xpath="//select[@id='subject']")
	private WebElement subjectdropdown;
	
	@FindBy(xpath="//select[@id='teacher']")
	private WebElement teacherdropdwon;
	
	@FindBy(xpath="//input[@id='fee']")
	private WebElement feetxtfield;
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	private WebElement sbmtbtn;
	
	@FindBy(xpath="//div[@id='duplicate_Record2']//div//button")
	private WebElement waitelement1;
	
	@FindBy(xpath="//div[@id='duplicate_Record1']//div//button")
	private WebElement waitelement2;

	
	public AdminSubjectRoutePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void explicitwait1(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitForElementToBeInVisible(driver, timeouts, waitelement1);
	}
	
	public void explicitwait2(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitForElementToBeInVisible(driver, timeouts, waitelement2);
	}
	
	public void clickonAddButton()
	{
		addbutton.click();
	}
	
	public void addSubRouteDD(ListBoxUtility dropdown,String grade,String subject,String teacher,String fee)
	{
		dropdown.selectDropDownVisibilityTextBased(gradedropdown, grade);
		dropdown.selectDropDownVisibilityTextBased(subjectdropdown, subject);
		dropdown.selectDropDownVisibilityTextBased(teacherdropdwon, teacher);
		feetxtfield.sendKeys(fee);
		sbmtbtn.click();
	}
	
}
