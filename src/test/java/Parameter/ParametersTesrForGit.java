package Parameter;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class ParametersTesrForGit 
{
	@Test
	public void parameterstest()
	{
		baseURI="https://api.github.com";
		
		given()
		.pathParam("username", "Aishu")
		.queryParam("per_page",30 )
		.queryParam("page", 1)
		
		.when()
		.get("/users/{username}/repos")
		
		
		.then().assertThat().statusCode(200)
		.log().all();
		
	}
}
