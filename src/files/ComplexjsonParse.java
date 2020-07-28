package files;

import io.restassured.path.json.JsonPath;

public class ComplexjsonParse {

	public static void main(String[] args) {
		
		JsonPath js=new JsonPath(payload1.coursePrice());
		
	//Print No of courses returned by API
		
       int count=js.getInt("courses.size()");
       System.out.println(count);
       
       //Print Purchase Amount
      int totalAmount= js.getInt("dashboard.purchaseAmount");
      System.out.println(totalAmount);
      
      //Print Title of the first course
     String tittle=js.get("courses[0].title");
     System.out.println(tittle);
     
     //Print All course titles and their respective Prices
     for(int i=0;i<count;i++) {
    String courseTitle=js.get("courses["+i+"].title");
   int coursePrice= js.get("courses["+i+"].price");
     
     System.out.println(courseTitle);
     System.out.println(coursePrice);
     }
     
     //Print no of copies sold by RPA Course
      for(int i=0;i<=count;i++) {
    	    String courseTitle=js.get("courses["+i+"].title");
           if(courseTitle.equalsIgnoreCase("RPA")) {
        	 int copies=js.get("courses["+i+"].copies");
        	    System.out.println(copies);
           break;
           }
      }
      
	}

}
