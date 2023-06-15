package test_class;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;


import java.io.IOException;
import common_method.common_method_api_Get;
import common_method.common_method_utilities;
import request_repository.Get_RequestRepository;

public class GetTc1 {
	
	@Test(priority=1,description="GET-API VALIDATION")
	@Description ("GET-API-validate responsebody parameter")
    @Epic("EP001-GET API")
	@Feature("Feature1 : Response parameter validation ")
    @Severity(SeverityLevel.MINOR)
	public static void orchestrator() throws IOException 
	{    
		String responsebody = "" ;
		int responseStatuscode = 0;
		String baseUri = Get_RequestRepository.baseUri();
		String resource = Get_RequestRepository.resource();
		String requestbody = Get_RequestRepository.GetequestTc1();
		System.out.println("Requestbody\n\n"+requestbody );
		for(int i=0 ; i<5 ; i++) 
        {
		 responseStatuscode = common_method_api_Get.resstatuscodeExtractor(baseUri, resource, requestbody);	
          if (responseStatuscode == 200)
		  {
			responsebody = common_method_api_Get.responseBodyExtractor(baseUri, resource, requestbody);
			responseBodyValidator(responsebody);
			
			break;
	      }
          else
          {
	  System.out.println("correct status code is not found in the iteration " + i);
          }
        } 
		common_method_utilities.evidenceFileCreator("GetTc1",requestbody,responsebody);
		//Assert.assertEquals(responseStatuscode, 201);
		
     }
	 public static void responseBodyValidator(String responsebody)
		{
    	
    			
    			JsonPath jsp =new JsonPath(responsebody);
        	    System.out.println("Responsebody \n\n"+ responsebody);

    		    int dataarray_length =jsp.getInt("data.size()");
    	    System.out.println(dataarray_length);
    		  
    	  

    		        //initializing array after declaration  
    		       int id[]= {7,8,9,10,11,12}; 
    		         String First_Name1[]=new String[] {"Michael","Lindsay","Tobias","Byron","George","Rachel"}; 
    		         String Last_name1[]=new String[] {"Lawson","Ferguson","Funke","Fields","Edwards","Howell"};
    		         String Email1[] =new String[] {"michael.lawson@reqres.in","lindsay.ferguson@reqres.in","tobias.funke@reqres.in","byron.fields@reqres.in","george.edwards@reqres.in","rachel.howell@reqres.in"};
    		         String Avtar1[]=new String[]{"https://reqres.in/img/faces/7-image.jpg","https://reqres.in/img/faces/8-image.jpg","https://reqres.in/img/faces/9-image.jpg","https://reqres.in/img/faces/10-image.jpg","https://reqres.in/img/faces/11-image.jpg","https://reqres.in/img/faces/12-image.jpg"};

    		         
    		         int i;
    		         for (i=0; i < dataarray_length; i++)
    		
    	{
    		int res_id=jsp.getInt("data["+i+"].id");
    		String res_fname=jsp.getString("data["+i+"].first_name");
    		String res_lname=jsp.getString("data["+i+"].last_name");
    		String res_email=jsp.getString("data["+i+"].email");
    		String res_avatar=jsp.getString("data["+i+"].avatar");
    	    System.out.println(res_id);
    	    System.out.println(res_fname);
    	    System.out.println(res_lname);
    	    System.out.println(res_email);
    	    System.out.println(res_avatar);
    	    System.out.println(id[i]);

    	    System.out.println(First_Name1[i]);
    	    System.out.println(Last_name1[i]);
    	    System.out.println(Email1[i]);
    	    System.out.println(Avtar1[i]);

    	    
    	   Assert.assertEquals(res_id,id[i]);

    	   Assert.assertEquals(res_fname,First_Name1[i]);
    	   Assert.assertEquals(res_lname,Last_name1[i]);
    	   Assert.assertEquals(res_email,Email1[i]);
    	   Assert.assertEquals(res_avatar,Avtar1[i]);


    	}


    		}

    	


	}


