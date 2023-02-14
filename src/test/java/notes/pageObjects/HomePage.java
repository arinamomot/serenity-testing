package notes.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://notes-vue-deploy-zks.vercel.app/#/")
public class HomePage extends PageObject {
	
	public static final Target SETTINGS_BUTTON =
		Target.the("Settings Button").locatedBy("/html/body/div[1]/div/header/div[1]/nav[2]/button");
	
	public static final Target SWITCH_BUTTON =
		Target.the("Switch Button").locatedBy("/html/body/div[3]/div/div/div[2]");
	
	public static final Target SETTINGS_WINDOW =
		Target.the("Settings Window").locatedBy("/html/body/div[3]");
	
	public static final Target AUTH_PAGE_BUTTON =
		Target.the("Auth Page Button").locatedBy("/html/body/div[1]/div/header/div[1]/nav[2]/a[2]");
	
	public static final Target NOTES_PAGE_BUTTON =
		Target.the("Notes Page Button").locatedBy("/html/body/div[1]/div/header/div[1]/nav[2]/a[3]");
	
	public static final Target ADD_NEW_NOTE_BUTTON_HOME =
		Target.the("Add New Note Button Home Page").locatedBy("/html/body/div[1]/div/div/div/svg/a");
	
	public static final Target MENU_BUTTON =
		Target.the("Menu Button").locatedBy("/html/body/div[1]/div/header/div[1]/button");
	
	public static final Target MENU_SECTION =
		Target.the("Menu Section").locatedBy("/html/body/div[1]/div/header/div[2]/aside/div[2]");
	
	public static final Target DATE =
		Target.the("Status").locatedBy("/html/body/div[1]/div/header/div[2]/aside/div[1]/p[2]");
	
}
