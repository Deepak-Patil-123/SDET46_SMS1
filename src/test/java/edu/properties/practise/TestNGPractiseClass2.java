package edu.properties.practise;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGPractiseClass2 {

	@BeforeSuite	
	public void suiteSetup()
	{
		System.out.println("BeforeSuite--->class 2");
	}
	
	@BeforeTest
	public void testSetup()
	{
		System.out.println("BeforeTest--->class 2");
	}
	
	@BeforeClass
	public void classSetup()
	{
		System.out.println("BeforeClass--->class 2");
	}
	
	@BeforeMethod
	public void methodSetup()
	{
		System.out.println("BeforeMethod--->class 2");
	}
	
	@Test
	public void test2()
	{
		Assert.fail();
		System.out.println("test--->class 2");
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		System.out.println("AfterMethod--->class 2");
	}
	
	@AfterClass
	public void classTearDown()
	{
		System.out.println("AfterClass--->class 2");
	}
	
	@AfterTest
	public void testTearDown()
	{
		System.out.println("AfterTest--->class 2");
	}
	
	@AfterSuite
	public void suiteTearDown()
	{
		System.out.println("Aftersuite--->class 2");
	}

}
