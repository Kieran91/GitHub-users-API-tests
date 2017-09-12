package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserGistsPage {

	@FindBy(how=How.XPATH, using="//*[@id=\"gist-pjax-container\"]/div[1]/div/div[2]/nav/a[1]/span")
	public static WebElement public_gists;
}
