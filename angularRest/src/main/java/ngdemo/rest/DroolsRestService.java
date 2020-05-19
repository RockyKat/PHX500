//Calls the Service class to do the real work
package ngdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.drools.domain.Drools;
import ngdemo.drools.service.DroolsService;
import ngdemo.tools.console.StartUp;



@Path("/drools")
public class DroolsRestService {
	
	
    @GET
	@Path("/demo")
    @Produces(MediaType.APPLICATION_JSON)
    public  Drools getDefaultDroolStuffInJSON() 
    {
        int indexType = 1;
    	StartUp start = new StartUp(indexType);   	
    	
       DroolsService droolsService = new DroolsService();
       droolsService.executeDrools();
       
       Drools mia = droolsService.getDefaultDrools(start, indexType); 
       System.out.println("DroolsService lastname:  " + mia.getLastName());
    	
       return mia;
    }
			
	
}