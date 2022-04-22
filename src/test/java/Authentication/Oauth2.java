package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 
{
	@Test
	public void oauth2()
	{
		//create a req to generate  access token
		
		Response resp = given()
		.formParam("client_id", "SDET-30COOPS")
		.formParam("client_secret", "714932318364b3193596c13e8bd0ca21")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://chandan.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp);
		resp.then().log().all();
		
		//capture the acess token from the responce of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//create another request and use the token to access the APi
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3120)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count");
		
		resp.then().log().all();
		
	}
}
