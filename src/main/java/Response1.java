import static io.restassured.RestAssured.*;

import static io.restassured.matcher.DetailedCookieMatcher.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Response1
{   
	@Test()
    void t()
    {
		Response res= given()
				.when()
				  .get("https://www.google.com/")
				  ;
        ValidatableResponse v=(ValidatableResponse) ((RequestSpecification) res).then();
		v.time(Matchers.lessThan(1000L));
    }
      @Test()
      void getresponsetime()
      {
    	  Response res=(Response) given()
    			  .when()
    			    .get("https://www.google.com/")
    			    ;
          System.out.print(res.getTime());
    	  
      }
      
}


