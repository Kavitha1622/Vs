import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class TestHeader 
{
    @Test(priority=1)
    void testheader()
    {
    	given()
    	 .when()
    	   .get("https://www.google.com/")
    	     .then()
    	       .header("Content-Type", "text/html; charset=ISO-8859-1") ;   }
    @Test(priority=2)
    void getheader()
    {
    	Response name=given()
    	 .when()
    	 .get("https://www.google.com/"); 
    	  String headerValue=name.getHeader("Content-Type");
    	   System.out.println(headerValue);
    	   Headers h=name.getHeaders();
    	   for(Header age:h)
    	   {
    		   System.out.println(age.getName()+age.getValue());
    		   
    	   }
    }
}
