package files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReuseableMethods {
	
	Properties prop = new Properties();
	
	@BeforeTest
	public void getData() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\WebServices\\Practice-Rest-Assured\\WebServicePractice\\src\\files\\env.properties");
		prop.load(fis);
	}
	
	public static XmlPath rawToXML(Response r)
	{
		String respon=r.asString();
		XmlPath x=new XmlPath(respon);
		return x;
	}
	
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}
	
	public static String getSessionKEY() {
		RestAssured.baseURI = "http://localhost:8080/rest";
		
		Response res = 
		given()
			.header("Content-Type", "application/json")
			.body("{ \"username\": \"Pavani\", \"password\": \"Jira@123\" }")
		.when()
			.post("/auth/1/session")
		.then()
			.statusCode(200)
			.extract().response();
		
		JsonPath js = ReuseableMethods.rawToJson(res);
		String ID = js.get("ID");
		System.out.println( "------" + ID);
		System.out.println("++++++" + res.getSessionId());
		return res.getSessionId();
	}
	
	
}
