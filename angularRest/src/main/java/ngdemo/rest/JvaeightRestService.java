package ngdemo.rest;

import ngdemo.jvaeight.domain.Jvaeight;
import ngdemo.jvaeight.service.JvaeightService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jvaeight")
public class JvaeightRestService {


     @GET 
     @Produces(MediaType.APPLICATION_JSON)
     public Jvaeight doDemo()
     {
        JvaeightService jservice = new JvaeightService();
        jservice.doDemo();
        return (Jvaeight) null;
      }
}
