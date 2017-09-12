package step_definitions;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.google.gson.Gson;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.HttpClient;
import responses.HttpResponse;
import responses.JsonResponse;
import responses.UsersMsg;
import spring.SpringConfig;
import spring.TestState;

@ContextConfiguration(classes = { SpringConfig.class })
public class BackendSteps {

	@Autowired
	private TestState state;
	@Autowired
	private JsonResponse jr;
	
	@Given("^the github public users API receives a GET request for the user \"([^\"]*)\"$")
	public void the_github_public_users_api_receives_a_get_request_for_the_user_x(String user) throws Throwable {
	    
	    String url ="https://api.github.com/users/"+user;
		sendGet(url);
	     
	}
	
	@When("^a HTTP response of \"([^\"]*)\" is received$")
	public void a_http_response_of_x_is_received(int expectedStatusCode) {
	    
		if(state.getResponse().getResponseCode() == expectedStatusCode){
			System.out.println("The HTTP response code was '"+state.getResponse().getResponseCode()+"'.");
		} else{
			Assert.fail("The HTTP response code was '"+state.getResponse().getResponseCode()+"' instead of '"+expectedStatusCode+"'.");
		}
		
	}

	@Then("^the JSON response contains the field \"([^\"]*)\" with a value of \"([^\"]*)\"$")
	public void the_json_response_contains_the_field_x_with_a_value_of_y(String fieldName, String expectedValue) {
	    
		// get the value from the json
		String respValue = jr.getValueFromJson(fieldName);

		// compare the json & expected values
		if(respValue.equalsIgnoreCase(expectedValue)){
			System.out.println("The field '"+fieldName+"' had a value of '"+respValue+"'.");
		} else{
			Assert.fail("The field '"+fieldName+"' was '"+respValue+"' instead of '"+expectedValue+"'.");
		}

		
	}
	
	
	private void sendGet(String url) throws Exception {

		HttpResponse response = HttpClient.sendGetRequest(url);
		this.state.setResponse(response);

		if(this.state.getResponse().getResponseCode() == 200){
			String strResp = this.state.getResponse().getResponseContent();
			this.state.setJsonResp(new Gson().fromJson(strResp, UsersMsg.class));
		}

	}
	
}


