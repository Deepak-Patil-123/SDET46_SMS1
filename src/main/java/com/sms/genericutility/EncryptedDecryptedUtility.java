package com.sms.genericutility;

import java.util.Base64;

/**
 * This class contains generic method for encryption and decryption of data.
 * @author Deepak
 *
 */
public class EncryptedDecryptedUtility {

	
	public String encoding(String s)
	{
		byte[] byteA = s.getBytes();
		byte[] byteB = Base64.getEncoder().encode(byteA);
		
		String k=new String(byteB);
		
		return k;
	}
	
	public String  decoding(String s)
	{
		
		byte[] byteC = s.getBytes();
		byte[] byteD = Base64.getDecoder().decode(byteC);
	
		String q=new String(byteD);
		return q;
	}
}
