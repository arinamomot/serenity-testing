package notes.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TheInputFieldValue implements Question<String> {
	private final Target target;
	
	public static TheInputFieldValue of(Target target) {
		return new TheInputFieldValue(target);
	}
	
	public TheInputFieldValue(Target target) {
		this.target = target;
	}
	
	@Override
	@Step("Return the input value")
	public String answeredBy(Actor actor) {
		WebElementFacade inputField = target.resolveFor(actor);
		return inputField.getValue();
	}
}
