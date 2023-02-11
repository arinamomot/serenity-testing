package notes.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://notes-vue-deploy-zks.vercel.app/#/notes")
public class NotesNotesPage extends PageObject {
	
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
	
}
