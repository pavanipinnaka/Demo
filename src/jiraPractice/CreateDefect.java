package jiraPractice;

import static io.restassured.RestAssured.given;
import org.testng.annotations.*;

import files.ReuseableMethods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateDefect {
	
	@Test
	public void jiraAPI() {
		//Creating the Session
		System.out.println("1");
		String sessionKey = ReuseableMethods.getSessionKEY();
		Response res = given()
			.header("Content-Type", "application/json")
			.header("Cookie", "JSESSIONID="+ sessionKey)
			.body("{\"fields\": {\"project\": {\"key\": \"SP\"	},\"summary\": \"Creating defect for Sample Project\",\"description\": \"Creating my first Bug\",\"issuetype\": {	\"name\": \"Bug\" } } }")
		.when()
			.post("/api/2/issue")
		.then()
			.statusCode(201)
			.extract()
			.response();
			
		JsonPath js = ReuseableMethods.rawToJson(res);
		String ID = js.get("id");
		System.out.println("decfect ID -- " + ID);
		
	}
}
