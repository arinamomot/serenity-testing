package notes.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://notes-vue-deploy-zks.vercel.app/#/auth")
public class AuthPage extends PageObject {
	
	public static final Target NAME_FIELD =
		Target.the("Name Field").locatedBy("/html/body/div[1]/div/div/div/form/div[1]/label[1]/div/div[1]/div[1]/input");
}
