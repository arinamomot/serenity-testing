package notes.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.AuthPage;
import notes.pageObjects.HomePage;
import notes.pageObjects.NotesPage;
import notes.questions.NotesCount;
import notes.tasks.ClickTask;
import notes.tasks.FillInAuthFormWithCSVData;
import notes.tasks.FillInNoteForm;
import notes.tasks.FillInNoteFormWithCSVData;
import notes.utils.ConvertDate;
import notes.utils.ConvertTime;
import notes.utils.ReadDataFromCSV;
import org.junit.After;
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
import static org.junit.Assert.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class RegistrationTest {
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	private static final String AUTH_TEST_DATA_FILE = "src/test/resources/authData.csv";
	private static final String AUTH_TEST_INVALID_DATA_FILE = "src/test/resources/authInvalidData.csv";
	private static final String submit = "Submitted";
	private static final String fieldError = "Please check and fill the form correctly";
	private static final String notAccepted = "You need to accept the license and terms first";
	
	@Before
	public void before() {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new AuthPage()));
	}
	
	@Test
	public void should_be_able_to_fill_in_auth_form_with_data_from_CSV_file() {
		List<Map<String, String>> testData = ReadDataFromCSV.readTestData(AUTH_TEST_DATA_FILE);
		Map<String, String> firstRow = testData.get(0);
		
		when(arina).attemptsTo(
			FillInAuthFormWithCSVData.fillInFormWithCSVData(firstRow),
			ClickTask.acceptLicenseTermsButton()
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
	public void should_be_able_to_sign_up_with_data_from_CSV_file() {
		List<Map<String, String>> testData = ReadDataFromCSV.readTestData(AUTH_TEST_DATA_FILE);
		
		arina.attemptsTo(ClickTask.acceptLicenseTermsButton());
		assertTrue(AuthPage.LICENSE_TERMS_CHECKBOX.resolveFor(arina).isEnabled());
		
		for (Map<String, String> testDataItem : testData) {
			arina.attemptsTo(
				FillInAuthFormWithCSVData.fillInFormWithCSVData(testDataItem),
				ClickTask.clickOnSubmitAuthButton()
			);
			assertTrue(AuthPage.SUBMIT_AUTH_BUTTON.resolveFor(arina).isEnabled());
			assertTrue(AuthPage.NOTIFICATION.resolveFor(arina).isVisible());
			
			assertEquals(Text.of(AuthPage.NOTIFICATION).answeredBy(arina), submit);
			
			arina.attemptsTo(ClickTask.clickOnResetAuthButton());
			assertTrue(AuthPage.RESET_AUTH_BUTTON.resolveFor(arina).isEnabled());
		}
	}
	
	
	@Test
	public void should_not_be_able_to_sign_up_with_data_from_CSV_file() {
		List<Map<String, String>> testData = ReadDataFromCSV.readTestData(AUTH_TEST_INVALID_DATA_FILE);
		Map<String, String> firstRow = testData.get(0);
		
		when(arina).attemptsTo(
			FillInAuthFormWithCSVData.fillInFormWithCSVData(firstRow),
			ClickTask.acceptLicenseTermsButton(),
			ClickTask.clickOnSubmitAuthButton()
		);
		
		assertTrue(AuthPage.NOTIFICATION.resolveFor(arina).isVisible());
		assertEquals(Text.of(AuthPage.NOTIFICATION).answeredBy(arina), fieldError);
	}
	
	@Test
	public void should_not_be_able_to_sign_up_license_not_accepted() {
		List<Map<String, String>> testData = ReadDataFromCSV.readTestData(AUTH_TEST_DATA_FILE);
		Map<String, String> firstRow = testData.get(0);
		
		when(arina).attemptsTo(
			FillInAuthFormWithCSVData.fillInFormWithCSVData(firstRow),
			ClickTask.clickOnSubmitAuthButton()
		);
		
		assertTrue(AuthPage.NOTIFICATION.resolveFor(arina).isVisible());
		assertEquals(Text.of(AuthPage.NOTIFICATION).answeredBy(arina), notAccepted);
	}
}
