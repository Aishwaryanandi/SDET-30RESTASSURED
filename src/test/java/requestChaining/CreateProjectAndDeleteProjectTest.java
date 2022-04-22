package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndDeleteProjectTest 
{
	@Test
	public void CreateProjectAndDeleteProjectTest()
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
				.delete("/projects/{pid}")
				.then().assertThat().statusCode(204).log().all();
	}
}
