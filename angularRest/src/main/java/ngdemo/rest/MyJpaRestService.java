package ngdemo.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.myjpa.service.*;
import ngdemo.myjpa.domain.MyJpa;
import ngdemo.tools.console.StartUp;

@Path("/jpa")
public class MyJpaRestService {

@GET
@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)	
 public MyJpa MyJpaDemoAll()
 {
	
	int indexType = 1;
	StartUp start = new StartUp(indexType);	
	
    MyJpaService myJpaService = new MyJpaService();
    myJpaService.insertEntity();
    myJpaService.findEntity();
    myJpaService.updateEntity();
    myJpaService.removeEntity();
    
    MyJpa myJpa = myJpaService.getDefaultJPA(start, indexType); 
    return myJpa;
 }
}