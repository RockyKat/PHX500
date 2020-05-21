//Calls the Service class to do the real work
package ngdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ngdemo.hibernate.service.HibernateService;
import ngdemo.hibernate.domain.Hibernate;
import ngdemo.tools.console.StartUp;
@Path("/hibernate")
public class HibernateRestService {
	
	
    @GET
    @Path("/demo")
    @Produces(MediaType.APPLICATION_JSON)
    public Hibernate getDefaultHibStuffInJSON() 
    {
        int indexType = 1;
    	StartUp start = new StartUp(indexType); 
    	
    	HibernateService hibtestService = new HibernateService();
    	hibtestService.TestHibernate();
    	Hibernate mia = hibtestService.getDefaultHibTest(start, indexType); 
    	return mia;
    }
			
	
}