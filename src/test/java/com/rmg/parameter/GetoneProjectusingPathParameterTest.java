package com.rmg.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetoneProjectusingPathParameterTest 
{
	@Test
	public void getoneProjectusingPathParameterTest()
	{
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/login")
		.then()
		.assertThat().statusCode(202)
		.log().all();
	}
	
     @Test
     public void digestiveauth()
     {
    	 given().auth().digest("rmgyantra", "rmgy@9999")
 		.when().get("http://localhost:8084/login")
 		.then()
 		.assertThat().statusCode(202)
 		.log().all(); 
     }
	
     @Test
     public void preemptiveauth()
     {
    	 given().auth().preemptive().basic("rmgyantra", "rmgyantra")
 		.when().get("http://localhost:8084/login")
 		.then()
 		.assertThat().statusCode(202)
 		.log().all(); 
     }
}
