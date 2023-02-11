package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.NotesAuthPage.NAME_FIELD;
import static notes.pageObjects.NotesHomePage.SETTINGS_BUTTON;
import static notes.pageObjects.NotesHomePage.SWITCH_BUTTON;

public class Manage {
	
	public static Task fillFirstName(String firstName) {
		return Task.where(
			"{0} fill firstName: #firstName",
			WaitUntil.the(NAME_FIELD, isVisible())
				.then(Enter.theValue(firstName).into(NAME_FIELD)));
	}
	
	public static Task clickSettingButton() {
		return Task.where(
			"{1} turn on music",
			WaitUntil.the(SETTINGS_BUTTON, isVisible())
				.then(Click.on(SETTINGS_BUTTON))
		);
	}
	
	public static Task selectSwitchButton() {
		return Task.where(
			"{2} turn on music",
			Click.on(SWITCH_BUTTON)
//			WaitUntil.the(SWITCH_BUTTON, isVisible())
//				.then(Click.on(SWITCH_BUTTON))
		);
	}
}
