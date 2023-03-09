package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.ListBoxUtility;
import com.sms.genericutility.WaitUtility;

/**
 * this class contains web element of AdminSubjectPage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class AdminSubjectPage {

	@FindBy(xpath="//span[text()='Subject']")
	private WebElement subjecttab;
	
	@FindBy(id="name")
	private WebElement subjectnametxt;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-plus']")
	private WebElement addButton;
	
	@FindBy(id="grade")
	private WebElement gradedropdown;
	
	@FindBy(id="subject")
	private WebElement subjectdropdown;
	
	@FindBy(id="teacher")
	private WebElement teacherdropdown;
	
	@FindBy(id="fee")
	private WebElement feetxtfield;
	
	@FindBy(id="btnSubmit")
	private WebElement submitbtn1;
	
	
	@FindBy(xpath="//div[@id='duplicate_Record1']//div/h4")
	private WebElement waitelement1;
	
	@FindBy(xpath="//div[@id='subject_Duplicated']//div//button")
	private WebElement waitElement2;
	
	@FindBy(xpath="//div[@id='duplicate_Record1']//div//button")
	private WebElement waitElement3;
	
	public AdminSubjectPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explicitWait1(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitForElementToBeInVisible(driver, timeouts, waitElement2);
	}
	
	public void explicitWait(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitForElementToBeInVisible(driver, timeouts, waitelement1);
	}
	
	public void explicitWait2(WaitUtility waitutil,long timeouts,WebDriver driver)
	{
		waitutil.waitForElementToBeInVisible(driver, timeouts, waitElement3);
	}
	public void clickOnSubjectTab(String subjectname)
	{
		subjecttab.click();
		subjectnametxt.sendKeys(subjectname);
		submitbtn.click();
	}
	
	public void clickOnAddButton()
	{
		addButton.click();
	}
	public void addSubjectRouteDD(ListBoxUtility dropdown,String grade,String subject,String teacher,String fee)
	{
		dropdown.selectDropDownVisibilityTextBased(gradedropdown, grade);
		dropdown.selectDropDownVisibilityTextBased(subjectdropdown, subject);
		dropdown.selectDropDownVisibilityTextBased(teacherdropdown, teacher);
		feetxtfield.sendKeys(fee);
		submitbtn1.click();
	}
}
