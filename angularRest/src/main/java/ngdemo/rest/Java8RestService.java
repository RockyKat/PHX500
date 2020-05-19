package ngdemo.rest;

import ngdemo.java8.domain.Java8;
import ngdemo.java8.service.Java8Service;
import ngdemo.tools.console.StartUp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/java8")
public class Java8RestService {

     @GET 
     @Produces(MediaType.APPLICATION_JSON)
     public Java8 doDemo()
     {
        int indexType = 1;
        String strOutLog = null;
        StartUp start = new StartUp(indexType);
        	
        // SETUP TEMP PRINT FILE
    	StartUp startUpLog = new StartUp(indexType);
    	System.out.println("JAVA EIGHT SERVICE READ:");
    	 
        Java8Service jservice = new Java8Service();
        jservice.doDemo();
        Java8 mia = jservice.getDefaultSQL(start, indexType); 
        
        // READ LOG FILE
    	try 
    	{
			strOutLog = startUpLog.readStdOutLogFile(indexType);
	    	//resultGet.setJavEightSwapLog(strOutLog);

		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}

    	return mia;
      }
}
