package notes.tests;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import notes.pageObjects.HomePage;
import notes.tasks.TurnOnMusic;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.junit.Assert.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class TurnOnMusicTest {
	
	Actor arina = Actor.named("Arina");
	
	@Managed
	private WebDriver driver;
	
	@Before
	public void before() throws IOException {
		givenThat(arina).can(BrowseTheWeb.with(driver));
	}
	@Test
	public void shouldBeAbleToTurnOnMusic() {
		givenThat(arina).wasAbleTo(Open.browserOn().the(new HomePage()));
		when(arina).attemptsTo(TurnOnMusic.clickSettingButton());
		assertTrue(HomePage.SETTINGS_BUTTON.resolveFor(arina).isEnabled());
		when(arina).attemptsTo(TurnOnMusic.selectSwitchButton());
		assertTrue(HomePage.SWITCH_BUTTON.resolveFor(arina).isEnabled());
	}
}
