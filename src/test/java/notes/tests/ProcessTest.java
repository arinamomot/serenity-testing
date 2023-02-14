package notes.tests;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.HomePage;
import notes.pageObjects.NotesPage;
import notes.questions.NotesCount;
import notes.tasks.ClickTask;
import notes.tasks.FillInAuthFormWithCSVData;
import notes.tasks.FillInNoteForm;
import notes.tasks.Navigate;
import notes.utils.ReadDataFromCSV;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static notes.pageObjects.HomePage.AUTH_PAGE_BUTTON;
import static notes.pageObjects.HomePage.NOTES_PAGE_BUTTON;
import static notes.pageObjects.NotesPage.NOTE_CARD_DYNAMIC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class ProcessTest {
	private static final String AUTH_TEST_DATA_FILE = "src/test/resources/authData.csv";
	
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	@Before
	public void before() {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new HomePage()));
	}
	
	@Test
	public void should_be_able_to_add_new_note_with_const_data() {
		// Go to Auth page
		when(arina).attemptsTo(Navigate.navigateTo(AUTH_PAGE_BUTTON));
		String actualUrl = Serenity.getWebdriverManager().getCurrentDriver().getCurrentUrl();
		assertThat(actualUrl, equalTo(AUTH_PAGE_BUTTON.resolveFor(arina).getAttribute("href")));
		
		// Registration
		List<Map<String, String>> testData = ReadDataFromCSV.readTestData(AUTH_TEST_DATA_FILE);
		Map<String, String> firstRow = testData.get(0);
		
		arina.attemptsTo(
			FillInAuthFormWithCSVData.fillInFormWithCSVData(firstRow),
			ClickTask.acceptLicenseTermsButton(),
			ClickTask.clickOnSubmitAuthButton()
		);
		
		// Go to Notes page
		when(arina).attemptsTo(Navigate.navigateTo(NOTES_PAGE_BUTTON));
		actualUrl = Serenity.getWebdriverManager().getCurrentDriver().getCurrentUrl();
		assertThat(actualUrl, equalTo(NOTES_PAGE_BUTTON.resolveFor(arina).getAttribute("href")));
		
		// Create Note
		when(arina).attemptsTo(ClickTask.clickOnCircleAddNoteButton());
		assertTrue(NotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
		when(arina).attemptsTo(FillInNoteForm.fillInFormWithConstValidData());
		then(arina).wasAbleTo(ClickTask.clickOnAddNoteButton());
		assertTrue(NotesPage.ADD_NOTE_BUTTON.resolveFor(arina).isEnabled());
		
		// Verify that the notes were added and the count is correct
		assertTrue(NotesPage.NOTE_CARD.resolveFor(arina).isVisible());
		Integer count = arina.asksFor(NotesCount.locatedBy(NOTE_CARD_DYNAMIC));
		assertEquals((int) count, 1);
		
		// Delete note
		arina.attemptsTo(
			ClickTask.clickOnNote(),
			ClickTask.clickOnDeleteNoteButton()
		);
		// Verify that the notes were deleted and the count is correct
		assertFalse(NotesPage.NOTE_CARD.resolveFor(arina).isVisible());
		
		// Leave web
		arina.attemptsTo(Open.url("https://www.google.com/"));
	}
}
