package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest 
{
	@Test
	public void getAllProjectsTest()
	{
		//step1: create pre requisits
		
		//step2: perform action
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_646");
		//step3: validation
		
		System.out.println(response.contentType());
		System.out.println(response.prettyPrint());
		response.then().log().all();
		
	}
}
