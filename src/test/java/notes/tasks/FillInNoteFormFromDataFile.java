package notes.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.NotesNotesPage.*;

public class FillInNoteFormFromDataFile implements Task {

//	private final String title;
//	private final String location;
//	private final String startTime;
//	private final String startDate;
//	private final String endTime;
//	private final String endDate;
//	private final String description;
//	private final String url;

//	public FillInNoteFormFromDataFile(String title, String location, String startTime, String startDate, String endTime, String endDate, String description, String url, Map<String, String> testData) {
//		this.title = title;
//		this.location = location;
//		this.startTime = startTime;
//		this.startDate = startDate;
//		this.endTime = endTime;
//		this.endDate = endDate;
//		this.description = description;
//		this.url = url;
//		this.testData = testData;
//	}
	
	public static void enterTitle(String title) {
		Enter.theValue(title).into(TITLE_FIELD);
	}
	
	public void enterLocation(String location) {
		Enter.theValue(location).into(LOCATION_FIELD);
	}
	
	public void enterStartTime(String startTime) {
		Enter.theValue(startTime).into(START_TIME_FIELD);
	}
	
	public void enterStartDate(String startDate) {
		Enter.theValue(startDate).into(START_DATE_FIELD);
	}
	
	public void enterEndTime(String endTime) {
		Enter.theValue(endTime).into(END_TIME_FIELD);
	}
	
	public void enterEndDate(String endDate) {
		Enter.theValue(endDate).into(END_DATE_FIELD);
	}
	
	public void enterDescription(String description) {
		Enter.theValue(description).into(DESCRIPTION_FIELD);
	}
	
	public void enterURL(String url) {
		Enter.theValue(url).into(URL_FIELD);
	}
	
	private final Map<String, String> testData;
	
	public FillInNoteFormFromDataFile(Map<String, String> testData) {
		this.testData = testData;
	}
	
	public static FillInNoteFormFromDataFile withData(Map<String, String> testData) {
		return instrumented(FillInNoteFormFromDataFile.class, testData);
	}
	
	@Override
	public <T extends Actor> void performAs(T t) {
		WaitUntil.the(NEW_NOTE_FORM, isVisible());
		Enter.theValue(testData.get("title")).into(TITLE_FIELD);
		Enter.theValue(testData.get("location")).into(LOCATION_FIELD);

//		enterTitle(testData.get("title"));
//		enterLocation(testData.get("location"));
		enterDescription("description");
//		Task.where(
//			"{2} fill in new note form",
//			WaitUntil.the(NEW_NOTE_FORM, isVisible())
//				.then(enterTitle(testData.get("title")));
//				.then(Enter.theValue("Prague").into(LOCATION_FIELD))
//				.then(Enter.theValue("1234AM").into(START_TIME_FIELD))
//				.then(Enter.theValue("10022023").into(START_DATE_FIELD))
//				.then(Enter.theValue("1334AM").into(END_TIME_FIELD))
//				.then(Enter.theValue("10022023").into(END_DATE_FIELD))
//				.then(Enter.theValue("New note description").into(DESCRIPTION_FIELD))
//				.then(Enter.theValue("https://notes-vue-deploy-zks.vercel.app/#/notes").into(URL_FIELD))
//		);
	}

//	@Step
//	public static Task fillInForm(){
//		return Task.where(
//			"{2} fill in new note form",
//			WaitUntil.the(NEW_NOTE_FORM, isVisible())
//				.then(enterTitle(testData.get("title")))
//				.then(Enter.theValue("Prague").into(LOCATION_FIELD))
//				.then(Enter.theValue("1234AM").into(START_TIME_FIELD))
//				.then(Enter.theValue("10022023").into(START_DATE_FIELD))
//				.then(Enter.theValue("1334AM").into(END_TIME_FIELD))
//				.then(Enter.theValue("10022023").into(END_DATE_FIELD))
//				.then(Enter.theValue("New note description").into(DESCRIPTION_FIELD))
//				.then(Enter.theValue("https://notes-vue-deploy-zks.vercel.app/#/notes").into(URL_FIELD))
//		);
	

}
