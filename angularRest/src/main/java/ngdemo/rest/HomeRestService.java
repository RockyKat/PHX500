package ngdemo.rest;

import ngdemo.home.domain.Home;
import ngdemo.home.service.HomeService;
import ngdemo.tools.console.StartUp;

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
    	int indexType = 1;
    	StartUp start = new StartUp(indexType);
        HomeService homeService = new HomeService();
		System.out.println("HOME");
		System.out.println("HOME SERVICE:");


        return homeService.getDefaultHome(start, indexType);
    }
}