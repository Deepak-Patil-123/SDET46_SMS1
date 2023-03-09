package com.sms.genericutility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sms.genericutility.Enums.PropertyKey;

/**
 * This class contains generic method in order to handle the generated reports.
 * @author Deepak
 *
 */
public class ReportUtility {


		private ExtentReports report;
		private String path;
		
		public ReportUtility()
		{
			init();
		}
		
		
		public void init()
		{
			PropertyUtility propertyUtil=null;
			propertyUtil=new PropertyUtility(GetPropertyPath.EXTENTREPORT_PROPERTYPATH);
			String overrideOrNot=propertyUtil.getPropertyData(PropertyKey.OVERRIDEREPORT);
			String randomName="";
			if(overrideOrNot.equals("no"))
			{
				randomName="_"+new DateUtility().currentDate();
			}
			ExtentSparkReporter spark=new ExtentSparkReporter(GetPropertyPath.EXTENTREPORTFOLDERPATH+"extentReport"+randomName+".html");
			spark.config().setDocumentTitle(propertyUtil.getPropertyData(PropertyKey.EXTENTREPORT_TITLE));
			spark.config().setReportName(propertyUtil.getPropertyData(PropertyKey.EXTENTREPORT_NAME));
			spark.config().setTheme(Theme.DARK);
			
			 path="GetPropertyPath.EXTENTREPORTFOLDERPATH+\"extentReport\"+randomName+\".html\"";
			
			report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("Browser", propertyUtil.getPropertyData(PropertyKey.BROWSER));
			report.setSystemInfo("OS", System.getProperty("os name"));
		}
		
		public void createTest(String testName)
		{
			ExtentTest test=report.createTest(testName);
			UtilityInstanceTransfer.setExtentTest(test);
		}
		
		public void addAuthor(ExtentTest test,String...author)
		{
			test.assignAuthor(author);
		}
		public void addCatagory(ExtentTest test,String...catagory)
		{
			test.assignCategory(catagory);
		}
		
		public void pass(ExtentTest test,String message)
		{
			test.pass(message);
			System.out.println(message);
		}
		public void info(ExtentTest test,String message)
		{
			test.info(message);
			System.out.println(message);
		}
		public void fail(ExtentTest test,String message)
		{
			test.fail(message);
			System.out.println(message);
		}
		public void fail(ExtentTest test,Throwable errmessage)
		{
			test.fail(errmessage);
			System.out.println(errmessage);
		}
		public void skip(ExtentTest test,String message)
		{
			test.skip(message);
			System.out.println(message);
		}
		public void skip(ExtentTest test,Throwable errmessage)
		{
			test.skip(errmessage);
			System.out.println(errmessage);
		}
		public void warn(ExtentTest test,String message)
		{
			test.warning(message);
			System.out.println(message);
		}
		public void saveReport()
		{
			report.flush();
			try {
				Desktop.getDesktop().browse(new File(path).toURI());
			} catch (IOException e) {
				e.printStackTrace();
			};
		}
		public void attachScreenshot(ExtentTest test,String Screenshotpath,String title,String strategy)
		{
			if(strategy.equals("base64"))
			{
				test.addScreenCaptureFromBase64String(Screenshotpath, title);
			}
			else
			{
				test.addScreenCaptureFromPath(Screenshotpath, title);
			}
			
		}
		


}
