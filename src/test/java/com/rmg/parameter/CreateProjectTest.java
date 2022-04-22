package com.rmg.parameter;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import javax.swing.JList;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "chandan");
		jobj.put("projectName", "xylem3");
		jobj.put("status", "completed");
		jobj.put("teamsize", 4);
		
		baseURI="http://localhost";
		port=8084;
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
	}
}
