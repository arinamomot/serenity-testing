package notes.tests;

import au.com.bytecode.opencsv.CSVReader;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.NotesPage;
import notes.questions.NotesCount;
import notes.tasks.ClickTask;
import notes.tasks.FillInNoteFormWithCSVData;
import notes.utils.ConvertTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static notes.pageObjects.NotesPage.*;
import static notes.pageObjects.NotesPage.URL_FIELD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewNoteWithCSVdataTest {
	Actor arina = Actor.named("Arina");
	@Managed
	private WebDriver driver;
	
	private static final String TEST_DATA_FILE = "src/test/resources/noteData.csv";
	
	@Before
	public void before() {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new NotesPage()));
	}
	
	private List<Map<String, String>> readTestData() {
		List<Map<String, String>> testData = new ArrayList<>();
		
		try (CSVReader csvReader = new CSVReader(new FileReader(AddNewNoteWithCSVdataTest.TEST_DATA_FILE))) {
			String[] headers = csvReader.readNext();
			
			String[] row;
			while ((row = csvReader.readNext()) != null) {
				Map<String, String> testDataItem = new HashMap<>();
				for (int i = 0; i < headers.length; i++) {
					testDataItem.put(headers[i], row[i]);
				}
				testData.add(testDataItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return testData;
	}
	
	@Test
	public void should_be_able_to_fill_in_new_note_with_data_from_CSV_file() {
		List<Map<String, String>> testData = readTestData();
		Map<String, String> firstRow = testData.get(0);
		
		when(arina).attemptsTo(ClickTask.clickOnCircleAddNoteButton());
		assertTrue(NotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
		
		when(arina).attemptsTo(FillInNoteFormWithCSVData.fillInFormWithCSVData(firstRow));
		
		then(arina).should(seeThat(the(TITLE_FIELD), hasValue(firstRow.get("title"))));
		then(arina).should(seeThat(the(LOCATION_FIELD), hasValue(firstRow.get("location"))));
		then(arina).should(seeThat(the(START_TIME_FIELD), hasValue(ConvertTime.convertTimeTo24HourFormat(firstRow.get("startTime")))));
		then(arina).should(seeThat(the(START_DATE_FIELD), hasValue(firstRow.get("startDate"))));
		then(arina).should(seeThat(the(END_TIME_FIELD), hasValue(ConvertTime.convertTimeTo24HourFormat(firstRow.get("endTime")))));
		then(arina).should(seeThat(the(END_DATE_FIELD), hasValue(firstRow.get("endDate"))));
		then(arina).should(seeThat(the(DESCRIPTION_FIELD), hasValue(firstRow.get("description"))));
		then(arina).should(seeThat(the(URL_FIELD), hasValue(firstRow.get("url"))));

//		then(arina).should(seeThat(TheInputFieldValue.of(TITLE_FIELD), equalTo(firstRow.get("title"))));
//		then(arina).should(seeThat(TheInputFieldValue.of(LOCATION_FIELD), equalTo(firstRow.get("location"))));
//		then(arina).should(seeThat(TheInputFieldValue.of(START_TIME_FIELD), equalTo(ConvertTime.convertTimeTo24HourFormat(firstRow.get("startTime")))));
//		System.out.println(ConvertTime.convertTimeTo24HourFormat(firstRow.get("startTime")));
//		then(arina).should(seeThat(TheInputFieldValue.of(START_DATE_FIELD), equalTo(firstRow.get("startDate"))));
//		then(arina).should(seeThat(TheInputFieldValue.of(END_TIME_FIELD), equalTo(firstRow.get("endTime"))));
//		then(arina).should(seeThat(TheInputFieldValue.of(END_DATE_FIELD), equalTo(firstRow.get("endDate"))));
//		then(arina).should(seeThat(TheInputFieldValue.of(DESCRIPTION_FIELD), equalTo(firstRow.get("description"))));
//		then(arina).should(seeThat(TheInputFieldValue.of(URL_FIELD), equalTo(firstRow.get("url"))));
	}
	
	@Test
	public void should_be_able_to_add_new_note_with_data_from_CSV_file() {
		List<Map<String, String>> testData = readTestData();
		
		for (Map<String, String> testDataItem : testData) {
			arina.attemptsTo(
				ClickTask.clickOnCircleAddNoteButton(),
				FillInNoteFormWithCSVData.fillInFormWithCSVData(testDataItem),
				ClickTask.clickOnAddNoteButton()
			);
		}
		
		// Verify that the notes were added and the count is correct
		Integer count = arina.asksFor(NotesCount.locatedBy(NOTE_CARD_DYNAMIC));
		assertEquals((int) count, testData.size());
	}
}