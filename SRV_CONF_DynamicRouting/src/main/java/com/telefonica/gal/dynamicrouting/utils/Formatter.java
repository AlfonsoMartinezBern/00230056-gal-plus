package com.telefonica.gal.dynamicrouting.utils;



import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Formatter {

	private static String DATE_TIME_FORMATTED = "yyyy-MM-dd HH:mm:ss";
	
	public static String getDateTime(DateTime dateTime) {
		DateTimeFormatter timeFormatter = DateTimeFormat.forPattern(DATE_TIME_FORMATTED);
		return timeFormatter.print(dateTime);
	}
}
