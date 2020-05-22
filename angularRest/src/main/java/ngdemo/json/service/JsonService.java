package ngdemo.json.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONML;
import org.json.JSONStringer;
import org.json.CDL;
import org.json.JSONTokener;
import org.json.Cookie;

import ngdemo.json.domain.Json;
import ngdemo.tools.console.StartUp;

import org.json.HTTP;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.List;


public class JsonService
{
	StartUp startUpLog;
	 int indexType;
	 String strOutLog = null;
  public void testJSONArray()
  {
	  System.out.println("\nTESTING JSONArray");
      JSONArray list = new JSONArray();

      list.put("foo");
      list.put(new Integer(100));
      list.put(new Double(1000.21));
      list.put(new Boolean(true));
      list.put(JSONObject.NULL);

      System.out.println("JSONArray: ");
      System.out.println(list);
   }
  
  public void testJSONXMLConversion()
	    {
	      System.out.println("\nTESTING XML/JSON CONVERSION");
	      JSONArray list = new JSONArray();
	      list.put("name");
	      list.put("Robert");     

	      System.out.println("XML from a JSONArray: ");
	      String xml = JSONML.toString(list);
	      System.out.println(xml);

	      System.out.println("JSONArray from a XML: ");
	      list = JSONML.toJSONArray(xml);
	      System.out.println(list);

	      System.out.println("JSONObject from a XML: ");
	      JSONObject object = JSONML.toJSONObject(xml);
	      System.out.println(object);

	      System.out.println("XML from a JSONObject: ");
	      xml = JSONML.toString(object);
	      System.out.println(xml);
	   }
  
  public void testJSONObject ()
  {
	  	  System.out.println("\nTESTING JSONObject");
	      JSONObject jsonObject = new JSONObject();
	      jsonObject.put("Name", "Robert");
	      jsonObject.put("ID", 1);
	      jsonObject.put("Fees", new Double(1000.21));
	      jsonObject.put("Active", new Boolean(true));
	      jsonObject.put("Other Details", JSONObject.NULL);

	      JSONArray list = new JSONArray();
	      list.put("foo");
	      list.put(new Integer(100));
	      jsonObject.put("list",list);
	      System.out.println(jsonObject);
	   }
  
  public void testJSONStringer (){
	     System.out.println("\nTEST JSONSTRINGER OBJECT");
	      String jsonText = new JSONStringer()
	         .object()
	         .key("Name")
	         .value("Robert")                            
	         .endObject()                       
	         .toString();
	      System.out.println(jsonText);

	      jsonText = new JSONStringer()
	         .array()
	         .value("Robert")      
	         .value("Julia")      
	         .value("Dan")
	         .endArray()                       
	         .toString();
	      System.out.println(jsonText);

	      jsonText = new JSONStringer()
	         .array()
	         .value("Robert")      
	         .value("Julia")      
	         .value("Dan")
	         .object()
	         .key("Name")
	         .value("Robert")                            
	         .endObject()  
	         .endArray()             
	         .toString();
	      System.out.println(jsonText);
	   }
  
  public void testCDLJSONInterface ()
  {
      String csvData = "INDIA, UK, USA";
      System.out.println("\nTESTING JSON/CDL INTERFACE");
      System.out.println("TEST Case 1: CSV to JSON Array");
      JSONArray jsonArray = CDL.rowToJSONArray(new JSONTokener(csvData));        
      System.out.println(jsonArray);

      System.out.println("TEST Case 2: JSONArray to CSV");        
      System.out.println(CDL.rowToString(jsonArray));

      System.out.println("TEST Case 3: CSV to JSONArray of Objects");
      csvData = "empId, name, age \n" +
         "1, Mark, 22 \n" +
         "2, Robert, 35 \n" +
         "3, Julia, 18";
      System.out.println(CDL.toJSONArray(csvData));

      System.out.println("TEST Case 4: CSV without header");        
      jsonArray = new JSONArray();
      jsonArray.put("empId");
      jsonArray.put("name");
      jsonArray.put("age");
      csvData = "1, Mark, 22 \n" + "2, Robert, 35 \n" + "3, Julia, 18";
      System.out.println(CDL.toJSONArray(jsonArray,csvData));
   }
  
  public void testReadWebPageAsString()
  {
	  String pageText = null;
	  try
	  {
	  URL url = new URL("https://horstmann.com");
	  
	  URLConnection conn = url.openConnection();
	  BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
	  pageText = reader.lines().collect(Collectors.joining("\n"));
	  JSONObject jobj = new JSONObject(pageText);
	  System.out.println(jobj);
	  }
	  catch (Exception excp)
	  {
		  System.err.print(excp.getStackTrace());
	  }
  }
  
  public void gimmeCookies()
  {
	  String bigString = null;
	  try
	  {
	     URLConnection connection = new URL("http://google.com").openConnection();
	     List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
	     System.out.println("Number of cookies found :"+cookies.size());
	     for (int count = 0; count < cookies.size(); count++)
	     {
	        bigString += cookies.get(count);	 
	     }
	     
	     System.out.println(bigString);
	     JSONObject jsonObject = Cookie.toJSONObject(cookies.get(0));
	     System.out.println("WRITING AS JSONOBJECT");
	     System.out.println(jsonObject);
	   
	  
	  }
	  catch (Exception excp)
	  {
		  excp.printStackTrace();	  
	  }
   }
  
  public Json getDefaultJSON(StartUp start, int index) {
    	
      startUpLog = start;
     	indexType = index;

     	try 
     	{
 			strOutLog = startUpLog.readStdOutLogFile(indexType);
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
     	
         Json jsonObj = new Json();
         jsonObj.setFirstname("JSON 2014 Library");
         jsonObj.setLastname("Demo JSON Java Library.");
         jsonObj.setBmp("drools.png");
         jsonObj.setStrOutLog(strOutLog);

         return jsonObj;
     }
}
