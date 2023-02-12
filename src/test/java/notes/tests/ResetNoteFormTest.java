package notes.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.NotesPage;
import notes.tasks.ClickTask;
import notes.tasks.FillInNoteForm;
import notes.utils.ValidData;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static notes.pageObjects.NotesPage.*;
import static notes.pageObjects.NotesPage.URL_FIELD;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class ResetNoteFormTest {
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	@Before
	public void before() {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new NotesPage()));
		arina.attemptsTo(
			ClickTask.clickOnCircleAddNoteButton(),
			FillInNoteForm.fillInFormWithConstData()
		);
	}
	
	@Test
	public void should_be_able_to_reset_fields_in_note_form() {
		when(arina).attemptsTo(ClickTask.clickOnResetButton());
		assertTrue(NotesPage.RESET_BUTTON.resolveFor(arina).isEnabled());
		
		then(arina).should(seeThat(the(TITLE_FIELD), hasValue("")));
		then(arina).should(seeThat(the(LOCATION_FIELD), hasValue("")));
		then(arina).should(seeThat(the(START_TIME_FIELD), hasValue("")));
		then(arina).should(seeThat(the(START_DATE_FIELD), hasValue("")));
		then(arina).should(seeThat(the(END_TIME_FIELD), hasValue("")));
		then(arina).should(seeThat(the(END_DATE_FIELD), hasValue("")));
		then(arina).should(seeThat(the(DESCRIPTION_FIELD), hasValue("")));
		then(arina).should(seeThat(the(URL_FIELD), hasValue("")));
	}
}
