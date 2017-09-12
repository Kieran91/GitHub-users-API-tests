package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserProfilePage {

	// TODO paths aren't right
	@FindBy(how=How.CLASS_NAME, using="p-name")
	public static WebElement name;
	
	@FindBy(how=How.CLASS_NAME, using="p-org")
	public static WebElement company;
	
	@FindBy(how=How.CLASS_NAME, using="p-label")
	public static WebElement location;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/nav/a[2]/span")
	public static WebElement public_repos;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/nav/a[4]/span")
	public static WebElement followers;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"js-pjax-container\"]/div/div[2]/div[2]/nav/a[5]/span")
	public static WebElement following;
	
}
