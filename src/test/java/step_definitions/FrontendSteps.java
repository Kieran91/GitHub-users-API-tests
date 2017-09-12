package step_definitions;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import modules.BrowserConfig;
import pageobjects.UserGistsPage;
import pageobjects.UserProfilePage;
import responses.JsonResponse;
import spring.TestState;

public class FrontendSteps {

	@Autowired
	private TestState state;
	@Autowired
	private BrowserConfig bc;
	@Autowired
	private JsonResponse jr;
	
	@Then("^the webpage value for \"([^\"]*)\" matches the corresponding JSON value received in the API response$")
	public void the_webpage_value_for_x_matches_the_corresponding_JSON_value_received_in_the_API_response(String fieldName) throws MalformedURLException{
	    
		// check if the browser is open
		if(state.getDriver() == null){
			bc.openBrowser();
		}
		
		// get the target url
		String url = getTargetUrl(fieldName);
		
		// check if the page url that the browser is currently on matches with the page we need to be on
		if(!state.getDriver().getCurrentUrl().equals(url)){
			state.getDriver().get(url);
		}
		if(fieldName.equalsIgnoreCase("public_gists")){
			PageFactory.initElements(state.getDriver(), UserGistsPage.class);
		} else{
			PageFactory.initElements(state.getDriver(), UserProfilePage.class);
		}

		// find the value on the page
		String pageValue = getPageValue(fieldName);
		
		// find the json value
		String jsonValue = jr.getValueFromJson(fieldName);
		if(jsonValue == null){
			jsonValue = "";
		}
		
		// compare with the json response.
		if(!pageValue.equals(jsonValue)){
			Assert.fail("The webpage value of '"+pageValue+"' did not match the json value of '"+jsonValue+"' for the field '"+fieldName+"'.");
		} else {
			System.out.println("The webpage value of '"+pageValue+"' matched the json value of '"+jsonValue+"' for the field '"+fieldName+"'.");
		}
		
		
	}

	@After
	public void closeBrowser() {
		if(state.getDriver() != null){
			state.getDriver().quit();
		}
	}
	
	private String getPageValue(String fieldName) {
		String value = "";
		
		// get the specific value from the webpage
		try {
			if(fieldName.equalsIgnoreCase("name")){
				value = UserProfilePage.name.getText();
			} else if(fieldName.equalsIgnoreCase("company")) {
				value = UserProfilePage.company.getText();
			} else if(fieldName.equalsIgnoreCase("location")) {
				value = UserProfilePage.location.getText();
			} else if(fieldName.equalsIgnoreCase("public_repos")) {
				value = UserProfilePage.public_repos.getText();
			} else if(fieldName.equalsIgnoreCase("public_gists")) {
				value = UserGistsPage.public_gists.getText();
			} else if(fieldName.equalsIgnoreCase("followers")) {
				value = UserProfilePage.followers.getText();
			} else if(fieldName.equalsIgnoreCase("following")) {
				value = UserProfilePage.following.getText();
			} else {
				Assert.fail("The field '"+fieldName+"' is not recognised as a valid value to be found on the webpage.");
			}
		} catch (NoSuchElementException e) {
			   
		}
		
		return value.trim();
		
	}

	private String getTargetUrl(String fieldName) {
		String targetUrl = state.getJsonResp().getHtmlUrl();
		
		if(fieldName.equalsIgnoreCase("public_gists")){
			targetUrl = "https://gist.github.com/"+state.getJsonResp().getLogin();
		}
		return targetUrl;
	}
	
}
