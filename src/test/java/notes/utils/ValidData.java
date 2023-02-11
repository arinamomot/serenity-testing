package notes.utils;

public class ValidData {
	private static final String title = "New Note";
	private static final String location = "Prague";
	private static final String startTime = "1234PM";
	private static final String startTimeConverted = "12:34";
	private static final String date = "10012023";
	private static final String endTime = "1334PM";
	private static final String endTimeConverted = "13:34";
	private static final String dateConverted = "2023-10-01";
	private static final String description = "New note description";
	private static final String url = "https://notes-vue-deploy-zks.vercel.app/#/notes";
	
	public static String getTitle() {
		return title;
	}
	
	public static String getLocation() {
		return location;
	}
	
	public static String getStartTime() {
		return startTime;
	}
	
	public static String getStartTimeConverted() {
		return startTimeConverted;
	}
	
	public static String getDate() {
		return date;
	}
	
	public static String getDateConverted() {
		return dateConverted;
	}
	
	public static String getEndTime() {
		return endTime;
	}
	
	public static String getEndTimeConverted() {
		return endTimeConverted;
	}
	
	public static String getDescription() {
		return description;
	}
	
	public static String getUrl() {
		return url;
	}
}
