package spring;

import org.openqa.selenium.WebDriver;

import responses.HttpResponse;
import responses.UsersMsg;

public class TestState {
	HttpResponse response;
	UsersMsg jsonResp;
	WebDriver driver;

	public HttpResponse getResponse() {
		return response;
	}
	
	public void setResponse(HttpResponse response) {
		this.response = response;
	}

	public UsersMsg getJsonResp() {
		return jsonResp;
	}

	public void setJsonResp(UsersMsg jsonResp) {
		this.jsonResp = jsonResp;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
