package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static notes.pageObjects.AuthPage.*;

public class FillInAuthFormWithCSVData {
	@Step
	public static Task fillInFormWithCSVData(Map<String, String> testData) {
		return Task.where(
			"Fill in auth form with data from CSV file",
			WaitUntil.the(AUTH_FORM, isVisible())
				.then(enterName(testData.get("name")))
				.then(enterSurname(testData.get("surname")))
				.then(enterBirth(testData.get("birth")))
				.then(enterCity(testData.get("city")))
				.then(enterUniversity(testData.get("university")))
				.then(enterEmail(testData.get("email")))
				.then(enterPassword(testData.get("password")))
		);
	}
}
