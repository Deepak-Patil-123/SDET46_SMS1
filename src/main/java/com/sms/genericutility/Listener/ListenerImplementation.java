package com.sms.genericutility.Listener;

import java.io.IOException;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sms.genericutility.Base.BaseClass;
import com.sms.genericutility.Base.BaseClassPractise;

public class ListenerImplementation implements ITestListener, IClassListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {

		System.out.println("on start--->suite");
	}
 
	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("on finish--->suite");
	}

	@Override
	public void onBeforeClass(ITestClass testClass) {
		
		System.out.println("onBeforeClass--->testClass");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		
		System.out.println("onAfterClass--->testClass");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("onTestStart--->test");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("onTestSuccess--->test");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("onTestFailure--->test");
		BaseClassPractise.class.cast(result.getMethod().getInstance()).web.taketheScreenShot(result.getMethod().getRealClass().getSimpleName(),
				BaseClassPractise.class.cast(result.getMethod().getInstance()).dateutil);
		
		try {
			
		}
		catch(Exception e)
		{
			
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("onTestSkipped--->test");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("onTestFailedButWithinSuccessPercentage--->test");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		System.out.println("onTestFailedWithTimeout--->test");
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("onStart--->testcontext");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("onFinish--->testcontext");
	}

	
}
