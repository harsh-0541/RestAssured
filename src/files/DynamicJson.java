package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle) {
		
      RestAssured.baseURI="http://216.10.245.166";
    String addbook=given().log().all().header("Content-Type","application/json").body(payload1.addBook(isbn,aisle)).when().
      post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
    JsonPath js=new JsonPath(addbook);
   String id=js.get("ID");
   System.out.println(id);
   
       
	}
   
   @DataProvider(name="BooksData")
   public Object[][] getData() {
	 return  new Object[][] {{"harsha","4100"},{"golu","0542"},{"singh","9800"}};
   }
    
}

