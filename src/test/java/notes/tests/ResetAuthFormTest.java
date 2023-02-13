package notes.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.AuthPage;
import notes.pageObjects.NotesPage;
import notes.tasks.ClickTask;
import notes.tasks.FillInAuthFormWithCSVData;
import notes.tasks.FillInNoteForm;
import notes.utils.ConvertDate;
import notes.utils.ReadDataFromCSV;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static notes.pageObjects.AuthPage.*;
import static notes.pageObjects.NotesPage.*;
import static org.junit.Assert.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class ResetAuthFormTest {
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	private static final String AUTH_TEST_DATA_FILE = "src/test/resources/authData.csv";
	
	@Before
	public void before() {
		List<Map<String, String>> testData = ReadDataFromCSV.readTestData(AUTH_TEST_DATA_FILE);
		Map<String, String> firstRow = testData.get(0);
		
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new AuthPage()));
		when(arina).attemptsTo(
			FillInAuthFormWithCSVData.fillInFormWithCSVData(firstRow)
		);
		then(arina).should(seeThat(the(NAME_FIELD), hasValue(firstRow.get("name"))));
		then(arina).should(seeThat(the(SURNAME_FIELD), hasValue(firstRow.get("surname"))));
		then(arina).should(seeThat(the(BIRTH_FIELD), hasValue(ConvertDate.convertDateToValidFormat(firstRow.get("birth")))));
		then(arina).should(seeThat(the(CITY_FIELD), hasValue(firstRow.get("city"))));
		then(arina).should(seeThat(the(UNIVERSITY_FIELD), hasValue(firstRow.get("university"))));
		then(arina).should(seeThat(the(EMAIL_FIELD), hasValue(firstRow.get("email"))));
		then(arina).should(seeThat(the(PASSWORD_FIELD), hasValue(firstRow.get("password"))));
	}
	
	@Test
	public void should_be_able_to_reset_fields_in_note_form() {
		when(arina).attemptsTo(ClickTask.clickOnResetAuthButton());
		assertTrue(RESET_AUTH_BUTTON.resolveFor(arina).isEnabled());
		
		then(arina).should(seeThat(the(NAME_FIELD), hasValue("")));
		then(arina).should(seeThat(the(SURNAME_FIELD), hasValue("")));
		then(arina).should(seeThat(the(BIRTH_FIELD), hasValue("")));
		then(arina).should(seeThat(the(CITY_FIELD), hasValue("")));
		then(arina).should(seeThat(the(UNIVERSITY_FIELD), hasValue("")));
		then(arina).should(seeThat(the(EMAIL_FIELD), hasValue("")));
		then(arina).should(seeThat(the(PASSWORD_FIELD), hasValue("")));
	}
}
