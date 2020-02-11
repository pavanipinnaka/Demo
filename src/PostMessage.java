import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostMessage {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://216.10245.166";
		
		given().
		queryParam("key","qaclick123").
		body("");
		
	}

}
