package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains web element of LoginPage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class LoginPage {

	WebDriver driver;
	
	@FindBy(id="email")
	private WebElement UNtextfield;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement PWDtextfield;
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	private WebElement lgnButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void loginAdmin(String admin_un,String admin_pwd)
	{
		UNtextfield.sendKeys(admin_un);
		PWDtextfield.sendKeys(admin_pwd);
		lgnButton.click();
	}
	
	public void loginGuardian(String guardian_un,String guardian_pwd)
	{
		UNtextfield.sendKeys(guardian_un);
		PWDtextfield.sendKeys(guardian_pwd);
		lgnButton.click();
	}
	
	public void loginTeacher(String teacher_un,String teacher_pwd)
	{
		UNtextfield.sendKeys(teacher_un);
		PWDtextfield.sendKeys(teacher_pwd);
		lgnButton.click();
	}
	
}
