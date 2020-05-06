package ngdemo.home.service;

import java.io.IOException;

import ngdemo.home.domain.Home;
import ngdemo.tools.console.StartUp;

public class HomeService {

    public Home getDefaultHome() {
    	
    	String strOutLog;
    	
        strOutLog = writeCosoleToFile();
    	
        Home home = new Home();
        home.setFirstName("PHX DEMO");
        home.setLastName("PHX swap list.");
        home.setBmp("phx.jpeg");
        home.setStrOutLog(strOutLog);
        
    	System.out.println("HomeService:  ");

        
        return home;
    }
    public String writeCosoleToFile()
    {
    	StartUp start = new StartUp();
    	System.err.println("HomeService:  ");
		try {
	    	String index;
			index = start.readStdOutLogFile();
			return index;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    	
    }
}