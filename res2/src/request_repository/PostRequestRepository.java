package request_repository;
import java.io.IOException;
import java.util.ArrayList;

import common_method.getdata;

public class PostRequestRepository {
public static String baseUri()
{
	String baseUri="https://reqres.in/";
return baseUri;
}
public static String resource()
{
	String resource="api/users";
return resource;
}

public static String postrequestTc1() throws IOException
{
	ArrayList<String> data=getdata.getDataExcel("post_data","tc_1");
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
