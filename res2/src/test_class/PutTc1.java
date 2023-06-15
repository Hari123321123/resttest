package test_class;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.common_method_Put_Api;
import common_method.common_method_utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import request_repository.PutRequestRepository;

public class PutTc1 {

	@Test(priority=1,description="PUT-API VALIDATION")
	@Description ("PUT-API-validate responsebody parameter")	
	@Severity(SeverityLevel.MINOR)

	public static void orchestrator() throws IOException
	{    
		String responsebody = "" ;
		int responseStatuscode = 0;
		String baseUri = PutRequestRepository.baseUri();
		String resource = PutRequestRepository.resource();
		String requestbody =PutRequestRepository.PutrequestTc1();
		System.out.println("Requestbody\n\n"+requestbody );
		for(int i=0 ; i<5 ; i++) 
        {
		 responseStatuscode = common_method_Put_Api.resstatuscodeExtractor(baseUri, resource, requestbody);	
          if (responseStatuscode == 200)
		  {
			responsebody = common_method_Put_Api.responseBodyExtractor(baseUri, resource, requestbody);
			responseBodyValidator(responsebody,requestbody);
			
			break;
	      }
          else
          {
	  System.out.println("correct status code is not found in the iteration " + i);
          }
        } 
		common_method_utilities.evidenceFileCreator("PutTc1",requestbody,responsebody);
		//Assert.assertEquals(responseStatuscode, 201);
		
     }

    public static void responseBodyValidator(String responsebody ,String requestbody)
	{
		// create jsonPath object to extract responsebody parameters
		JsonPath jsp = new JsonPath(responsebody);

		// extract responsebody parameters
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		
		String res_updatedAt = jsp.getString("updatedAt");
		
		//Extract Requestbody parameters 
		JsonPath req = new JsonPath(requestbody);
		String req_name = req.getString("name");
		String req_job = req.getString("job");

		// validate responsebody parameter
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		
		
		// extract date from createdAt parameter
		String actual_date = res_updatedAt.substring(0, 10);
		String current_date = LocalDate.now().toString(); // Create a date object
		Assert.assertEquals(actual_date, current_date);
		System.out.println("responsebody\n\n"+responsebody );
		System.out.println("resdate:\n\n"+ actual_date + "\n\ncurrent_date\n\n"+ current_date );

	}

}
