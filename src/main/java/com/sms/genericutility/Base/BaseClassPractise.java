package com.sms.genericutility.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sms.genericutility.DateUtility;
import com.sms.genericutility.EncryptedDecryptedUtility;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.GetPropertyPath;
import com.sms.genericutility.ListBoxUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.ReportUtility;
import com.sms.genericutility.VerificationUtility;
import com.sms.genericutility.WaitUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.genericutility.Enums.PropertyKey;
import com.sms.genericutility.Listener.ListenerReports;


public class BaseClassPractise extends DeclarationClass {


	@Parameters(value="browser")
	@BeforeClass(alwaysRun=true)
	public void openBrowser(@Optional String browser)
	{
		 report=new ReportUtility();
		report=ListenerReports.sreport; 
		edutility=new EncryptedDecryptedUtility();
		 verify=new VerificationUtility();
		 property=new PropertyUtility(GetPropertyPath.PROPERTYPATH);
		 excel=new ExcelUtility(GetPropertyPath.EXCELPATH);
		 web=new WebDriverUtility();
		 wait=new WaitUtility();
		 dropdown=new ListBoxUtility();
		 dateutil=new DateUtility();
		 
		 if(browser==null ||browser.isEmpty() || browser.equals(""))
		 {
			 browser = property.getPropertyData(PropertyKey.BROWSER);
		 }
	
		 this.browser=browser;
	//	 browser = property.getPropertyData(PropertyKey.BROWSER);
		 url = property.getPropertyData(PropertyKey.URL);
		
		driver=web.openBrowser(browser,"");
		web.browserMaximize();
		wait.implicitWait(driver,Long.parseLong(property.getPropertyData(PropertyKey.TIMEOUTS)));		
	//	web.getURL(url);  

	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		web.closeBrowser();
		System.out.println("driver is closed!");
		excel.close();
		System.out.println("excel is closed!");
	}
	
}
