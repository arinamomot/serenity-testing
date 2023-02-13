package notes.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.NotesPage;
import notes.questions.NotesCount;
import notes.tasks.ClickTask;
import notes.tasks.FillInNoteForm;
import notes.utils.ValidDataNote;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static notes.pageObjects.NotesPage.*;
import static org.junit.Assert.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewNoteWithConstDataTest {
	
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	@Before
	public void before() {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new NotesPage()));
	}
	
	@Test
	public void should_be_able_to_fill_in_note_form_with_const_valid_data() {
		when(arina).attemptsTo(ClickTask.clickOnCircleAddNoteButton());
		assertTrue(NotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
		when(arina).attemptsTo(FillInNoteForm.fillInFormWithConstValidData());
		then(arina).should(seeThat(the(TITLE_FIELD), hasValue(ValidDataNote.getTitle())));
		then(arina).should(seeThat(the(LOCATION_FIELD), hasValue(ValidDataNote.getLocation())));
		then(arina).should(seeThat(the(START_TIME_FIELD), hasValue(ValidDataNote.getStartTimeConverted())));
		then(arina).should(seeThat(the(START_DATE_FIELD), hasValue(ValidDataNote.getDateConverted())));
		then(arina).should(seeThat(the(END_TIME_FIELD), hasValue(ValidDataNote.getEndTimeConverted())));
		then(arina).should(seeThat(the(END_DATE_FIELD), hasValue(ValidDataNote.getDateConverted())));
		then(arina).should(seeThat(the(DESCRIPTION_FIELD), hasValue(ValidDataNote.getDescription())));
		then(arina).should(seeThat(the(URL_FIELD), hasValue(ValidDataNote.getUrl())));
	}
	
	@Test
	public void should_be_able_to_add_new_note_with_const_data() {
		when(arina).attemptsTo(ClickTask.clickOnCircleAddNoteButton());
		assertTrue(NotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
		when(arina).attemptsTo(FillInNoteForm.fillInFormWithConstValidData());
		then(arina).wasAbleTo(ClickTask.clickOnAddNoteButton());
		assertTrue(NotesPage.ADD_NOTE_BUTTON.resolveFor(arina).isEnabled());
		
		// Verify that the notes were added and the count is correct
		assertTrue(NotesPage.NOTE_CARD.resolveFor(arina).isVisible());
		Integer count = arina.asksFor(NotesCount.locatedBy(NOTE_CARD_DYNAMIC));
		assertEquals((int) count, 1);
	}
	
	@Test
	public void should_not_be_able_to_add_new_note_with_const_data() {
		when(arina).attemptsTo(ClickTask.clickOnCircleAddNoteButton());
		assertTrue(NotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
		when(arina).attemptsTo(FillInNoteForm.fillInFormWithConstInvalidData());
		when(arina).attemptsTo(ClickTask.clickOnAddNoteButton());
		assertTrue(NotesPage.LOCATION_ERROR.resolveFor(arina).isVisible());
	}
}
