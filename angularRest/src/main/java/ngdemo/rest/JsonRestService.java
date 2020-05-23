package ngdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.tools.console.StartUp;
import ngdemo.json.domain.Json;
import ngdemo.json.service.JsonService;

@Path("/json")
public class JsonRestService {
	
    @GET
	@Path("/demo")
    @Produces(MediaType.APPLICATION_JSON)
    public Json getDefaultDroolStuffInJSON() 
    {
        int indexType = 1;
    	StartUp start = new StartUp(indexType);   	
    	
       JsonService jsonService = new JsonService();
       jsonService.testJSONCookies();
       jsonService.testJSONHTTPHeaders();
       
       Json mia = jsonService.getDefaultJSON(start, indexType); 
       System.out.println("JsonService lastname:  " + mia.getLastname());
    	
       return mia;
    }
			
	
}