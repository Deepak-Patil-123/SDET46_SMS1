package com.sms.genericutility;

/**
 * This class contains some generic methods, which is used for the validation purpose but not in use.
 * @author Deepak
 *
 */
public class VerificationUtility {

	
	public void exactVerify(String actelement1,String expelement1, String actelement2,String expelement2)
	{
		if(actelement1.equals(expelement1) && actelement2.equals(expelement2))
		{
			System.out.println("Test case is passed!");
			
		}
		else
		{
			System.out.println("test Case is Failed!");
		}
	}
	
	public void partialVerify(String actelement1,String expelement1, String actelement2,String expelement2)
	{
		if(actelement1.equalsIgnoreCase(expelement1) && actelement2.equalsIgnoreCase(expelement2))
		{
			System.out.println("Test case is passed!");
		}
		else
		{
			System.out.println("test Case is Failed!");
		}
	}
	
	public void singleVerify(String actelement,String expElement)
	{
		if(actelement.contains(expElement))
		{
			System.out.println("Test case is passed!");
			
		}
		else
		{
			System.out.println("test Case is Failed!");
		}
	}
	
	public void partialVrify(String actelement1,String expelement1, String actelement2,String expelement2,String actelement3,String expelement3)
	{
		if(actelement1.contains(expelement1) && actelement2.contains(expelement2) && actelement3.contains(expelement3))
		{
			System.out.println("Test case is passed!");
		}
		else
		{
			System.out.println("test Case is Failed!");
		}
	}
	
	/**
	 * This method will be use to verification of login page.
	 * @param expLogtitle
	 * @param actlLogtitle
	 */
	public void loginPageVerify(String expLogtitle,String actlLogtitle)
	{
		if(expLogtitle.equals(actlLogtitle))
		{
			System.out.println("login page is displyed!");
		}
		else
		{
			System.out.println("login page is not displayed!");
		}
	}
	
	/**
	 * This method will be use to verification of Home page.
	 * @param expHometitle
	 * @param actlHometitle
	 */
	public void HomePageVerify(String expHometitle,String actlHometitle)
	{
		if(expHometitle.equals(actlHometitle))
		{
			System.out.println("Home page is displyed!");
		}
		else
		{
			System.out.println("Home page is not displayed!");
		}
	}
	
	public void pageVerify(String etitle, String atitle, String page)
	{
		if(etitle.contains(atitle))
		{
			System.out.println(page+" page is displayed.");
		}
		else
		{
			System.out.println(page+" page is not displayed.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
