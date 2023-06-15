package test_class;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_method.common_method_Patch_Api;
import common_method.common_method_utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import request_repository.PatchRequestRepository;

public class PatchTc1 {

	@Test(priority=1,description="PATCH-API VALIDATION")
	@Description ("PATCH-API-validate responsebody parameter")
    @Severity(SeverityLevel.MINOR)

	public static void orchestrator() throws IOException
	{    
		String responsebody = "" ;
		int responseStatuscode = 0;
		String baseUri = PatchRequestRepository.baseUri();
		String resource = PatchRequestRepository.resource();
		String requestbody =PatchRequestRepository.PatchrequestTc1();
		System.out.println("Requestbody\n\n"+requestbody );
		
		for(int i=0 ; i<5 ; i++) 
        {
		 responseStatuscode = common_method_Patch_Api.resstatuscodeExtractor(baseUri, resource, requestbody);	
          if (responseStatuscode == 200)
		  {
			responsebody = common_method_Patch_Api.responseBodyExtractor(baseUri, resource, requestbody);
			responseBodyValidator(requestbody,responsebody);
			break;
	      }
          else
          {
	  System.out.println("correct status code is not found in the iteration " + i);
          }
        } 
		common_method_utilities.evidenceFileCreator("PatchTc1",requestbody,responsebody);
		//Assert.assertEquals(responseStatuscode, 201);
		
     }

    public static void responseBodyValidator(String requestbody,String responsebody)
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
		String actual_date = res_updatedAt.substring(0,10);
		String current_date = LocalDate.now().toString(); // Create a date object
		Assert.assertEquals(actual_date, current_date);
		System.out.println("responsebody\n\n"+responsebody );
		System.out.println("resdate:\n\n"+ actual_date + "\n\ncurrent_date\n\n"+ current_date );

	}

}
