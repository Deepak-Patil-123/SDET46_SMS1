package edu.sms.teacher;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGClass2Test {

	@Test(groups="smoke")
	public void test1()
	{
		SoftAssert a=new SoftAssert();
		a.assertEquals(2,1);	
		System.out.println("Test 1----> class 2");
	}
	
	@Test(groups={"regression","major"})
	public void test2()
	{
		SoftAssert a=new SoftAssert();
		a.assertEquals('a','b');	
		System.out.println("Test 2----> class 2");
	}
	
	@Test(groups={"regression","minor"})
	public void test3()
	{
		SoftAssert a=new SoftAssert();
		a.assertEquals("deepak","ramesh");	
		System.out.println("Test 3----> class 2");
	}

}
