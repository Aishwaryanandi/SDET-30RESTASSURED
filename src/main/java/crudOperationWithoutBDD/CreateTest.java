package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateTest 
{
	@Test
	public void createPtojectTest()
	{
		//step1: create the pre-requisites -request boby
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "chandan");
		jobj.put("projectName", "xylem1");
		jobj.put("status", "completed");
		jobj.put("teamsize", 4);
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
//		req.contentType(ContentType.JSON);
		
		//step2: perform the action
		
		Response response = req.post("http://localhost:8084/addProject");
		
		//step3: validate the response
		
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
	}
}
