package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains web element of GuardianAllTeacherPage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class GuardianAllTeacherPage {

	@FindBy(xpath="//td[contains(text(),'GEOMETRY')]")
	private WebElement actualtext;
	
	public GuardianAllTeacherPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getActualTextOfTeacher()
	{
	   return actualtext.getText();
	}
}
