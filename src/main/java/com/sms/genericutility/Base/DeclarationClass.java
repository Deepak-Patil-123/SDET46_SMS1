package com.sms.genericutility.Base;

import org.openqa.selenium.WebDriver;

import com.sms.genericutility.DateUtility;
import com.sms.genericutility.EncryptedDecryptedUtility;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.ListBoxUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.ReportUtility;
import com.sms.genericutility.VerificationUtility;
import com.sms.genericutility.WaitUtility;
import com.sms.genericutility.WebDriverUtility;

/**
 * This class is basically used to declaration of all the utility.
 * @author Deepak
 *
 */
public class DeclarationClass {

	public ReportUtility report;
	protected WebDriver driver;
	public DateUtility dateutil;
	protected EncryptedDecryptedUtility edutility;
	protected VerificationUtility verify;
	protected PropertyUtility property;
	protected ExcelUtility excel;
	public WebDriverUtility web;
	protected WaitUtility wait;
	protected ListBoxUtility dropdown;
	protected String browser;
	protected String url;
	public JavaUtility javautil;
	
}
