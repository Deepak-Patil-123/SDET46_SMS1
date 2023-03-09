package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains web element of GTeacherPage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class GTeacherPage {

	WebDriver driver;
	
	@FindBy(xpath="//td[text()='mr.kumar']/../td[3]/a[1]")
	private WebElement viewprofilebtn;
	
	@FindBy(id="full_name")
	private WebElement expTeachertxt;
	
	public GTeacherPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnViewProfile()
	{
		viewprofilebtn.click();
	}
	
	public String getExpectedTeacher()
	{
		return expTeachertxt.getText();
	}

	
}
