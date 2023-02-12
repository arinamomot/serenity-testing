package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.HomePage.ADD_NEW_NOTE_BUTTON_HOME;
import static notes.pageObjects.NotesPage.*;

public class ClickTask {
	
	@Step
	public static Task clickOnCircleAddNoteButton() {
		return Task.where(
			"Click on add new note circle button",
			WaitUntil.the(ADD_NOTE_CIRCLE_BUTTON, isVisible())
				.then(Click.on(ADD_NOTE_CIRCLE_BUTTON))
		);
	}
	
	@Step
	public static Task clickOnAddNoteButtonHome() {
		return Task.where(
			"Click on add new note button on the home page",
			WaitUntil.the(ADD_NEW_NOTE_BUTTON_HOME, isVisible())
				.then(Click.on(ADD_NEW_NOTE_BUTTON_HOME))
		);
	}
	
	@Step
	public static Task clickOnAddNoteButton() {
		return Task.where(
			"Click on add new note button in the form",
			WaitUntil.the(ADD_NOTE_BUTTON, isVisible())
				.then(Click.on(ADD_NOTE_BUTTON))
		);
	}
	
	@Step
	public static Task clickOnDeleteNoteButton() {
		return Task.where(
			"Click on delete note button in the note card",
			WaitUntil.the(DELETE_BUTTON, isVisible())
				.then(Click.on(DELETE_BUTTON))
		);
	}
	
	@Step
	public static Task clickOnNote() {
		return Task.where(
			"Click on delete note button in the note card",
			WaitUntil.the(NOTE_CARD, isVisible())
				.then(Click.on(NOTE_CARD))
		);
	}
	
	@Step
	public static Task clickOnResetButton() {
		return Task.where(
			"Click on reset fields button in the note form",
			WaitUntil.the(RESET_BUTTON, isVisible())
				.then(Click.on(RESET_BUTTON))
		);
	}
}
