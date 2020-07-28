package files;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import java.io.File;

import org.testng.Assert;

public class JiraTest {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8080";
		//Login scenario
		SessionFilter session=new SessionFilter();
		String response=given().relaxedHTTPSValidation().log().all().headers("Content-Type","application/json").body("{ \"username\": \"username\", \"password\": \"password\" }")
				.filter(session).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
		
		//Add comment
		String expectedMessage="hi how are you?";
		String addCommentResponse=given().log().all().pathParam("key", "10200").headers("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"body\":\""+expectedMessage+"\",\r\n" + 
				"  \"visibility\": {\r\n" + 
				"      \"type\":\"role\",\r\n" + 
				"      \"value\":\"Administrators\"\r\n" + 
				"  }\r\n" + 
				"\r\n" + 
				"}").filter(session).when().post("/rest/api/2/issue/{key}/comment").then()
		.log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js=new JsonPath(addCommentResponse);
		String commentId=js.get("id").toString();
		
		//Add Attachement
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", "10200")
		.header("Content-Type","multipart/form-data").multiPart("file",new File("jira.txt")).when().post("/rest/api/2/issue/{key}/attachements")
		.then().log().all().assertThat().statusCode(200);
          
		String issuedetails=given().filter(session).pathParam("key", "10200").queryParam("fields", "comments")
		.log().all().when().get("/rest/api/2/issue/{key}").then().log().all()
		.extract().response().asString();
		System.out.println(issuedetails);
		JsonPath js1=new JsonPath(issuedetails);
		int commentcount=js1.get("fields.comment.comments.size()");
		for(int i=0;i<commentcount;i++) {
			String commentIdIssue =js1.get("fields.comment.comments["+i+"].id").toString();

			if (commentIdIssue.equalsIgnoreCase(commentId))

			{

			String message= js1.get("fields.comment.comments["+i+"].body").toString();

			System.out.println(message);

			Assert.assertEquals(message, expectedMessage);

			}

			}

			}

}
	


