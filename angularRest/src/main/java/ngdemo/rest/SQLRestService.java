package ngdemo.rest;

import ngdemo.domain.SQL;
import ngdemo.mysql.DBConnect;
import ngdemo.service.SQLService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

//I'm putting all of my testing of CRUD in here because I don't want to mess
//with front end via C instructions.
//I'll normalize things with him Tuesday.
@Path("/sql")
public class SQLRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SQL getDefaultSQLInJSON() 
    {
        SQLService sqlService = new SQLService();
        
         DBConnect connect = new DBConnect();
		 connect.getData();    		 
		 System.out.println("NEw SQLL");
		 
		 connect.updateData();
		 
		 System.out.println("MORE NEW SQLL");
		 
		 connect.createARow();
		 System.out.println("CREATED A ROW");
		 
		 connect.deleteARow();
		 System.out.println("DELETED A ROW");
        
        SQL mia = sqlService.getDefaultSQL();
        System.out.println("Returned mia");
        return mia;
    }

    @Path("/update")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public SQL putDefaultSQLFromJson()
    {
    //@Path("/{id}"
    //public Response getAllBooks(@PathParam("id") String bookId,String bookName){
    //return Response.status(200)
    //           .entity("Book id is : " + bookId + " and name is : " + bookName).build();
    	SQLService sqlService = new SQLService();   
    	DBConnect connect = new DBConnect();
    	connect.updateData();
    	
    	 return sqlService.getDefaultSQL();
    }
}
