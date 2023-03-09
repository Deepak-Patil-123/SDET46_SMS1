package com.sms.genericutility.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.sms.genericutility.EncryptedDecryptedUtility;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.GetPropertyPath;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.ListBoxUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.ReportUtility;
import com.sms.genericutility.VerificationUtility;
import com.sms.genericutility.WaitUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.genericutility.Enums.PropertyKey;
import com.sms.genericutility.Listener.ListenerReports;
import com.sms.objectRepository.elements.LoginPage;

/**
 * This class contains various annotation method's like @BeforeClass And @AfterClass which is used for various purposes
 * in the test execution process.base class is the super most class in the framework which extended in each and every test scripts. 
 * @author Deepak
 *
 */
public class BaseClass extends DeclarationClass{

	
		/**
		 * This method is used to initialization of all the generic utility classes.
		 * as well as in this method is used to launch the browser, maximize the browser, enter the url,
		 * giving timeout duration.
		 * @param browser
		 */
		@Parameters(value="browser")
		@BeforeClass(alwaysRun=true)
		public void initializationSetup(@Optional String browser)
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
			 javautil=new JavaUtility();
			 
			 if(browser==null || browser.isEmpty() || browser.equals(""))
			 {
				 browser = property.getPropertyData(PropertyKey.BROWSER);
			 }
		
			 this.browser=browser;
		//	 browser = property.getPropertyData(PropertyKey.BROWSER);
			 url = property.getPropertyData(PropertyKey.URL);
			
			driver=web.openBrowser(browser,"");
			web.browserMaximize();
			wait.implicitWait(driver,Long.parseLong(property.getPropertyData(PropertyKey.TIMEOUTS)));		
			web.getURL(url);  

		}
		
		/**
		 * This annotation method is used to close the browser and close the excel.
		 */
		@AfterClass(alwaysRun=true)
		public void initializationTearDown()
		{
			web.closeBrowser();
			System.out.println("driver is closed!");
			excel.close();
			System.out.println("excel is closed!");
		}

}
