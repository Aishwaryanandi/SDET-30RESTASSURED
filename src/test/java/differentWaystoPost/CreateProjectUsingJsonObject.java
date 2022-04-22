package differentWaystoPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJsonObject 
{
	@Test
	public void createProjectUsingJsonFile()
	{
		JavaLibrary jlib=new JavaLibrary();
		
		//step1: create a pre requisites body
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "chan");
		jobj.put("projectName", "doorstep");
		jobj.put("status", "on going");
		jobj.put("teamSize", 13);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
}
