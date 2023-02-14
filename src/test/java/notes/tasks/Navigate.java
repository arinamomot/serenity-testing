package notes.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navigate {
	@Step
	public static Task navigateTo(Target target) {
		return Task.where(
			"Go to needed page",
			WaitUntil.the(target, isVisible())
				.then(Click.on(target))
		);
	}
}
