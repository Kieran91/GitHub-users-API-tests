package responses;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import spring.TestState;

public class JsonResponse {

	@Autowired
	private TestState state;

	public String getValueFromJson(String fieldName) {

		String value = "";

		// get the specific value from the JSON
		if(fieldName.equalsIgnoreCase("name")){
			value = state.getJsonResp().getName();
		} else if(fieldName.equalsIgnoreCase("id")) {
			value = state.getJsonResp().getId().toString();
		} else if(fieldName.equalsIgnoreCase("company")) {
			value = state.getJsonResp().getCompany();
		} else if(fieldName.equalsIgnoreCase("location")) {
			value = state.getJsonResp().getLocation();
		} else if(fieldName.equalsIgnoreCase("public_repos")) {
			value = state.getJsonResp().getPublicRepos().toString();
		} else if(fieldName.equalsIgnoreCase("public_gists")) {
			value = state.getJsonResp().getPublicGists().toString();
		} else if(fieldName.equalsIgnoreCase("followers")) {
			value = state.getJsonResp().getFollowers().toString();
		} else if(fieldName.equalsIgnoreCase("following")) {
			value = state.getJsonResp().getFollowing().toString();
		} else {
			Assert.fail("The field '"+fieldName+"' is not recognised as a valid field name in the JSON response.");
		}

		return value;
	}

}
