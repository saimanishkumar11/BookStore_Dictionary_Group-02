package Accountnegative;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AddNewUserWrongUN {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://bookstore.toolsqa.com/Account";
	    RequestSpecification httpRequest = RestAssured.given();
	    
	    httpRequest.header("Content-Type", "application/json"); 
	      
	    JSONObject requestParams = new JSONObject();
	    httpRequest.body(requestParams.toJSONString()); 
	    requestParams.put("userName", "Rosha"); 
	    requestParams.put("password", "Roshani@123"); 
	    
	    Response response = httpRequest.post("/v1/User"); 
	    ResponseBody body = response.getBody();
	    
	    
	    System.out.println("The status received: " + response.statusLine());
	    System.out.println(body.asString());
	    
	    JsonPath jsonPathEvaluator = response.jsonPath();
  }
}
