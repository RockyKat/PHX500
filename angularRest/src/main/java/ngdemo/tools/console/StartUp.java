package ngdemo.tools.console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ngdemo.tools.console.MultiOutputStream;

public class StartUp {
	Path tempDir;
	Path tempFile;
	String logFile;
	String logFileContent = "";

    public StartUp(int index) {
		try 
		{
			if(index == 1)
			{
				if(tempFile == null)
				{
					createTempFileWithDir();
				}
			}
		
    		String x = new File(".").getAbsolutePath(); 
    		logFile = x + "stdout.log";
    		FileOutputStream fout;
    		FileOutputStream ferr;
    		
    		if(index == 1)
    		{
    			 fout= new FileOutputStream(tempFile.toString());
    			 ferr= new FileOutputStream(tempFile.toString());
    		}
    		else
    		{
    			 fout= new FileOutputStream("stdout.log");
    			 ferr= new FileOutputStream("stderr.log");
    		}
    		
    		MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);
    		MultiOutputStream multiErr= new MultiOutputStream(System.err, ferr);
    		
    		PrintStream stdout= new PrintStream(multiOut);
    		PrintStream stderr= new PrintStream(multiErr);
    		
    		System.setOut(stdout);
    		System.setErr(stderr);
    		
        	System.err.println("Console File:" + tempFile.toString());
        	System.err.println("STARTUP LOG:");


        	//System.out.println("Path:" + tempFile.toString());
        	String result = readStdOutLogFile(index);
//        	System.err.println("READFILE:  " + result);



    	}
    	catch (FileNotFoundException ex)
    	{
    		//Could not create/open the file
    	}

		catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getStackTrace());
		}
    }
    
    private void createTempFileWithDir() throws IOException 
    {
        tempDir  = Files.createTempDirectory("PHXDEMO");
        tempFile = Files.createTempFile     (tempDir, "PhxDemoTmp", ".tmp");        
        
        List<String> lines = Arrays.asList("Line1", "Line2");
        Files.write(tempFile, lines, Charset.defaultCharset(),StandardOpenOption.WRITE,StandardOpenOption.DELETE_ON_CLOSE);         
    }
    

    public String readStdOutLogFile(int index) throws IOException 
    {
    	try
    	{
    		FileInputStream streamInputFile;
    		if(index == 1)
    		{
    	        streamInputFile = new FileInputStream(tempFile.toString());
    		}
    		else
    		{
    			streamInputFile = new FileInputStream("stdout.log");
    		}
	        Scanner scanInput = new Scanner(streamInputFile);
	        
	        while(scanInput.hasNext() )
	        {
	        	String nextIndex;
	        	nextIndex = scanInput.nextLine();
	        	logFileContent += nextIndex+ "\r";
	        	
	        }
	        streamInputFile.close();
	        scanInput.close();
        
	        return logFileContent; 
    	}
    	catch (FileNotFoundException ex)
    	{
    		//Could not create/open the file
    	}
		return null;
    }
}


