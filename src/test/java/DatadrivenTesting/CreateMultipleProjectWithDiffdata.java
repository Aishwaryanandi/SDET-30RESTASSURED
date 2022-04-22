package DatadrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class CreateMultipleProjectWithDiffdata
{
	@Test(dataProvider="getData")
	public void createproject(String createdBy,String projectName, String status, int teamSize)
	{
		JavaLibrary jLib=new JavaLibrary();
		 
		baseURI="http://localhost";
		port=8084;
		ProjectLibrary pLib=new ProjectLibrary(createdBy, projectName+jLib.getRandomNumber(), status, teamSize);
		
		
		//Prerequisite
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		//action
		.when()
		.post("/addProject")
		
		//validation
		
		.then().log().all();
		
		
		
		
	}
	@DataProvider(name="getData")
	public Object[][] data()
	{
		Object[][] data=new Object[3][4];
		
		data[0][0]="Aishu";
		data[0][1]="Myntra";
		data[0][2]="On going";
		data[0][3]=10;
		
		
		data[1][0]="Chandan";
		data[1][1]="Sony";
		data[1][2]="On going";
		data[1][3]=12;
		
		data[2][0]="Lekhana";
		data[2][1]="Amdox";
		data[02][2]="On going";
		data[2][3]=15;

		
		
		return data;
	}

}
