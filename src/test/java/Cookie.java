import  static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.Map;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class Cookie
 {
	@Test(priority=1)
	 void testCookie()
	 {
           given()
		    .when()
		     .get("https://www.google.com/")
		       .then()
		         .cookie("SAPISID","RkMYsiHkorBYZ9HO/AXY9yv7trfwy1Oo-3")

		          .log().all();
	 }    
	 @Test(priority=2)
	 void getCookies()
	 {
		 Response res=(Response) given()
				 .when()
                   .get("https://www.google.com/")
		           ;
		           String cookie_value=res.getCookie("SSID");
		           System.out.println(cookie_value);
		           Map<String,String> cookies=res.getCookies();
		           System.out.println(cookies.keySet());		   
		           System.out.println(cookies.values());
		         

				  
		  
	 }

	  

	  

  

}
