package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import notes.utils.ValidData;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.NotesPage.*;

public class FillInNoteForm {
	@Step
	public static Task fillInFormWithConstData() {
		return Task.where(
			"Fill in new note form with constant valid data",
			WaitUntil.the(NEW_NOTE_FORM, isVisible())
				.then(enterTitle(ValidData.getTitle()))
				.then(enterLocation(ValidData.getLocation()))
				.then(enterStartTime(ValidData.getStartTime()))
				.then(enterStartDate(ValidData.getDate()))
				.then(enterEndTime(ValidData.getEndTime()))
				.then(enterEndDate(ValidData.getDate()))
				.then(enterDescription(ValidData.getDescription()))
				.then(enterURL(ValidData.getUrl()))
		);
	}
	
}
