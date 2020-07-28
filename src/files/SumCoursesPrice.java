package files;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumCoursesPrice {

    //Verify if Sum of all Course prices matches with Purchase Amount
	@Test
	public void sumPrice() {
		int sum=0;
		JsonPath js=new JsonPath(payload1.coursePrice());
	       int count=js.getInt("courses.size()");
	       for(int i=0;i<count;i++) {
	    	int price=js.get("courses["+i+"].price");
	    	int copies=js.get("courses["+i+"].copies");
	    	int amount=price*copies;
	    	System.out.println(amount);
	    	sum=sum+amount;
	       }
	       System.out.println(sum);
	  int prchaseamount=js.get("dashboard.purchaseAmount");
	  System.out.println(prchaseamount);
	  Assert.assertEquals(sum, prchaseamount);

		
	}	
	}


