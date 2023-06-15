package common_method;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class common_method_api {
	

public static int resstatuscodeExtractor(String baseUri,String resource,String requestBody)
{
RestAssured.baseURI =baseUri;
	int responseStatuscode =given().header("Content-Type","application/json").body(requestBody).when().post(resource).then()
			.extract().statusCode();
	return responseStatuscode;
}

public static String responseBodyExtractor(String baseUri, String resource, String requestBody) {
	// TODO Auto-generated method stub
 String  responsebody =given().header("Content-Type","application/json").body(requestBody).when().post(resource).then()
			.extract().response().asString();
return  responsebody;
}
}
