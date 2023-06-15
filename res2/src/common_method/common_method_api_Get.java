package common_method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
public class common_method_api_Get {
	
	

public static int resstatuscodeExtractor(String baseUri,String resource,String requestBody)
{
RestAssured.baseURI =baseUri;
	int responseStatuscode =given().header("Content-Type","application/json").body(requestBody).when().get(resource).then()
			.extract().statusCode();
	return responseStatuscode;
}

public static String responseBodyExtractor(String baseUri, String resource, String requestBody) {
	// TODO Auto-generated method stub
 String  responsebody =given().header("Content-Type","application/json").body(requestBody).when().get(resource).then()
			.extract().response().asString();
return  responsebody;
}


}




