package Account;

import org.testng.annotations.Test;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
public class DeleteUser {
  @Test
  public void f() {
		//String id="c97ce408-e747-4484-92aa-2bd698de8d43";
	   RestAssured.baseURI = "https://bookstore.toolsqa.com/Account";
	    //RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json");
	    
	    //Calling the Delete API with request body
	   // Response response = httpRequest.delete("https://bookstore.toolsqa.com/Account/v1/User/{"+id+"}");

	    Response response = given()
               .header("Content-type", "application/json")
               .when()
               .delete("/v1/User/c97ce408-e747-4484-92aa-2bd698de8d43")
               .then()
               .extract().response();

	    //Fetching the response code from the request and validating the same
	    System.out.println("The response code - " +response.getStatusCode());
	    Assert.assertEquals(response.getStatusCode(),401);
  }
}
