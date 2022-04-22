package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest 
{
	@Test
	public void pathParameterTest()
	{
		baseURI="http://localhost";
		port=8084;
		//pre req
		given()
		.pathParam("pid", "TY_PROJ_1617")
		
		// action
		.when()
		.get("/projects/{pid}")
		
		.then().log().all();
	}
}
