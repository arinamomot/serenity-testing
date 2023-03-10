package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.HomePage.*;

public class TurnOnMusic {
	@Step
	public static Task clickSettingButton() {
		return Task.where(
			"Click settings button",
			WaitUntil.the(SETTINGS_BUTTON, isVisible())
				.then(Click.on(SETTINGS_BUTTON))
		);
	}
	@Step
	public static Task selectSwitchButton() {
		return Task.where(
			"Turn on music",
			WaitUntil.the(SETTINGS_WINDOW, isVisible())
				.then(Click.on(SWITCH_BUTTON))
		);
	}
}
