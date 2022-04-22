package Responcevalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class Staticresponcegetvalidation 
{
	@Test
	public void staticresponceget()
	{
		baseURI="http://localhost";
		port=8084;
		String expData = "TY_PROJ_002";
		
		Response resp = when()
		.get("/projects");
		
		String actData = resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verified");
		resp.then().log().all();
		
		
	}
}
