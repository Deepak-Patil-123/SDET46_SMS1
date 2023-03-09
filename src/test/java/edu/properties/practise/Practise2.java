package edu.properties.practise;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class Practise2 {

	
	public static void main(String[] args) {

	/*	Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yyyy");
		String date = sdf1.format(cal.getTime());
		System.out.println(date);
		
		
		Date Date = cal.getTime();
		SimpleDateFormat sdf2=new SimpleDateFormat("dd-MMM-yyyy");
		String crntdate = sdf2.format(Date);
		System.out.println(crntdate);     */
		
		
		String pw="12345";    //MTIzNDU=
		byte[] byte1 = pw.getBytes();
		byte[] byte2 = Base64.getEncoder().encode(byte1);
		String epw=new String(byte2);
		System.out.println(epw);
		
	
	}

}
