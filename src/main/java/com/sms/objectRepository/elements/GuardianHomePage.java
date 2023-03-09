package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains web element of GuardianHomePage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class GuardianHomePage {

	@FindBy(xpath="//span[text()='Teacher']")
	private WebElement teachertab;
	
	@FindBy(xpath="//a[@href='all_teacher3.php']")
	private WebElement allteachertab;
	
	@FindBy(xpath="//span[text()='mr.rajat']")
	private WebElement profiletab;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutbtn;
	
	@FindBy(xpath="//span[text()='Exam']")
	private WebElement examtab;
	
	@FindBy(xpath="//a[@href='my_sons_exam_marks.php']")
	private WebElement mysonsexammarks;
	
	@FindBy(xpath="//span[text()='Timetable']")
	private WebElement timetabletab;
	
	@FindBy(xpath="//a[@href='all_timetable3.php']")
	private WebElement alltimetabletab;
	
	public GuardianHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTeacherTab()
	{
		teachertab.click();
	}
	
	public void clickOnAllTeacherTab()
	{
		allteachertab.click();
	}
	
	public void clickOnLogout()
	{
		profiletab.click();
		signoutbtn.click();
	}
	public void clickOnExamTab()
	{
		examtab.click();
		mysonsexammarks.click();
	}
	
	public void clickOnTimetableTab()
	{
		timetabletab.click();
	}
	
	public void alltimetabletab()
	{
		alltimetabletab.click();
	}
}
