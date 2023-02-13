package notes.utils;

public class ConvertDate {
	public static String convertDateToValidFormat(String dateString) {
		String year = dateString.substring(4);
		String month = dateString.substring(2, 4);
		String day = dateString.substring(0, 2);
		return year + "-" + day + "-" + month;
	}
	
}
