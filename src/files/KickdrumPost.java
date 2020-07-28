package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;


public class KickdrumPost {

	public static void main(String[] args)
	{
		RestAssured.baseURI= "https://qa-test.kickdrumtech.com";
	    String responsemissing=given().log().all().header("Content-Type","application/json")
		.body(payload.missingParameter()).when().post("v1/login")
		.then().assertThat().statusCode(400).extract().response().asString();
		System.out.println(responsemissing);
				
		System.out.println("----------------Authentication Successful-------");
				
		RestAssured.baseURI= "https://qa-test.kickdrumtech.com";
		String responsesuccess=given().log().all().header("Content-Type","application/json")
		.body(payload.loginSuccess()).when().post("v1/login")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(responsesuccess);
				
		System.out.println("----------------Invalid username or password-------");
				
		RestAssured.baseURI= "https://qa-test.kickdrumtech.com";
		String responseinvalid=given().log().all().header("Content-Type","application/json")
		.body(payload.InvalidCredential()).when().post("v1/login")
		.then().assertThat().statusCode(401).extract().response().asString();
		System.out.println(responseinvalid);

	}
}