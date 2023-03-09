package edu.sms.teacher;

import org.testng.annotations.Test;

public class MavenPractiseTest {

	@Test
	public void mvnPractise()
	{
		String a = System.getProperty("url");
		String b = System.getProperty("browser");
		
		System.out.println(a);
		System.out.println(b);
	}
}
