package Parameter;
import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FormParameter 
{
	@Test
	public void formParameter()
	{
		//pre req
		given()
		.formParam("createdBy", "aishu")
		.formParam("projectName", "bmtc")
		.formParam("status", "damaged")
		.formParam("teamSize", 1)
		.contentType(ContentType.JSON)
		
		//action
		.when()
		.post("/addProject")
		
		//validate
		
		.then()
		.log().all();
}
}
