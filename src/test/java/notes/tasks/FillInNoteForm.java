package notes.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import notes.utils.ValidData;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.NotesAuthPage.NAME_FIELD;
import static notes.pageObjects.NotesHomePage.ADD_NEW_NOTE_BUTTON_HOME;
import static notes.pageObjects.NotesHomePage.SETTINGS_BUTTON;
import static notes.pageObjects.NotesNotesPage.*;

public class FillInNoteForm {
	@Step
	public static Task fillInFormWithConstData() {
		return Task.where(
			"{2} fill in new note form",
			WaitUntil.the(NEW_NOTE_FORM, isVisible())
				.then(Enter.theValue(ValidData.getTitle()).into(TITLE_FIELD))
				.then(Enter.theValue(ValidData.getLocation()).into(LOCATION_FIELD))
				.then(Enter.theValue(ValidData.getStartTime()).into(START_TIME_FIELD))
				.then(Enter.theValue(ValidData.getDate()).into(START_DATE_FIELD))
				.then(Enter.theValue(ValidData.getEndTime()).into(END_TIME_FIELD))
				.then(Enter.theValue(ValidData.getDate()).into(END_DATE_FIELD))
				.then(Enter.theValue(ValidData.getDescription()).into(DESCRIPTION_FIELD))
				.then(Enter.theValue(ValidData.getUrl()).into(URL_FIELD))
		);
	}
	
}
