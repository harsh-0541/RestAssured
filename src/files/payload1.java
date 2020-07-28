package files;

public class payload1 {

      public static String postBody() {
    	  return "{\r\n" + 
    	  		"  \"location\": {\r\n" + 
    	  		"    \"lat\": -38.383494,\r\n" + 
    	  		"    \"lng\": 33.427362\r\n" + 
    	  		"  },\r\n" + 
    	  		"  \"accuracy\": 50,\r\n" + 
    	  		"  \"name\": \"Harsh Vardhan \",\r\n" + 
    	  		"  \"phone_number\": \"9620665832\",\r\n" + 
    	  		"  \"address\": \"B-1201, orchid lake View Appartment\",\r\n" + 
    	  		"  \"types\": [\r\n" + 
    	  		"    \"shoe park\",\r\n" + 
    	  		"    \"shop\"\r\n" + 
    	  		"  ],\r\n" + 
    	  		"  \"website\": \"http://google.com\",\r\n" + 
    	  		"  \"language\": \"English-UK\"\r\n" + 
    	  		"}\r\n" + 
    	  		"";
	}
      public static String coursePrice() {
    	  return "{\r\n" + 
    	  		"\r\n" + 
    	  		"\"dashboard\": {\r\n" + 
    	  		"\r\n" + 
    	  		"\"purchaseAmount\": 910,\r\n" + 
    	  		"\r\n" + 
    	  		"\"website\": \"rahulshettyacademy.com\"\r\n" + 
    	  		"\r\n" + 
    	  		"},\r\n" + 
    	  		"\r\n" + 
    	  		"\"courses\": [\r\n" + 
    	  		"\r\n" + 
    	  		"{\r\n" + 
    	  		"\r\n" + 
    	  		"\"title\": \"Selenium Python\",\r\n" + 
    	  		"\r\n" + 
    	  		"\"price\": 50,\r\n" + 
    	  		"\r\n" + 
    	  		"\"copies\": 6\r\n" + 
    	  		"\r\n" + 
    	  		"},\r\n" + 
    	  		"\r\n" + 
    	  		"{\r\n" + 
    	  		"\r\n" + 
    	  		"\"title\": \"Cypress\",\r\n" + 
    	  		"\r\n" + 
    	  		"\"price\": 40,\r\n" + 
    	  		"\r\n" + 
    	  		"\"copies\": 4\r\n" + 
    	  		"\r\n" + 
    	  		"},\r\n" + 
    	  		"\r\n" + 
    	  		"{\r\n" + 
    	  		"\r\n" + 
    	  		"\"title\": \"RPA\",\r\n" + 
    	  		"\r\n" + 
    	  		"\"price\": 45,\r\n" + 
    	  		"\r\n" + 
    	  		"\"copies\": 10\r\n" + 
    	  		"\r\n" + 
    	  		"},\r\n" + 
    	  		"{\r\n" + 
    	  		"\r\n" + 
    	  		"\"title\": \"Appium\",\r\n" + 
    	  		"\r\n" + 
    	  		"\"price\": 35,\r\n" + 
    	  		"\r\n" + 
    	  		"\"copies\": 7\r\n" + 
    	  		"\r\n" + 
    	  		"}\r\n" + 
    	  		"\r\n" + 
    	  		"]\r\n" + 
    	  		"\r\n" + 
    	  		"}";
      }
      public static String addBook(String isbn,String aisle) {
    	  return "{\r\n" + 
    	  		"    \"name\":\"Learn appium automation with java\",\r\n" + 
    	  		"    \"isbn\":\""+isbn+"\",\r\n" + 
    	  		"    \"aisle\":\""+aisle+"\",\r\n" + 
    	  		"    \"author\":\"john foe\"\r\n" + 
    	  		"\r\n" + 
    	  		"}";      }
      
      public static String createRepo() {
    	  return "{\r\n" + 
    	  		"  \"name\": \"Api automationharsh\",\r\n" + 
    	  		"  \"description\":\"this is first api on github\",\r\n" + 
    	  		"  \"homepage\":\"https://github.com\",\r\n" + 
    	  		"  \"private\":false,\r\n" + 
    	  		"  \"has_issues\":true,\r\n" + 
    	  		"  \"has_projects\": true,\r\n" + 
    	  		"  \"has_wiki\":true\r\n" + 
    	  		"}";      }
      
      public static String updateRepo() {
    	  return "";
      }
     

}
