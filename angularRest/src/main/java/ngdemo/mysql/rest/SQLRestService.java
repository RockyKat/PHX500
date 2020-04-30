package ngdemo.mysql.rest;

import ngdemo.domain.SQL;
import ngdemo.service.SQLService;
import ngdemo.mysql.DBConnect;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/sql")
public class SQLRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SQL getDefaultSQLInJSON() 
    {
        SQLService sqlService = new SQLService();
        
        DBConnect connect = new DBConnect();
		 connect.getData();      
        
        return sqlService.getDefaultSQL();
        
        //I'm going to add the access to DB sakila here just for test.
    }
}
