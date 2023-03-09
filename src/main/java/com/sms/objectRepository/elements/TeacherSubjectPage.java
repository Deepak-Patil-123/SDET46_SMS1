package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains web element of TeacherSubjectPage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class TeacherSubjectPage {

	@FindBy(xpath="//td[text()='SQL']")
	private WebElement asubjecttxt;
	
	public TeacherSubjectPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String actualSubject()
	{
		return asubjecttxt.getText();
	}
}
