package ngdemo.home.service;

import java.io.IOException;

import ngdemo.home.domain.Home;
import ngdemo.tools.console.StartUp;

public class HomeService {
	StartUp startUpLog;
	int indexType;


    public Home getDefaultHome(StartUp start,int index) {
    	startUpLog = start;
    	indexType = index;
    	String strOutLog = null;
    	try 
    	{
			strOutLog = startUpLog.readStdOutLogFile(indexType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

        Home home = new Home();
        home.setFirstName("PHX DEMO");
        home.setLastName("PHX swap list.");
        home.setBmp("phx.jpeg");
        home.setStrOutLog(strOutLog);
        

        
        return home;
    }
   
}