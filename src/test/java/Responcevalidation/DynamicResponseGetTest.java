package Responcevalidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;

public class DynamicResponseGetTest
{
	@Test
	public void dynamicresponce()
	{
		String expData = "AllStates";
		baseURI="http://localhost";
		port=8084;
		
		Response resp = when()
		.get("/projects");
		
		//validation
		
		boolean flag=false;
		List<String> pName = resp.jsonPath().get("projectName");
		for (String actData : pName) 
		{
			if(actData.contains(expData))
			{
				flag=true;
				
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		//resp.then().log().all();
	}

}
