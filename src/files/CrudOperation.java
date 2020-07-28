package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;


public class CrudOperation {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload1.postBody()).when().post("/maps/api/place/add/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	JsonPath js=new JsonPath(response);
	String placeid=js.getString("place_id");
	System.out.println(placeid);
	
	String newaddress="3423 indiranagar banglore";
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n" + 
			"  \"place_id\": \""+placeid+"\",\r\n" + 
			"  \"address\":\""+newaddress+"\",\r\n" + 
			"  \"key\":\"qaclick123\"\r\n" + 
			"}").when().put("/maps/api/place/update/json")
	.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	String getResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
	.extract().response().asString();
	System.out.println(getResponse);
	
	JsonPath js1=new JsonPath(getResponse);
	String actualaddress=js1.getString("address");
	Assert.assertEquals(actualaddress, newaddress);
	
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body("{\r\n" + 
			"    \"place_id\":\""+placeid+"\"\r\n" +"}").when().delete("/maps/api/place/delete/json")
	.then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"));
	
	
	
		
		
		
		
		
		
		
		

	}

	private static JsonPath JsonPath(String response) {
		// TODO Auto-generated method stub
		return null;
	}

}
