package notes.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.HomePage;
import notes.tasks.ClickTask;
import notes.tasks.TurnOnMusic;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class DateCheckTest {
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	@Before
	public void before() {
		givenThat(arina).can(BrowseTheWeb.with(driver));
		givenThat(arina).wasAbleTo(Open.browserOn().the(new HomePage()));
	}
	
	@Test
	public void date_should_be_the_same_as_current_date() {
		when(arina).attemptsTo(ClickTask.clickOnMenuButton());
		assertTrue(HomePage.MENU_BUTTON.resolveFor(arina).isEnabled());
		assertTrue(HomePage.MENU_SECTION.resolveFor(arina).isVisible());
		
		//Get current date
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formattedDate = date.format(formatter);
		
		//Get data from website
		String dateFromWeb = Text.of(HomePage.DATE).answeredBy(arina).split(" ")[1];
		
		//Verify that the current date is the same as the date on the web
		assertEquals(formattedDate, dateFromWeb);
	}
}
