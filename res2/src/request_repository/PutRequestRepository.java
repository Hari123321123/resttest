package request_repository;

import java.io.IOException;
import java.util.ArrayList;

import common_method.getdata;
import common_method.getdata3;

public class PutRequestRepository {
public static String baseUri()
{
	String baseUri="https://reqres.in/";
return baseUri;
}
public static String resource()
{
	String resource="api/users/2";
return resource;
}

public static String PutrequestTc1() throws IOException
{
	ArrayList<String> data=getdata.getDataExcel("put_data","tc_1");

	System.out.println(data);
	String Name =data.get(2);
	String Job =data.get(3);

String requestBody="{\r\n"
		+ "    \"name\": \""+Name+"\",\r\n"
		+ "    \"job\": \""+Job+"\"\r\n"
		+ "}";
return requestBody;
}


}