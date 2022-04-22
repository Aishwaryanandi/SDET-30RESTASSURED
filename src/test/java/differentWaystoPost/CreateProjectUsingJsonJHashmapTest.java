package differentWaystoPost;

import org.testng.annotations.Test;

import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingJsonJHashmapTest 
{
	@Test
	public void createProjectUsingJsonJHashmapTest()
	{
		JavaLibrary jlib=new JavaLibrary();
		
		baseURI="http://localhost";
		port=8084;
		
		HashMap map=new HashMap();
		map.put("createdBy", "chandan");
		map.put("projectName", "sony"+jlib.getRandomNumber());
		map.put("status", "comleted");
		map.put("teamSize", 4);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
		
	}
}
