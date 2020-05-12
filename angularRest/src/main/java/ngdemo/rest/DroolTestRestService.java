//Calls the Service class to do the real work
package ngdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.drooltest.domain.DroolTest;
import ngdemo.drooltest.service.DroolTestService;



@Path("/drool")
public class DroolTestRestService {
	
	
    @GET
	@Path("/demo")
    @Produces(MediaType.APPLICATION_JSON)
    public DroolTest getDefaultSQLInJSON() 
    {
       DroolTestService droolService = new DroolTestService();
       droolService.executeDrools();
    	
       return (DroolTest) null;
    }
			
	
}