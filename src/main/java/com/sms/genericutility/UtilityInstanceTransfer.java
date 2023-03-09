package com.sms.genericutility;

import com.aventstack.extentreports.ExtentTest;

/**
 * This class is used to provide unique instance's for extentTest.
 * @author Deepak
 *
 */
public class UtilityInstanceTransfer {

	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	
	public static void setExtentTest(ExtentTest setExtentTest)
	{
		extentTest.set(setExtentTest);
	}
}
