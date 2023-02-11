package notes.tests;

import au.com.bytecode.opencsv.CSVReader;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.NotesNotesPage;
import notes.questions.TheInputFieldValue;
import notes.tasks.ClickButtons;
import notes.tasks.FillInNoteForm;
import notes.tasks.FillInNoteFormFromDataFile;
import notes.utils.ConvertTime;
import notes.utils.ValidData;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;


import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static notes.pageObjects.NotesNotesPage.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class FillInNotesFormTest {
	
	Actor arina = Actor.named("Arina");
	String firstname = "New Note";
	
	@Managed
	private WebDriver driver;
	
	private static final String TEST_DATA_FILE = "src/test/resources/noteData.csv";
	
	@Before
	public void before() throws IOException {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new NotesNotesPage()));
	}
	
	private List<Map<String, String>> readTestData() {
		List<Map<String, String>> testData = new ArrayList<>();
		
		try (CSVReader csvReader = new CSVReader(new FileReader(FillInNotesFormTest.TEST_DATA_FILE))) {
			String[] headers = csvReader.readNext();
			
			System.out.println(Arrays.toString(headers));
			
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
		
		System.out.println(testData);
		
		return testData;
	}

//	@Test
//	public void shouldBeAbleToAddNewNote() {
//		List<Map<String, String>> testData = readTestData();
//
////		givenThat(arina).wasAbleTo(Open.browserOn().the(new NotesNotesPage()));
//		when(arina).attemptsTo(FillInNoteFormWithConstData.clickOnCircleAddNoteButton());
//		assertTrue(NotesNotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
//		when(arina).attemptsTo(FillInNoteFormWithConstData.fillInForm());
////		for (Map<String, String> testDataItem : testData) {
////			arina.attemptsTo(
////				FillInNoteFormFromDataFile.withData(testDataItem)
////			);
////		}
//		then(arina).wasAbleTo(FillInNoteForm.clickOnAddNoteButton());
//	}
	
	@Test
	public void should_be_able_to_fill_in_note_form_with_const_valid_data() {
		when(arina).attemptsTo(ClickButtons.clickOnCircleAddNoteButton());
		assertTrue(NotesNotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
		when(arina).attemptsTo(FillInNoteForm.fillInFormWithConstData());
		then(arina).should(seeThat(TheInputFieldValue.of(TITLE_FIELD), equalTo(ValidData.getTitle())));
		then(arina).should(seeThat(TheInputFieldValue.of(LOCATION_FIELD), equalTo(ValidData.getLocation())));
		then(arina).should(seeThat((TheInputFieldValue.of(START_TIME_FIELD)), equalTo(ValidData.getStartTimeConverted())));
		then(arina).should(seeThat(TheInputFieldValue.of(START_DATE_FIELD), equalTo(ValidData.getDateConverted())));
		then(arina).should(seeThat(TheInputFieldValue.of(END_TIME_FIELD), equalTo(ValidData.getEndTimeConverted())));
		then(arina).should(seeThat(TheInputFieldValue.of(END_DATE_FIELD), equalTo(ValidData.getDateConverted())));
		then(arina).should(seeThat(TheInputFieldValue.of(DESCRIPTION_FIELD), equalTo(ValidData.getDescription())));
		then(arina).should(seeThat(TheInputFieldValue.of(URL_FIELD), equalTo(ValidData.getUrl())));
	}
	
	@Test
	public void should_be_able_to_add_new_note_with_const_data() {
		when(arina).attemptsTo(ClickButtons.clickOnCircleAddNoteButton());
		assertTrue(NotesNotesPage.ADD_NOTE_CIRCLE_BUTTON.resolveFor(arina).isEnabled());
		when(arina).attemptsTo(FillInNoteForm.fillInFormWithConstData());
		then(arina).wasAbleTo(ClickButtons.clickOnAddNoteButton());
		assertTrue(NotesNotesPage.ADD_NOTE_BUTTON.resolveFor(arina).isEnabled());
		
		//TODO check if note appears
	}
}
