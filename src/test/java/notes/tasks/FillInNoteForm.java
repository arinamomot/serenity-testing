package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import notes.utils.InvalidDataNote;
import notes.utils.ValidDataNote;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.NotesPage.*;

public class FillInNoteForm {
	@Step
	public static Task fillInFormWithConstValidData() {
		return Task.where(
			"Fill in new note form with constant valid data",
			WaitUntil.the(NEW_NOTE_FORM, isVisible())
				.then(enterTitle(ValidDataNote.getTitle()))
				.then(enterLocation(ValidDataNote.getLocation()))
				.then(enterStartTime(ValidDataNote.getStartTime()))
				.then(enterStartDate(ValidDataNote.getDate()))
				.then(enterEndTime(ValidDataNote.getEndTime()))
				.then(enterEndDate(ValidDataNote.getDate()))
				.then(enterDescription(ValidDataNote.getDescription()))
				.then(enterURL(ValidDataNote.getUrl()))
		);
	}
	
	@Step
	public static Task fillInFormWithConstInvalidData() {
		return Task.where(
			"Fill in new note form with constant invalid data",
			WaitUntil.the(NEW_NOTE_FORM, isVisible())
				.then(enterTitle(InvalidDataNote.getTitle()))
				.then(enterLocation(InvalidDataNote.getLocation()))
				.then(enterDescription(InvalidDataNote.getDescription()))
				.then(enterURL(InvalidDataNote.getUrl()))
		);
	}
	
}
