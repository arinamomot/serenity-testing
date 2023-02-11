package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.NotesHomePage.ADD_NEW_NOTE_BUTTON_HOME;
import static notes.pageObjects.NotesNotesPage.ADD_NOTE_BUTTON;
import static notes.pageObjects.NotesNotesPage.ADD_NOTE_CIRCLE_BUTTON;

public class ClickButtons {
	
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
}
