package com.sms.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable methods which is used to perform various operations like generating the
 * random number, getting the date  and time format as per ist.
 * @author Deepak Patil
 *
 */
public class JavaUtility {

	/**
	 * This method is use to generate random number.
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int ranNum = r.nextInt(100);
		return ranNum;
	}
	
	/**
	 * This method is used to get System date and time format in IST format.
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		Date date=new Date();
		String systemdate = date.toString();
		//System.out.println(systemdate);
		return systemdate; 
	}
	
	
}
