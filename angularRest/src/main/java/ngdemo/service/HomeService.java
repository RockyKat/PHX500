package ngdemo.service;

import ngdemo.domain.Home;
import ngdemo.tools.console.StartUp;

public class HomeService {

    public Home getDefaultHome() {
        Home home = new Home();
        home.setFirstName("PHX DEMO");
        home.setLastName("PHX swap list.");
        home.setBmp("phx.jpeg");
        
        writeCosoleToFile();
        return home;
    }
    public void writeCosoleToFile()
    {
    	StartUp start = new StartUp();
    	System.out.println("Rusty Metal Batman! I can't believe this was so simple!");
    	System.err.println("I too you Robin.");
    	
    	
    }
}