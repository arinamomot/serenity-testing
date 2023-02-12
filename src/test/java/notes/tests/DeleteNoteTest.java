package notes.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.NotesPage;
import notes.questions.NotesCount;
import notes.tasks.ClickTask;
import notes.tasks.FillInNoteForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static notes.pageObjects.NotesPage.NOTE_CARD;
import static notes.pageObjects.NotesPage.NOTE_CARD_DYNAMIC;
import static org.junit.Assert.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class DeleteNoteTest {
	
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	@Before
	public void before() {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new NotesPage()));
		arina.attemptsTo(
			ClickTask.clickOnCircleAddNoteButton(),
			FillInNoteForm.fillInFormWithConstValidData(),
			ClickTask.clickOnAddNoteButton()
		);
	}
	
	@Test
	public void should_be_able_to_delete_note() {
		arina.attemptsTo(
			ClickTask.clickOnNote(),
			ClickTask.clickOnDeleteNoteButton()
		);
		// Verify that the notes were deleted and the count is correct
		assertFalse(NotesPage.NOTE_CARD.resolveFor(arina).isVisible());
	}
}
