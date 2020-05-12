//CHECKS JAVA 8 FEATURES. ALL METHODS PUBLIC BECAUSE I MAY 
//WANT TO CALL THEM Individually.
package ngdemo.jvaeight.service;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.net.*;
import java.util.function.BiFunction;  
import javax.script.*;
//Returns results of Java 8 feature tests.

class Arithmetic{  
	   public static int add(int a, int b){  
	   return a+b;  
	   }  
	   public static int multiply(int a, int b) {
		   return a*b;
	   }
	   }  

public class JvaeightService {

   public JvaeightService()
   {
       System.out.println("DOING IT");   	   
   }
   
 
   
   interface MyInterface 
   { 
        void abstract_func(int x,int y); 
    
        default void default_Fun() 
       { 
            System.out.println("This is default interface method"); 
       } 
   } 
   
   public static Optional<Double> inverse(Double x)
   {
      return x == 0 ? Optional.empty() : Optional.of(1 / x);
   }
   
   public static Optional<Double> squareRoot(Double x)
   {
      return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
   }

      
   public void TestLambdas() 
   { 
       //lambda expression
       MyInterface fobj = (int x, int y)->System.out.println(x+y); 
       System.out.println("\nTESTING LAMBDA FEATURE");

       System.out.print("The result = ");
       fobj.abstract_func(5,5); 
       fobj.default_Fun();
       
       String[] planets = new String[]{"Mercury", "Venus", "Earth","Mars",
       		"Jupiter","Saturn","Uranus","Neptune"};
       //System.out.println(Arrays.toString(planets));
       System.out.println("Planets sorted in dictionary order:");
       Arrays.sort(planets);
       System.out.println(Arrays.toString(planets));
       System.out.println("Planets sorted by length via lambda:");
       Arrays.sort(planets, (first,second)->first.length() - second.length());
       System.out.println(Arrays.deepToString(planets));
             
   } 
   
   public void TestForEach()
   {
	   System.out.println("\nTESTING THE FOREACH FEATURE");
	   List<String> subList = new ArrayList<String>();  
       subList.add("Maths");  
       subList.add("English");  
       subList.add("French");  
       subList.add("Sanskrit");
       subList.add("Abacus");
       System.out.println("------------Subject List--------------");  
       subList.forEach(sub -> System.out.println(sub));  
 }  
   
   public void TestOptional()
   {		 
	        String aliceFile = "/com/rule/alice30.txt";	       
	        System.out.println("\nTESTING OPTIONAL CLASS FEATURE");
	        try
	        {
	        InputStream resourceAsStream = getClass().getResourceAsStream(aliceFile);	
	        InputStreamReader isReader = new InputStreamReader(resourceAsStream);
	        //Creating a BufferedReader object
	        BufferedReader reader = new BufferedReader(isReader);
	        StringBuffer sb = new StringBuffer();
	        String str;
	        while((str = reader.readLine())!= null){
	           sb.append(str);
	        }
	        String contents = sb.toString();
	        //contents = new String(Files.readAllBytes(Paths.get("./alice30.txt")));
			List<String> wordList = Arrays.asList(contents.split("\\PL+"));

	         Optional<String> optionalValue = wordList.stream()
	            .filter(s -> s.contains("red"))
	            .findFirst();
	         System.out.println(optionalValue.orElse("No word") + " contains red");

	         Optional<String> optionalString = Optional.empty();
	         String result = optionalString.orElse("N/A");
	         System.out.println("Empty result: " + result);
	         result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
	         System.out.println("Locale result: " + result);
	           // result = optionalString.orElseThrow(IllegalStateException::new);
	            //System.out.println("result: " + result);
	         }
	         catch (Exception t)
	         {
	            t.printStackTrace();
	         }
	      }

   public void methodReferenceTester(int aV, int bV) {  
	   int a = aV;
	   int b = bV;
	   System.out.println("\nTESTING METHOD REFERENCE FEATURE");
	   BiFunction<Integer, Integer, Integer>adder = Arithmetic::add;  
	   int result = adder.apply(a,b);  
	   System.out.print("Addition of "+a+" and "+b+ " = ");
	   System.out.println(result);  
	   BiFunction<Integer, Integer, Integer>multiplier = Arithmetic::multiply;  
	   result = multiplier.apply(a,b);  
	   System.out.print("Multiplication of "+a+" and "+b+ " = ");
	   System.out.println(result);  	   
	   }  	
   
   public void testStreamApi()
   {
   System.out.println("\nTESTING THE STREAM API FEATURE");
   Stream.of("d2", "a2", "b1", "b3", "c")
   .sorted((s1, s2) -> {
       System.out.printf("sorted: %s; %s\n", s1, s2);
       return s1.compareTo(s2);
   })
   .filter(s -> {
       System.out.println("Only strings that start with a: " + s);
       return s.startsWith("a");
   })
   .map(s -> {
       System.out.println("mapped to uppercase: " + s);
       return s.toUpperCase();
   })
   .forEach(s -> System.out.println("forEach: " + s));
   }
   
   public void testLocalDateTime() {
	      System.out.println("\nTESTING THE NEW JAVA DATE TIME API FEATURE");
	      // Get the current date and time
	      LocalDateTime currentTime = LocalDateTime.now();
	      System.out.println("Current DateTime: " + currentTime);
			
	      LocalDate date1 = currentTime.toLocalDate();
	      System.out.println("date1: " + date1);
			
	      Month month = currentTime.getMonth();
	      int day = currentTime.getDayOfMonth();
	      int seconds = currentTime.getSecond();
			
	      System.out.println("Month: " + month +" day: " + day +" seconds: " + seconds);
			
	      LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
	      System.out.println("date2: " + date2);
			
	      //12 december 2014
	      LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
	      System.out.println("date3: " + date3);
			
	      //22 hour 15 minutes
	      LocalTime date4 = LocalTime.of(22, 15);
	      System.out.println("date4: " + date4);
			
	      //parse a string
	      LocalTime date5 = LocalTime.parse("20:15:30");
	      System.out.println("date5: " + date5);
	   }
   
   public void testNashorn()
   {
	   System.out.println("\nTESTING THE NASHORN JAVASCRIPT ENGINE FEATURE");
	   System.out.println("EXECUTING JAVASCRIPT CODE:");
	   System.out.println("function hi(){\nvar a = 'PROSPER'.toLowerCase(); \nmiddle(); \nprint('Live long and ' + a)\n}\n function middle(){\n var b = 1;\nfor(var i=0, max = 5; i<max;i++){\nb++;\n}\n print('b is '+b);\n}\nhi();\n\n");
	   try {
		    ScriptEngineManager factory = new ScriptEngineManager();
		    ScriptEngine engine = factory.getEngineByName("nashorn");
		    engine.eval("function hi(){\nvar a = 'PROSPER'.toLowerCase(); \nmiddle(); \nprint('Live long and ' + a)}\n function middle(){\n var b = 1; for(var i=0, max = 5; i<max;i++){\nb++;\n}\n print('b is '+b);}hi();");
		    } catch (Exception ex) {
		            ex.printStackTrace();
		        }
   }
	
   public void testBase64Coding()
   {
	   System.out.println("\nTESTING THE BASE 64 ENCODE/DECODE FEATURE");
	   Base64.Encoder encoder = Base64.getEncoder();
	   String normalString = "username:password";
	   String encodedString = encoder.encodeToString( 
	           normalString.getBytes(StandardCharsets.UTF_8) );
	   
	   System.out.println("Encoded username:password is "+encodedString);
	   Base64.Decoder decoder = Base64.getDecoder();
	   byte[] decodedByteArray = decoder.decode(encodedString);
	   //Verify the decoded string
	   System.out.println("Original term was "+new String(decodedByteArray));
   }
 
   //Test all parts of Java 8 new features and print output.
   public void doDemo()
   {
	 TestLambdas();
	 TestForEach();
	 TestOptional();
	 methodReferenceTester(7,8);
	 testStreamApi();
	 testLocalDateTime();
	 testNashorn();
	 testBase64Coding();	 
	 System.out.println("\nEND OF JAVA 8 DEMO PROGRAM");
   }
}
   
           