package BookStrore;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PutMethod {
  @Test
  public void f() {
	  String userId= "vishwadeep@gmail.com";
	  String isbn ="9781449325865";
	     RestAssured.baseURI = "https://bookstore.toolsqa.com/";
	     RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " )
	             .header("Content-Type", "application/json");

	     
	     Response response = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").put("/Books/9781449325862");

	     System.out.println("The response code - " +response.getStatusCode());
	     Assert.assertEquals(response.getStatusCode(),302);
  }
}
