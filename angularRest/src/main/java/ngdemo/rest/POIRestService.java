package ngdemo.rest;

import ngdemo.tools.console.StartUp;
import ngdemo.poi.service.POIService;
import ngdemo.poi.domain.POI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poi")
public class POIRestService {
	
	// Duplicate of my original demo. Does all CRUD ops.
	   @GET
		@Path("/demo")
	    @Produces(MediaType.APPLICATION_JSON)
	    public POI getDefaultSQLInJSON() 
	    {		   		   
	    	int indexType = 1;
	    	StartUp start = new StartUp(indexType);
		   
	        POIService poiService = new POIService();
	        
	        //phxpoiService.doDemoWrite();
	        poiService.doDemoRead();
	        poiService.ReadExcelFormula();
	        poiService.readPowerPoiint();
	        
	        POI poi = poiService.getDefaultPOI(start, indexType); 
	        System.out.println("PHXPOIRestService lastname:  " + poi.getLastName());
	        //System.out.println("Returned miaa");
	        return poi;	        
	      
	    }
}