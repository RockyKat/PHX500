package ngdemo.json.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONML;
import org.json.JSONStringer;
import org.json.CDL;
import org.json.JSONTokener;
import org.json.Cookie;
import java.net.HttpURLConnection;

import ngdemo.json.domain.Json;
import ngdemo.tools.console.StartUp;

import org.json.HTTP;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
 


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

      System.out.println("String converted to JSONArray: ");
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
  
  public void testJSONCookies()
  {
	  try
	  {
		  System.out.println("\n TEST COOKIE TO JSON OBJECT CONVERSION");
  URL url = new URL("http://www.google.com");
  URLConnection conn = url.openConnection();
  String forjsonString = null;
 int numcookies = 0;
  Map<String, List<String>> headerFields = conn.getHeaderFields();

  Set<String> headerFieldsSet = headerFields.keySet();
  Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
   
  while (hearerFieldsIter.hasNext()) {
       
       String headerFieldKey = hearerFieldsIter.next();
        
       if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {
           List<String> headerFieldValue = headerFields.get(headerFieldKey);
            
           for (String headerValue : headerFieldValue) {
                
              System.out.println("\nCookie Found...");
                
              String[] fields = headerValue.split(";\\s*");

              String cookieValue = fields[0];
              String expires = null;
              String path = null;
              String domain = null;
              boolean secure = false;
               
              // Parse each field
              for (int j = 1; j < fields.length; j++) {
                  if ("secure".equalsIgnoreCase(fields[j])) {
                      secure = true;
                  }
                  else if (fields[j].indexOf('=') > 0) {
                      String[] f = fields[j].split("=");
                      if ("expires".equalsIgnoreCase(f[0])) {
                         expires = f[1];
                      }
                      else if ("domain".equalsIgnoreCase(f[0])) {
                          domain = f[1];
                      }
                      else if ("path".equalsIgnoreCase(f[0])) {
                          path = f[1];
                      }
                  }
                   
              }
              numcookies++;
              System.out.println("PRINTING WHAT WAS FOUND IN COOKIE "+numcookies);
              System.out.println("cookieValue:" + cookieValue);
              forjsonString += "cookieValue = "+cookieValue+";";
              System.out.println("expires:" + expires);
              forjsonString += " expires = "+ expires+";";
              System.out.println("path:" + path);
              forjsonString += " path = "+path +";";
              System.out.println("domain:" + domain);
              forjsonString += " domain = "+ domain + ";";
              System.out.println("secure:" + secure);
              forjsonString += " secure = "+ secure + ";";                        
              System.out.println("*****************************************");
 
              System.out.println("JSON OBJECT FOR COOKIE #"+numcookies);
              JSONObject jsonObject = Cookie.toJSONObject(forjsonString);
              System.out.println(jsonObject);
              forjsonString = null;
           }
       }
            
    }
}
	  catch (Exception ee)
	  {
	     ee.printStackTrace();  
	  }
	  
}
  public void testJSONHTTPHeaders()
  {
  try {
	    System.out.println("\nTESTING JSON HTTP features.");
	    JSONObject jsonObject = new JSONObject();
		URL obj = new URL("http://www.crunchify.com");
		//URLConnection conn = obj.openConnection();
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		
		Map<String, List<String>> map = conn.getHeaderFields();
		String headerText = "";
		String subString;
		//List<String> stringValue =  new ArrayList<String>();
	
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			subString = entry.getKey() + " : " + entry.getValue();
			System.out.println("DEBUG: "+subString);
			//jsonObject.put(stringKey,stringValue);
			headerText += subString;
			}
		
		List<String> contentLength = map.get("Content-Length");
		if (contentLength == null) {
			System.out.println("'Content-Length' doesn't present in Header!");
		} else {
			for (String header : contentLength) {
				System.out.println("Content-Length: " + header);
			}
		}
		
		System.out.println("\nHEADER ABOVE CONVERTED TO JSON STRING");
		System.out.println( HTTP.toJSONObject(headerText)); //THIS WORKED

	} catch (Exception e) {
		e.printStackTrace();
	}
}
  
}