package responses;

public class HttpResponse {

	String responseContent;
	int responseCode;

	public HttpResponse(String responseContent, int responseCode) {
		super();
		this.responseContent = responseContent;
		this.responseCode = responseCode;
	}
	
	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

}
