package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class utils {
	
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		
		if(req ==null) {
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	
	req = new RequestSpecBuilder().setBaseUri(fetchdatafromproperties("Baseurl"))
			
			.addFilter(RequestLoggingFilter.logRequestTo(log))
	         .addFilter(ResponseLoggingFilter.logResponseTo(log))
	         .setContentType(ContentType.JSON).build();
			
	
	return req;
		}
		return req;

}
	
	
	public static String fetchdatafromproperties(String key) throws IOException {
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\banerjee.shubhajyoti\\new-eclipse-workspace - Copy\\LatestRestAssuredPracticeCode\\src\\test\\java\\resources\\global.properties");
		
		Properties prop = new Properties();
		
		prop.load(fs);
		
		return prop.getProperty(key);
	
		
		
			
			
			
			
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}