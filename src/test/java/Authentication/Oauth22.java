package Authentication;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth22 
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
		
}}
