package notes.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NotesCount implements Question<Integer> {
	
	private final Target target;
	
	public NotesCount(Target target) {
		this.target = target;
	}
	
	public static NotesCount locatedBy(Target target) {
		return new NotesCount(target);
	}
	
	@Override
	public Integer answeredBy(Actor actor) {
		actor.attemptsTo(WaitUntil.the(target, isVisible()));
		return target.resolveAllFor(actor).size();
	}
}
