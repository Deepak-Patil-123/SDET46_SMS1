package com.sms.objectRepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains web element of HomePage, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Ingenious Developer1']")
	private WebElement adminProfile;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signoutbtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void adminLogout()
	{
		adminProfile.click();
		signoutbtn.click();
	}
	
	
}
