package BookStrore;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BooksWithISIBN {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/";
		RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.queryParam("isbn","9781449325862").get("v1/Books/");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
      System.out.println("title: " + jsonPathEvaluator.get("title"));
      
      System.out.println("subTitle: " + jsonPathEvaluator.get("subTitle"));
      
      System.out.println("publish_date " + jsonPathEvaluator.get("publish_date"));
        
      System.out.println("publisher " + jsonPathEvaluator.get("publisher"));

      System.out.println("pages " + jsonPathEvaluator.get("pages"));

      System.out.println("description " + jsonPathEvaluator.get("description"));

      System.out.println("website " + jsonPathEvaluator.get("website"));
  }
}
