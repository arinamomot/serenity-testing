package notes.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class FormQuestion implements Question<List<String>> {
	@Override
	public List<String> answeredBy(Actor actor) {
		return null;
	}
}
