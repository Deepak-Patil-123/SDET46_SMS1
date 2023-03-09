package com.sms.genericutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class contains all the reusable methods in order to select and deselect the option's in listbox.
 * based on index of web element,value of web element and visibility text  of an web element.
 * @author Deepak
 *
 */
public class ListBoxUtility {
	
	/*WebElement element;
	public ListBoxUtility(WebElement element)
	{
		this.element=element;
	}*/
	/** This method will be handle dropdown based on index value.
	 * @param element
	 * @param index
	 */
	public void selectDropDownIndexBased(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/** This method will be handle dropdown based on value.
	 * @param element
	 * @param value
	 */
	public void selectDropDownValueBased(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/** This Method will be handle dropdown based on visible text.
	 * @param element
	 * @param value
	 */
	public void selectDropDownVisibilityTextBased(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/** This method will be use to deselect dropdown based on index.
	 * @param element
	 * @param index
	 */
	
	public void deselectDropDownBasedOnIndex(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/** This method will be use to deselect dropdown based on value.
	 * @param element
	 * @param value
	 */
	public void deselectDropDownValueBased(WebElement element, String value)
	{
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	
	/**
	 * This Method will be use to deselect dropdown based on visible text.
	 * @param element
	 * @param text
	 */
	public void deselectDropDownVisibilityTextBased(WebElement element,String text)
	{
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
	
	
}





