package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.NotesPage.*;

public class FillInNoteFormWithCSVData {
	
	@Step
	public static Task fillInFormWithCSVData(Map<String, String> testData) {
		return Task.where(
			"Fill in new note form with data from CSV file",
			WaitUntil.the(NEW_NOTE_FORM, isVisible())
				.then(enterTitle(testData.get("title")))
				.then(enterLocation(testData.get("location")))
				.then(enterStartTime(testData.get("startTime")))
				.then(enterStartDate(testData.get("startDate")))
				.then(enterEndTime(testData.get("endTime")))
				.then(enterEndDate(testData.get("endDate")))
				.then(enterDescription(testData.get("description")))
				.then(enterURL(testData.get("url")))
		);
	}
}