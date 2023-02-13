package notes.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://notes-vue-deploy-zks.vercel.app/#/notes")
public class NotesPage extends PageObject {
	
	public static final Target ADD_NOTE_CIRCLE_BUTTON =
		Target.the("Add Note Circle Button").locatedBy("/html/body/div[1]/div/div/div/div/div/button");
	public static final Target NEW_NOTE_FORM =
		Target.the("New Note Form").locatedBy("/html/body/div[3]/div[2]/div/div/form");
	
	public static final Target TITLE_FIELD =
		Target.the("Title Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/label[1]/div/div[1]/div/input");
	public static final Target LOCATION_FIELD =
		Target.the("Location Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/label[2]/div/div[1]/div/input");
	public static final Target START_TIME_FIELD =
		Target.the("Start Time Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/div[1]/div[1]/label[1]/div/div[1]/div/input");
	public static final Target START_DATE_FIELD =
		Target.the("Start Date Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/div[1]/div[1]/label[2]/div/div[1]/div/input");
	public static final Target END_TIME_FIELD =
		Target.the("End Time Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/div[1]/div[2]/label[1]/div/div[1]/div/input");
	public static final Target END_DATE_FIELD =
		Target.the("End Date Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/div[1]/div[2]/label[2]/div/div[1]/div/input");
	public static final Target DESCRIPTION_FIELD =
		Target.the("Description Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/label[3]/div/div[1]/div/textarea");
	public static final Target URL_FIELD =
		Target.the("URL Field").locatedBy("/html/body/div[3]/div[2]/div/div/form/label[4]/div/div[1]/div/input");
	public static final Target ADD_NOTE_BUTTON =
		Target.the("Add Note Button").locatedBy("/html/body/div[3]/div[2]/div/div/form/div[2]/button[1]");
	public static final Target RESET_BUTTON =
		Target.the("Reset Button").locatedBy("/html/body/div[3]/div[2]/div/div/form/div[2]/button[2]");
	
	public static final Target NOTES_SECTION =
		Target.the("Notes Section").locatedBy("/html/body/div[1]/div/div/div/section");
	
	public static final Target NOTE_CARD =
		Target.the("Note Card").locatedBy("/html/body/div[1]/div/div/div/section/div");
	
	//	public static Target NOTE_CARD_DYNAMIC(int index) {
//		return Target.the("{1} card").locatedBy("/html/body/div[1]/div/div/div/section/div[" + index + "]");
//	}
	public static final Target NOTE_CARD_DYNAMIC =
		Target.the("{1} card").locatedBy("/html/body/div[1]/div/div/div/section/div['{1}']");

//	public static Target NOTE_DIV_INDEX(int index) {
//		return Target.the("note div with index '{0}'").located(By.cssSelector("div.note:nth-child(" + index + ")"));
//	}
	
	public static final Target LOCATION_ERROR =
		Target.the("Location error").locatedBy("\t/html/body/div[3]/div[2]/div/div/form/label[2]/div/div[1]/div[3]");
	
	public static final Target DELETE_BUTTON =
		Target.the("Delete Button").locatedBy("/html/body/div[3]/div[2]/div/div/div[4]/button");
	
	public static Performable enterTitle(String title) {
		return Enter.theValue(title).into(TITLE_FIELD);
	}
	
	public static Performable enterLocation(String location) {
		return Enter.theValue(location).into(LOCATION_FIELD);
	}
	
	public static Performable enterStartTime(String startTime) {
		return Enter.theValue(startTime).into(START_TIME_FIELD);
	}
	
	public static Performable enterStartDate(String startDate) {
		return Enter.theValue(startDate).into(START_DATE_FIELD);
	}
	
	public static Performable enterEndTime(String endTime) {
		return Enter.theValue(endTime).into(END_TIME_FIELD);
	}
	
	public static Performable enterEndDate(String endDate) {
		return Enter.theValue(endDate).into(END_DATE_FIELD);
	}
	
	public static Performable enterDescription(String description) {
		return Enter.theValue(description).into(DESCRIPTION_FIELD);
	}
	
	public static Performable enterURL(String url) {
		return Enter.theValue(url).into(URL_FIELD);
	}
}
