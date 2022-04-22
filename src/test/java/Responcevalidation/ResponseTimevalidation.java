package Responcevalidation;



import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimevalidation
{
	@Test
	public void responseTimevalidation()
	{
		//pre requisites
		baseURI="http://localhost";
		port=8084;
		 
		//action
	    Response t = when()
	    .get("/projects");
	    
		t.then()
		.assertThat().time(Matchers.lessThan(1500L),TimeUnit.MILLISECONDS);
		t.then().log().all();
		
		long time = t.time();
		System.out.println(time);
		
		
	//validation
		
		
		
		
	
		
	}

}
