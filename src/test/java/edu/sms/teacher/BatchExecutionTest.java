package edu.sms.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sms.genericutility.Base.BaseClassPractise;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.sms.genericutility.Listener.ListenerImplementation.class)
public class BatchExecutionTest extends BaseClassPractise {

	@Test(groups="major")
	public void test1()
	{
		driver.get("https://www.google.com/");
	}
	
	@Test(groups={"major","sanity"})
	public void test2()
	{
		driver.get("https://www.flipkart.com/");
		System.out.println("flipkart offers!");
	//	Assert.fail();
		System.out.println("flipkart offers not available!");
	}
	
	@Test(groups="minor")
	public void test3()
	{
		driver.get("https://www.youtube.com/");
	}
}
