package Authentication;
import  static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken 
{
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com";
		JSONObject jobj=new JSONObject();
		jobj.put("name", "sdet-30-restAssured");
		
		given()
		.auth().oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().assertThat().statusCode(201).log().all();
		
	}
}
