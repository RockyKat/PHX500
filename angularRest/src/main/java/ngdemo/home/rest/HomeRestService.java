package ngdemo.rest;

import ngdemo.domain.Home;
import ngdemo.service.HomeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/home")
public class HomeRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Home getDefaultHomeInJSON() 
    {
        HomeService homeService = new HomeService();
        return homeService.getDefaultHome();
    }
}