package com.sms.objectRepository.elements;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.GetPropertyPath;
import com.sms.genericutility.ListBoxUtility;

/**
 * this class contains web element of admin exam page, which we declared,initialized and we perform some action by using business logic method.
 * @author Deepak
 *
 */
public class AdminExamPage {

	WebDriver driver;
	@FindBy(name="grade")
	private WebElement gradeDropdown;
	
	@FindBy(id="exam")
	private WebElement examDropdown;
	
	@FindBy(id="btnSubmit")
	private WebElement submitbtn;
	
	@FindBy(xpath="//h3[text()='Student Exam Marks']")
	private WebElement actstdexam;
	
	String partialxpath="//td[text()='%s']/../td[3]";
	
	private WebElement convertToElement(String partialxpath, String replaceData)
	{
		String axpath=String.format(partialxpath, replaceData);
		return driver.findElement(By.xpath(axpath));
	}
	
	public AdminExamPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String fetchSubjectData(String subject1)
	{
	   return  convertToElement(partialxpath,subject1).getText();
	}
	
	
	
	public void selectDropdown1(ListBoxUtility dropdown,String gradeoption,String examoption)
	{
		dropdown.selectDropDownVisibilityTextBased(gradeDropdown, gradeoption);
		dropdown.selectDropDownVisibilityTextBased(examDropdown, examoption);
		submitbtn.click();
	}
	
	public String getActualExam()
	{
		return actstdexam.getText();
	}
}
