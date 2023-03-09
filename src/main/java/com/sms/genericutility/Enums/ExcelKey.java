package com.sms.genericutility.Enums;
/**
 * This class is used to declare any varieble as public,static and final.
 * @author Deepak
 *
 */
public enum ExcelKey {
	
	GUARDIAN("guardian");
	
	String key;
	

	private  ExcelKey(String key)
	{
		this.key=key;
	}
	
	public String getSheetName()
	{
		return key;
	}
}
