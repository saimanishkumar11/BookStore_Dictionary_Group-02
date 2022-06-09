package BookStrore;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteBook {
  @Test
  public void f() {
	  String userId ="b5d21111-1b5f-4644-b32c-717a98a185cf";
	    RestAssured.baseURI = "https://bookstore.toolsqa.com";
	    RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
	    
	    //Calling the Delete API with request body
	    Response response = httpRequest.body("{  \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Books?UserId=b5d21111-1b5f-4644-b32c-717a98a185cf");

	 

	    //Fetching the response code from the request and validating the same
	    System.out.println("The response code - " +response.getStatusCode());
	    Assert.assertEquals(response.getStatusCode(),401);
  }
}
