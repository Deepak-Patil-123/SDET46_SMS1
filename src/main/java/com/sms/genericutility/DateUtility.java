package com.sms.genericutility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * This class contains the generic method's for getting the current date or specified date as per requirement.
 * @author Deepak
 *
 */
public class DateUtility {

	
	public  String reqDate(int daycount)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,daycount);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String modifiedDate=sdf.format(cal.getTime());
		return modifiedDate;
		
	}
	
	public String currentDate()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String curdate = sdf.format(new Date());
		return curdate;
	}
	
	public void requiredDate()
	{
		String date="11-Mar-2020";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		Calendar cal=Calendar.getInstance();
		
		try {
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DAY_OF_MONTH, 3);
		String reqdate = sdf.format(cal.getTime());
		System.out.println(reqdate);
		}
		catch(ParseException e)
		{
			
		}
	}
	
	public void getMonthNumber(String reqmonth)
	{
		int currentmonthnum = DateTimeFormatter.ofPattern("MMM").
				withLocale(Locale.ENGLISH).parse(reqmonth).get(ChronoField.MONTH_OF_YEAR);
		
	}
}
