package com.bonc.db_op.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	private static Date today;

	public StringToDate(){
		
	}
	
	/*public static void main(String[] args)
	{
		Date cc = new Date();
		cc = strToDate("yyyy-MM-dd HH:mm:ss","2016-02-03 04:30:00.0");
		
		System.out.println(cc.toString());
		
	}*/
	public static Date strToDate(String str1,String str2)
	{
		Date today = null;
		
		DateFormat df = new SimpleDateFormat(str1);//"yyyy-MM-dd HH:mm:ss"
		try {
			 today = df.parse(str2);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return today;
	}

}
