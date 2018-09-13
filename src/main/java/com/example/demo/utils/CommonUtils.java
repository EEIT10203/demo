package com.example.demo.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {
	
	public static String DEFAULT_DATE_FORAMT = "yyyy-MM-dd";
	public static String DEFAULT_DATETIME_FORAMT = "yyyy-MM-dd HH:mm:ss";
	
	public static Timestamp stringToTimestamp(String date) {
		return stringToTimestamp(date, DEFAULT_DATE_FORAMT);
	}
	
	public static Timestamp stringToTimestamp(String date, String fmt) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(fmt);
		Date parsedDate;
		try {
			parsedDate = dateFormat.parse(date);
			return new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static String timestampToString(Timestamp date) {
		return timestampToString(date, DEFAULT_DATE_FORAMT);
	}

	public static String timestampToString(Timestamp date, String fmt) {
		
		if(date != null) {
			SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORAMT);
			return df.format(date);
		} else {
			return "";
		}
	}
	
	public static Timestamp getNow() {
	     //DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORAMT);
	     //get current date time with Date()
	     //Date date = new Date();
	     //System.out.println(dateFormat.format(date));
	  
	     //get current date time with Calendar()
	     Calendar cal = Calendar.getInstance();
	     
	     return new Timestamp(cal.getTimeInMillis());
	}

}
