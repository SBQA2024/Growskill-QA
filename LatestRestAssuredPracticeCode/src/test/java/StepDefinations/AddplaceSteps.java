package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.SerializePayload;
import pojo.lOCATION;
import resources.TestDataBuilder;
import resources.utils;

import static io.restassured.RestAssured.given;


import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddplaceSteps extends utils {
	
	   RequestSpecification req;
	   ResponseSpecification res;
	   Response response;
	   
	   TestDataBuilder add = new TestDataBuilder();
	

	   @Given("Add place payload with {string} {string} {string}")
	   public void add_place_payload_with(String name, String phone_number, String address) throws IOException {
	     
       
       res = new ResponseSpecBuilder().expectStatusCode(200).build();
		
		
		
	req= given().spec(requestSpecification()).body(add.AddAPIPayload(name, phone_number, address)).queryParam("key", "qaclick123");
	
	}
	
	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {
		
		response= req.when().post("maps/api/place/add/json")
				
				 .then().spec(res).extract().response();
				 
	    
	
	}
	@Then("API call get success with status code {string}")
	public void api_call_get_success_with_status_code(String string) {
		
		assertEquals(response.getStatusCode(),200);
		
		
	  
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String KeyValue, String ExpectedValue) {
	    
		JsonPath js=new JsonPath(response.asString());
		
		System.out.println(response.asString());
		
		
		
		assertEquals(js.get(KeyValue).toString(),ExpectedValue);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
