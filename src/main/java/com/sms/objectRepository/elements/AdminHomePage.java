package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains web element of AdminHomePage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class AdminHomePage {

	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Exam']")
	private WebElement examtab;
	
	@FindBy(xpath="//a[@href='student_exam_marks.php']")
	private WebElement studentexammarkstab;
	
	@FindBy(xpath="//span[text()='Subject Routing']")
	private WebElement subjectroutingtab;
	
	@FindBy(xpath="//span[text()='Timetable']")
	private WebElement timetabletab;
	
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnExamTab()
	{
		examtab.click();
		studentexammarkstab.click();
	}
	
	public void clickOnSubjectRouteTab()
	{
		subjectroutingtab.click();
	}
	
	public void clickOnTimeTableTab()
	{
		timetabletab.click();
	}
}
