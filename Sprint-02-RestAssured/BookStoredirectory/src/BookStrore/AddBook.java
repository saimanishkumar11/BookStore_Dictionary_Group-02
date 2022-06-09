package BookStrore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AddBook {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore";
	    RequestSpecification httpRequest = RestAssured.given();
	    
	    httpRequest.header("Content-Type", "application/json"); 
	      
	    JSONObject requestParams = new JSONObject();
	    httpRequest.body(requestParams.toJSONString()); 

	    requestParams.put("title", "Origin of species"); 
	    requestParams.put("isbn", "9781449325868"); 
	    requestParams.put("subTitle", "humman anotomy");
	    requestParams.put("author", "darwin");
	    requestParams.put("publish_date", "1");
	    requestParams.put("publisher", "O'Reilly Media");
	    requestParams.put("pages", "978");
	    Response response = httpRequest.post("/v1/Books"); 
	    ResponseBody body = response.getBody();
	    System.out.println("The status received: " + response.statusLine());
	    System.out.println(body.asString());
	    
	    JsonPath jsonPathEvaluator = response.jsonPath();

	    System.out.println("isbn: " + jsonPathEvaluator.get("isbn"));
  }
}
