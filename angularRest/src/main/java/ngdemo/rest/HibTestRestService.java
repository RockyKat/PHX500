//Calls the Service class to do the real work
package ngdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ngdemo.hibtest.service.HibTestService;
import ngdemo.hibtest.domain.HibTest;
import ngdemo.phxsql.domain.PHXSQL;
import ngdemo.tools.console.StartUp;
@Path("/hibernate")
public class HibTestRestService {
	
	
    @GET
    @Path("/demo")
    @Produces(MediaType.APPLICATION_JSON)
    public HibTest getDefaultHibStuffInJSON() 
    {
        int indexType = 1;
    	StartUp start = new StartUp(indexType); 
    	
    	HibTestService hibtestService = new HibTestService();
    	// ERROR
    	//hibtestService.TestHibernate();
    	HibTest mia = hibtestService.getDefaultHibTest(start, indexType); 
    	return mia;
    }
			
	
}