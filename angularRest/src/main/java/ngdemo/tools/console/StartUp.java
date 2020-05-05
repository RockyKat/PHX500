package ngdemo.tools.console;

import java.io.File;
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

import ngdemo.tools.console.MultiOutputStream;

public class StartUp {
	Path tempDir;
	Path tempFile;

    public StartUp() {
		try 
		{
			if(tempFile == null)
			{
				createTempFileWithDir();
			}
		
    		String x = new File(".").getAbsolutePath(); 
    		FileOutputStream fout= new FileOutputStream(tempFile.toString());
    		FileOutputStream ferr= new FileOutputStream(tempFile.toString());
    		
    		MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);
    		MultiOutputStream multiErr= new MultiOutputStream(System.err, ferr);
    		
    		PrintStream stdout= new PrintStream(multiOut);
    		PrintStream stderr= new PrintStream(multiErr);
    		
    		System.setOut(stdout);
    		System.setErr(stderr);
    		
        	System.out.println("Console File Path:" + x + "stdout.log");
        	System.out.println("Path:" + tempFile.toString());


    	}
    	catch (FileNotFoundException ex)
    	{
    		//Could not create/open the file
    	}
		catch (IOException e) 
		{
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
         
        System.out.printf("Wrote text to temporary file %s%n", tempFile.toString());
    }
}


