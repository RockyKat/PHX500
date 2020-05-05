package ngdemo.tools.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import ngdemo.tools.console.MultiOutputStream;

public class StartUp {

    public StartUp() {
    	try
    	{
    		String x = new File(".").getAbsolutePath(); 
    		FileOutputStream fout= new FileOutputStream("stdout.log");
    		FileOutputStream ferr= new FileOutputStream("stderr.log");
    		
    		MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);
    		MultiOutputStream multiErr= new MultiOutputStream(System.err, ferr);
    		
    		PrintStream stdout= new PrintStream(multiOut);
    		PrintStream stderr= new PrintStream(multiErr);
    		
    		System.setOut(stdout);
    		System.setErr(stderr);
    		
        	System.out.println("Console File Path:" + x + "stdout.log");

    	}
    	catch (FileNotFoundException ex)
    	{
    		//Could not create/open the file
    	}
    }
}