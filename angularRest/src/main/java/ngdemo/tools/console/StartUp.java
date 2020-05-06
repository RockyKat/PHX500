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
	String logFileContent;

    public StartUp() {
		try 
		{
//			if(tempFile == null)
//			{
//				createTempFileWithDir();
//			}
		
    		String x = new File(".").getAbsolutePath(); 
    		logFile = x + "stdout.log";
    		
//    		FileOutputStream fout= new FileOutputStream(tempFile.toString());
//    		FileOutputStream ferr= new FileOutputStream(tempFile.toString());
    		FileOutputStream fout= new FileOutputStream("stdout.log");
    		FileOutputStream ferr= new FileOutputStream("stderr.log");
    		
    		MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);
    		MultiOutputStream multiErr= new MultiOutputStream(System.err, ferr);
    		
    		PrintStream stdout= new PrintStream(multiOut);
    		PrintStream stderr= new PrintStream(multiErr);
    		
    		System.setOut(stdout);
    		System.setErr(stderr);
    		
        	System.err.println("Console File Path:" + x + "stdout.log");
        	System.err.println("ConsoleTEST:" + "Ready to read file.");
        	System.out.println("CONSOLE:     ");


        	//System.out.println("Path:" + tempFile.toString());
        	String result = readStdOutLogFile();
//        	System.err.println("READFILE:  " + result);



    	}
    	catch (FileNotFoundException ex)
    	{
    		//Could not create/open the file
    	}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void createTempFileWithDir() throws IOException 
    {
        tempDir = Files.createTempDirectory("tempfiles");
         
        tempFile = Files.createTempFile(tempDir, "tempfiles", ".tmp");
        
        List<String> lines = Arrays.asList("Line1", "Line2");
        Files.write(tempFile, lines, Charset.defaultCharset(), StandardOpenOption.WRITE);
         
        System.err.printf("Wrote text to temporary file %s%n", tempFile.toString());
    }
    
    public String readStdOutLogFile() throws IOException 
    {
    	try
    	{
	        FileInputStream streamInputFile = new FileInputStream("stdout.log");
	        Scanner scanInput = new Scanner(streamInputFile);
	        
	        while(scanInput.hasNext() )
	        {
	        	logFileContent += scanInput.nextLine() + "   ";
	        	
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


