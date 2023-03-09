package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.ListBoxUtility;

/**
 * this class contains web element of AdminTimetablePage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class AdminTimetablePage {

	@FindBy(xpath="//select[@id='grade']")
	private WebElement grade1dropdown;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbtn1;
	
	@FindBy(xpath="//a[@onclick='showModal(this)']")
	private WebElement addbtn;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement daydropdown;
	
	@FindBy(xpath="//select[@id='subject']")
	private WebElement subjectdropdown;
	
	@FindBy(xpath="//select[@id='teacher']")
	private WebElement teacherdropdown;
	
	@FindBy(xpath="//select[@id='classroom']")
	private WebElement classroomdropdown;
	
	@FindBy(id="start_time")
	private WebElement starttimetxt;
	
	@FindBy(id="end_time")
	private WebElement endtimetxt;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitbtn;
	
	public AdminTimetablePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addGradedropdown(ListBoxUtility dropdown, String grade1)
	{
		dropdown.selectDropDownVisibilityTextBased(grade1dropdown, grade1);
		submitbtn1.click();
	}
	
	public void clickOnAddButton()
	{
		addbtn.click();
	}
	
	public void addSubjectRouteDD(ListBoxUtility dropdown,String day,String subject,String teacher,String classroom, String starttime, String endtime)
	{
		dropdown.selectDropDownVisibilityTextBased(daydropdown, day);
		dropdown.selectDropDownVisibilityTextBased(subjectdropdown, subject);
		dropdown.selectDropDownVisibilityTextBased(teacherdropdown, teacher);
		dropdown.selectDropDownVisibilityTextBased(classroomdropdown, classroom);
		starttimetxt.sendKeys(starttime);
		endtimetxt.sendKeys(endtime);
		submitbtn.click();
	}
}
