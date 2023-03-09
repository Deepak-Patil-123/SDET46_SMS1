package edu.properties.practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractiseClass {

	
	@BeforeSuite	
	public void suiteSetup()
	{
		System.out.println("BeforeSuite--->class 1");
	}
	
	@BeforeTest
	public void testSetup()
	{
		System.out.println("BeforeTest--->class 1");
	}
	
	@BeforeClass
	public void classSetup()
	{
		System.out.println("BeforeClass--->class 1");
	}
	
	@BeforeMethod
	public void methodSetup()
	{
		System.out.println("BeforeMethod--->class 1");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test--->class 1");
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		System.out.println("AfterMethod--->class 1");
	}
	
	@AfterClass
	public void classTearDown()
	{
		System.out.println("AfterClass--->class 1");
	}
	
	@AfterTest
	public void testTearDown()
	{
		System.out.println("AfterTest--->class 1");
	}
	
	@AfterSuite
	public void suiteTearDown()
	{
		System.out.println("Aftersuite--->class 1");
	}
}





