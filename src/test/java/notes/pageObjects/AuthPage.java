package notes.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://notes-vue-deploy-zks.vercel.app/#/auth")
public class AuthPage extends PageObject {
	
	public static final Target AUTH_FORM =
		Target.the("Auth Form").locatedBy("/html/body/div[1]/div/div/div/form");
	
	
	public static final Target NAME_FIELD =
		Target.the("Name Field").locatedBy("/html/body/div[1]/div/div/div/form/div[1]/label[1]/div/div[1]/div/input");
	
	public static final Target SURNAME_FIELD =
		Target.the("Surname Field").locatedBy("/html/body/div[1]/div/div/div/form/div[1]/label[2]/div/div[1]/div/input");
	
	public static final Target BIRTH_FIELD =
		Target.the("Birth Field").locatedBy("/html/body/div[1]/div/div/div/form/label[1]/div/div[1]/div/input");
	
	public static final Target CITY_FIELD =
		Target.the("City Field").locatedBy("/html/body/div[1]/div/div/div/form/div[2]/label[1]/div/div[1]/div[1]/div[1]/input");
	
	public static final Target UNIVERSITY_FIELD =
		Target.the("University Field").locatedBy("/html/body/div[1]/div/div/div/form/div[2]/label[2]/div/div[1]/div[1]/div[1]/input");
	
	public static final Target EMAIL_FIELD =
		Target.the("Email Field").locatedBy("/html/body/div[1]/div/div/div/form/label[2]/div/div[1]/div/input");
	
	public static final Target PASSWORD_FIELD =
		Target.the("Password Field").locatedBy("/html/body/div[1]/div/div/div/form/label[3]/div/div[1]/div[1]/input");
	
	public static final Target LICENSE_TERMS_CHECKBOX =
		Target.the("License Terms Checkbox").locatedBy("/html/body/div[1]/div/div/div/form/div[3]");
	
	public static final Target SUBMIT_AUTH_BUTTON =
		Target.the("Submit Auth Button").locatedBy("/html/body/div[1]/div/div/div/form/div[4]/button[1]");
	
	public static final Target RESET_AUTH_BUTTON =
		Target.the("Reset Auth Button").locatedBy("/html/body/div[1]/div/div/div/form/div[4]/button[2]");
	
	// You need to accept the license and terms first
	// Please check and fill the form correctly
	// Submitted
	public static final Target NOTIFICATION =
		Target.the("Notification").locatedBy("/html/body/div[2]/div[4]/div/div/div/div");
	
	public static Performable enterName(String name) {
		return Enter.theValue(name).into(NAME_FIELD);
	}
	
	public static Performable enterSurname(String surname) {
		return Enter.theValue(surname).into(SURNAME_FIELD);
	}
	
	public static Performable enterBirth(String birth) {
		return Enter.theValue(birth).into(BIRTH_FIELD);
	}
	
	public static Performable enterCity(String city) {
		return Enter.theValue(city).into(CITY_FIELD);
	}
	
	public static Performable enterUniversity(String university) {
		return Enter.theValue(university).into(UNIVERSITY_FIELD);
	}
	
	public static Performable enterEmail(String email) {
		return Enter.theValue(email).into(EMAIL_FIELD);
	}
	
	public static Performable enterPassword(String password) {
		return Enter.theValue(password).into(PASSWORD_FIELD);
	}
}
