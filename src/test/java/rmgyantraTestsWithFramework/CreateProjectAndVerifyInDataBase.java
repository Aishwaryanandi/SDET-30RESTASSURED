package rmgyantraTestsWithFramework;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibraries.BaseAPIClass;
import commonLibraries.ContantsLibrary;
import commonLibraries.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class CreateProjectAndVerifyInDataBase extends BaseAPIClass{
	
	@Test
	public void createProjectVerifyInDb() throws Throwable
	{
		//Step 1: create Pre requistes
		ProjectLibrary pLib = new ProjectLibrary("Aish", "Tyss "+jLib.getRandomNumber(), "On Going", 10);
		
		Response resp = given()
		                  .body(pLib)
		                  .contentType(ContentType.JSON)
		 
	                   	  .when()
		                  .post(EndPointsLibrary.CreateProject);
		
		//Step 2: Capture the projectID
		String expData = rLib.getJsonPath(resp, "projectId");
		System.out.println(expData);
		
		//Step 3: Verify the project in API response
		given()
		 .pathParam("pId", expData)
		.when()
		 .get(EndPointsLibrary.GetAllprojects+"/{pId}")
		.then().log().all();
		System.out.println("Data successfuly verifies in API response");
		
		//Step 4: Verify the project in Database
		String query = "select * from project";
		String data = dLib.executeQueryAndGetData(query,expData, 1);
		System.out.println(data);
		System.out.println("data verifed successfully in databse");
		 
		
	}

}
