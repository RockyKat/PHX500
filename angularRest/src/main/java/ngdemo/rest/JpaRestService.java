package ngdemo.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.jpa.service.*;
import ngdemo.jpa.domain.Jpa;
import ngdemo.tools.console.StartUp;

@Path("/jpa")
public class JpaRestService {

@GET
@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)	
 public Jpa MyJpaDemoAll()
 {
	
	int indexType = 1;
	StartUp start = new StartUp(indexType);	
	
    JpaService myJpaService = new JpaService();
    myJpaService.insertEntity();
    myJpaService.findEntity();
    myJpaService.updateEntity();
    myJpaService.removeEntity();
    
    Jpa myJpa = myJpaService.getDefaultJPA(start, indexType); 
    return myJpa;
 }
}