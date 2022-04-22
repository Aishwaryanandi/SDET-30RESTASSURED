package differentWaystoPost;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {
	
	@Test
	public void createProject()
	{
		JavaLibrary jLib = new JavaLibrary();
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create pre requisites
		ProjectLibrary pLib = new ProjectLibrary("lekhana", "lenovo "+jLib.getRandomNumber(), "Completed", 6);
		
		given()
		 .body(pLib)
		 .contentType(ContentType.JSON)
		.when()                          //Step 2: perform action
		 .post("/addProject")
		.then()                          //Step 3: validation
		 .assertThat().statusCode(201)
		 .log().all();
		
		
		
	}

}
