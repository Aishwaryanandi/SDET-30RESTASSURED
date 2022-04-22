package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void updateProjectTest()
	{
		//step1: create the pre-requisites -request boby
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "chandan");
		jobj.put("projectName", "xylem1");
		jobj.put("status", "completed");
		jobj.put("teamsize", 12);
		
		//step2: perform the action
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
//		req.contentType(ContentType.JSON);
		
		
		
		Response response = req.put("http://localhost:8084/projects/TY_PROJ_1402");
		
		//step3: validate the response
		
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		response.then().log().all();
	}
}
