package notes.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class NameQuestion implements Question<String> {
	
	public static Question<String> firstName() {
		return new NameQuestion();
	}
	
	@Override
	public String answeredBy(Actor actor) {
		String fullName = "New Note";
		return fullName;
	}
}