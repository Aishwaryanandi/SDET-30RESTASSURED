package Responcevalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import  static io.restassured.RestAssured.*;

public class Staticresponcecreatevalidation
{
	@Test
	public void staticresponcecreate()
	{
	    //pre requsites
		JavaLibrary jlib=new JavaLibrary();
		ProjectLibrary pLib=new ProjectLibrary("sudhakar", "lenovo"+jlib.getRandomNumber(),"created" , 10);
		baseURI="http://localhost";
		port=8084;
		String expData = "TY_PROJ_1610";
		 
		  Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		 .when()
		.post("/addProject");
		  
		  //validation
		
		String actData = resp.jsonPath().get("projectId");
		Assert.assertEquals(actData, expData);
		//Assert.assertTrue(actData.contains(expData));
		System.out.println("data varified");
		resp.then().log().all();
	}

}
