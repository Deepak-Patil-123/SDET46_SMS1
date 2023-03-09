package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains web element of Teacher home page, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class TeacherHomePage {

	@FindBy(xpath="//span[text()='Subject']")
	private WebElement subjecttab;
	
	@FindBy(xpath="//a[text()=' My Subject']")
	private WebElement mysubjecttab;
	
	@FindBy(xpath="//span[text()='mr.kumar']")
	private WebElement profiletab;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutbtn;
	
	public TeacherHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSubjectTab()
	{
		subjecttab.click();
		mysubjecttab.click();
	}
	
	public void logout()
	{
		profiletab.click();
		signoutbtn.click();
	}
}
