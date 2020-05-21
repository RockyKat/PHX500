package ngdemo.rest;

import ngdemo.tools.console.StartUp;
import ngdemo.phxpoi.service.PHXPOIService;
import ngdemo.phxpoi.domain.PHXPOI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poi")
public class PHXPOIRestService {
	
	// Duplicate of my original demo. Does all CRUD ops.
	   @GET
		@Path("/demo")
	    @Produces(MediaType.APPLICATION_JSON)
	    public PHXPOI getDefaultSQLInJSON() 
	    {		   		   
	    	int indexType = 1;
	    	StartUp start = new StartUp(indexType);
		   
	        PHXPOIService phxpoiService = new PHXPOIService();
	        
	        //phxpoiService.doDemoWrite();
	        phxpoiService.doDemoRead();
	        phxpoiService.ReadExcelFormula();
	        
	        PHXPOI mia = phxpoiService.getDefaultPOI(start, indexType); 
	        System.out.println("PHXPOIRestService lastname:  " + mia.getLastName());
	        //System.out.println("Returned miaa");
	        return mia;	        
	      
	    }
}