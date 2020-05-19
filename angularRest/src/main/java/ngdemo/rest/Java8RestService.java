package ngdemo.rest;

import ngdemo.jvaeight.domain.Jvaeight;
import ngdemo.jvaeight.service.JvaeightService;
import ngdemo.tools.console.StartUp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/java8")
public class Java8RestService {

     @GET 
     @Produces(MediaType.APPLICATION_JSON)
     public Jvaeight doDemo()
     {
        int indexType = 1;
        String strOutLog = null;
        StartUp start = new StartUp(indexType);
        	
        // SETUP TEMP PRINT FILE
    	StartUp startUpLog = new StartUp(indexType);
    	System.out.println("JAVA EIGHT SERVICE READ:");
    	 
        JvaeightService jservice = new JvaeightService();
        jservice.doDemo();
        Jvaeight mia = jservice.getDefaultSQL(start, indexType); 
        
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
