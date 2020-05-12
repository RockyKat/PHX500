package ngdemo.rest;

import ngdemo.phxswap.domain.PHXSWAP;
import ngdemo.phxswap.service.PHXSWAPService;
import ngdemo.tools.console.StartUp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/swap")
public class PHXSWAPRestService {

	//I can't see why anybody would use this.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP getDefaultHomeInJSON() 
    {
        PHXSWAPService phxSwapService = new PHXSWAPService();
        return phxSwapService.getDefaultPHXSWAP();
    }
 
    //TESTED.
    //This is the one thing I know he wants for sure...read entire table with JDBC.
    //To make things visually consistent I left the default settings for Home object.
    //CGN
    @GET
    @Path("/readTable")
    @Produces(MediaType.APPLICATION_JSON)
    public String ReadSwapTable()
    {
    	int indexType = 1;
	    StartUp startUpLog = new StartUp(indexType);
	    System.out.println("SWAP");
		System.out.println("SWAP SERVICE READ:");
    	String strOutLog = null;

        PHXSWAPService phxswapService = new PHXSWAPService();
        ResultSet resultGet = phxswapService.getData();    	
	    System.out.println("RETURNED PHXSWAP TABLE");
    	
    	try 
    	{
			strOutLog = startUpLog.readStdOutLogFile(indexType);
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    return strOutLog;

    }
    
    //TESTED
    //create a row in table
    @GET
    @Path("/create/{PackageName}/{CurrentVersion}")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP createARow(@PathParam("PackageName") String PackageName,@PathParam("CurrentVersion") String CurrentVersion)
    {
    	
	    String packageName = PackageName;
		String currentVersion = CurrentVersion;
		PHXSWAPService phxswapService = new PHXSWAPService();
		PHXSWAP myswap = phxswapService.createARow(packageName,currentVersion);
        return myswap;
    }
    
    //TESTED
    @GET
    @Path("/read/{ix}")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP readARow(@PathParam("ix") int primarykey)
    {
    	int primaryKey = primarykey;
    	PHXSWAPService phxswapService = new PHXSWAPService();
    	PHXSWAP myswap = phxswapService.readARow(primaryKey);
    	return myswap;
    }
    
    //TESTED
    @GET
    @Path("/update/{WhichTerm}/{ValueTerm}/{ix}")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP updateARow(@PathParam("WhichTerm") String term, @PathParam("ValueTerm") String value, @PathParam("ix") int primarykey)
    {
        String whichTerm = term;
        String whichValue = value;
        int primaryKey = primarykey;
        PHXSWAPService phxswapService = new PHXSWAPService();
        PHXSWAP myswap = phxswapService.updateARow(whichTerm, whichValue, primaryKey);       		
        
    	return myswap;
    }
    
    @GET
    @Path("/delete/{ix}")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP deleteARow(@PathParam("ix") int privateKey)
    {
    	int privatekey = privateKey;
    	PHXSWAPService phxswapService = new PHXSWAPService();
    	PHXSWAP myswap = phxswapService.deleteARow(privatekey);
    	return (PHXSWAP) null;
    }    
    
}