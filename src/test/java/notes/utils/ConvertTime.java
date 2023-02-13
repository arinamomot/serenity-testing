package notes.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConvertTime {
	public static String convertToAmPm(String time24) {
		// parse the 24-hour time string into a LocalTime object
		LocalTime localTime = LocalTime.parse(time24, DateTimeFormatter.ofPattern("HH:mm"));
		
		// format the LocalTime object into a string in AM/PM format
		return localTime.format(DateTimeFormatter.ofPattern("h:mm a")).replace(":", "").replace(" ", "");
	}
	
	public static String convertTo24Hours(String time) {
		StringBuilder stringBuffer = new StringBuilder(time);
		stringBuffer.insert(2, ":");
		stringBuffer.insert(5, " ");
		LocalTime localTime = LocalTime.parse(stringBuffer.toString(), DateTimeFormatter.ofPattern("h:mm a"));
		return localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	
	public static String convertTimeTo24HourFormat(String time) {
		try {
			DateFormat inputFormat = new SimpleDateFormat("hhmma");
			DateFormat outputFormat = new SimpleDateFormat("HH:mm");
			Date date = inputFormat.parse(time);
			String result = outputFormat.format(date);
			return result;
		} catch (ParseException e) {
			return null;
		}
	}
}
