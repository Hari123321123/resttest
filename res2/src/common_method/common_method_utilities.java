package common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class common_method_utilities {

	public static void evidenceFileCreator(String filename, String requestBody, String responseBody) throws IOException 
	
	{
		File newTextFile = new File("\\C:\\Users\\admin\\restassuredmethodsreports\\"+ filename+".txt");
		
		if (newTextFile.createNewFile())
			
		{
			FileWriter DataWriter= new FileWriter(newTextFile);
			DataWriter.write("Requestbody is :\n"+requestBody+"\n\n");
			
			DataWriter.write("Responsebody is :\n" + responseBody+"\n\n");
            DataWriter.close();
            System.out.println("request and response saved "+newTextFile.getName());
	      }
		else
			
		{
			System.out.println(newTextFile.getName()+"File already exist take backup of it  ");
		}
	}
}