package files;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;


public class kickdrmPut {

	public static void main(String[] args)
	{
		RestAssured.baseURI= "https://qa-test.kickdrumtech.com";
	    String responseKickdrum=given().log().all().header("Content-Type","application/json")
		.when().put("v1/user/kickdrum")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(responseKickdrum);
				
		System.out.println("---------When path parameter is other than kickdrum-----");
		
		RestAssured.baseURI= "https://qa-test.kickdrumtech.com";
	    String responseOther=given().log().all().header("Content-Type","application/json")
		.when().put("v1/user/kickdrum123")
		.then().assertThat().statusCode(504).extract().response().asString();
		System.out.println(responseOther);
	}
}
