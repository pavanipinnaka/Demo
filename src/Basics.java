import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		given().
			param("location","-33.8670522,151.1957362").
			param("radius","500").
			param("key", "AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		when().
			get("/maps/api/place/nearbysearch/json").
		then().
			assertThat().statusCode(200).
			and().contentType(ContentType.JSON).
			and().body("results[0].name",equalTo("Sydney"));
	}

}

/*
given()
	Request Headers
	Parameters
	Request cookies
	body
when()
	get(resource)
	post(resource)
	put(resource)
then()
	assertions to make sure we are getting correct response
extract()
*/



