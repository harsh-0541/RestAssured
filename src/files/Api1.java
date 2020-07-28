package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;


public class Api1 {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload1.postBody()).when().post("maps/api/place/add/json").then()
		.log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		
		//update place
		String newAddress="70 winter walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json/").then().log().all().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		//get place
		String getResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1=new JsonPath(getResponse);
		String actualAddress=js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
		
		String deleteresponse=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"    \"place_id\":\""+placeid+"\"\r\n" + 
				"}").when().delete("maps/api/place/delete/json").then().log().all()
		.assertThat().statusCode(200).extract().response().asString();
		System.out.println(deleteresponse);
		
}
 }


