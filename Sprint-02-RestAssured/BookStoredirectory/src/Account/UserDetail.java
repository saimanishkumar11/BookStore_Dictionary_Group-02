package Account;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class UserDetail {
  @Test
  public void f() {
		
		RestAssured.baseURI = "https://bookstore.toolsqa.com/Account/v1";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("User/b5d21111-1b5f-4644-b32c-717a98a185cf");
		
		io.restassured.http.Headers allHeaders = response.headers(); 
		
		for(Header header : allHeaders) { 
			   System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
			 }
		
		ResponseBody body = response.getBody();
		System.out.println("Response Status is: " + body.asString());
		
		// should get a status code of 200.
				int statusCode = response.getStatusCode();
              System.out.println("print status code......."  + statusCode);
  }
}
