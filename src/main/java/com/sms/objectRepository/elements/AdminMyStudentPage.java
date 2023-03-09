package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains web element of AdminMyStudentPage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class AdminMyStudentPage {

	@FindBy(xpath="//td[@id='td1_30']/parent::tr//a[text()='Edit Exam Marks']")
	private WebElement editexammarksbutton;
	
	@FindBy(xpath="//td[@id='eSubject_td_1']/parent::tr//input[@id='exam_mark_1']")
	private WebElement mathsubtxtfield;
	
	@FindBy(xpath="//td[@id='eSubject_td_2']/parent::tr//input[@id='exam_mark_2']")
	private WebElement seleniumsubtxtfield;
	
	@FindBy(id="btnSubmit3")
	private WebElement updatebtn; 
	
	@FindBy(xpath="//td[@id='td1_30']/parent::tr//a[text()='View Exam Marks']")
	private WebElement viewexammarkstab;
	
	public AdminMyStudentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnEditExamMark()
	{
		editexammarksbutton.click();
	}
	public void editExamMarksDD(String mathmarks,String seleniummarks)
	{
		mathsubtxtfield.clear();
		seleniumsubtxtfield.clear();
		mathsubtxtfield.sendKeys(mathmarks);
		seleniumsubtxtfield.sendKeys(seleniummarks);
		updatebtn.click();
	}
	
	public void viewexammarks()
	{
		viewexammarkstab.click();
	}
	
	
	
	
	
	
}
