import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
public class Restassured 
{
	int id;
	@Test(priority=5)
   public void getalluser()
   {
    System.out.println("https://reqres.in/api/users?page=2");
      given()
      .contentType("Application/json")
        .when()
          .get("https://reqres.in/api/users?page=2")
            .then()
               .statusCode(200)
                   .log().all();
    }
	@Test(priority=2)
	   public void getuser()
	   {
	    System.out.println("https://reqres.in/api/users?page=2");
	     given()
	      .contentType("Application/json")
	        .when()
	          .get("https://reqres.in/api/users/2")
	            .then()
	               .statusCode(200)
	                   .log().all();
	    }
	@Test(priority=1)
	   public void createuser()
	   {
		 HashMap hm=new HashMap();
	     hm.put("name", "k");
		 hm.put("age", "21");
		 id=given()
		  .contentType("Application/json")	 
		   .body(hm)
		     .when()
		      .post("https://reqres.in/api/users")
		        .jsonPath().getInt("id");
		           System.out.println(id);
		}
    @Test(priority=3,dependsOnMethods= {"createuser"})
	    public void updateuser()
	     {
	    	 HashMap hm=new HashMap();
	    	 hm.put("name", "k2");
	    	 hm.put("age", "23");
	    	 given()
	    	  .contentType("application/json")
	    	    .body(hm)
	    	      .when()
	    	        .put("https://reqres.in/api/users/"+id)
	    	           .then()
	    	              .statusCode(200)
	    	                .log().all();
	     }
	 @Test(priority=4)
	     public void deleteuser()
	     {
		     given()
	    	      .when()
	    	        .delete("https://reqres.in/api/users/"+id)
	    	           .then()
	    	              .statusCode(204)
	    	                .log().all();
	     }
	     
}
