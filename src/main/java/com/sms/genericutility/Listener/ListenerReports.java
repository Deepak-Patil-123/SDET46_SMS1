package com.sms.genericutility.Listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Report;
import com.sms.genericutility.DateUtility;
import com.sms.genericutility.GetPropertyPath;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.ReportUtility;
import com.sms.genericutility.UtilityInstanceTransfer;
import com.sms.genericutility.Base.BaseClassPractise;
import com.sms.genericutility.Enums.PropertyKey;
import com.sms.genericutility.annotations.Reports;

/**
 * This class contains various method's in order to generate extent report.
 * @author Deepak
 *
 */
public class ListenerReports implements ITestListener,ISuiteListener {

		private static final DateUtility dateUtil = null;
		private ReportUtility report;
		public static ReportUtility sreport;
		
		/**
		 * This method will execute before execution of @BeforeSuit method. 
		 */
		@Override
		public void onStart(ISuite suite) {
			System.out.println("on start-->test");
			report=new ReportUtility();
			sreport=report;
			
		}

		/**
		 *  This method is used to save the extent report.
		 */
		@Override
		public void onFinish(ISuite suite) {
			System.out.println("on finish--->suite");
			report.saveReport();
			
		}
		
		/**
		 * This method will execute @BeforeTest.
		 */
		@Override
		public void onStart(ITestContext context) {
			System.out.println("on start-->test");
			
		}
		
		/**
		 * This method will be used to create test result in report.
		 */
		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("ontestStart");
			report.createTest(result.getMethod().getMethodName());
			Reports reportAnnotation=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Reports.class);
			System.out.println(reportAnnotation.author());
			System.out.println(reportAnnotation.category());
			report.addAuthor(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.author());
			report.addCatagory(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.category());
			
			
		}
		
		/**
		 *  This method will  be used to create execution report.
		 */
		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("OnTest Success");
			report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is pass");
			
		}
		
		/**
		 * This method will execute only when test case get failed and it will take the screen shot. 
		 * and save in folder as well as it will attached in report also.
		 */
		@Override
		public void onTestFailure(ITestResult result) {
			System.out.println("OnTest Failure");
			report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is failed");
			report.fail(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
			
			String screenshotPath=null;
			
			screenshotPath=BaseClassPractise.class.cast(result.getMethod().getInstance()).web.taketheScreenShot(screenshotPath, dateUtil);
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(),screenshotPath, result.getMethod().getMethodName(), "base64");
		}

		/**
		 * This method will execute only if any test case get skipped.
		 */
		@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println("OnTestSkipped");
			report.skip(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is skipped");
			report.skip(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
			
		}

		/**
		 * This method is used to map the success percentage of test case execution.
		 */
		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("onTestFailedButWithinSuccessPercentage");
		}

		/**
		 * This method is used to print the status only when any test case gets failed because of time out.
		 */
		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			System.out.println("onTestFailedWithTimeout");
			
		}

		
		/**
		 * this method will execute after the completion of test case execution.
		 */
		@Override
		public void onFinish(ITestContext context) {
			System.out.println("on finish");
			
		}

}
