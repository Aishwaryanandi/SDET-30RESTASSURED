package requestChaining;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndGetProjectTest 
{
	@Test
	public void createProjectAndGetProjectTest()
	{
		//step1: create a project using pojo
		JavaLibrary jlib=new JavaLibrary();
		ProjectLibrary plib=new ProjectLibrary("swathi", "firefox"+jlib.getRandomNumber(), "completed", 10);
		baseURI="http://localhost";
		port=8084;
		
		//pre req
		Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//capture the project id
		String proId=resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//create a get request and pass proId as path parameter
		given()
		.pathParam("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then().assertThat().statusCode(200).log().all();
		
		
	}
}
