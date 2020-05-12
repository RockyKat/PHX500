package ngdemo.phxswap.service;
	
import java.io.IOException;
import java.sql.*;

import ngdemo.phxswap.domain.PHXSWAP;
import ngdemo.tools.console.StartUp;

import java.util.*;

	public class PHXSWAPService {
	    private Connection con;
	    private Statement st;
	    private ResultSet rs;
	    ResultSetMetaData meta;
		StartUp startUpLog;
		int indexType;
	    
	    public PHXSWAPService() 
	    {
			 try {
			     Class.forName("com.mysql.cj.jdbc.Driver");
			     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phxcvd19?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin");
		
			     st = con.createStatement();
			 } 
			 catch (Exception ex) 
			 {
			     System.out.println("ERRORCON: " + ex);
			     
			 }
			    }    
		//-------------------------------------------------------------------------------	    
	    public ResultSet getData() 
	    {
		 try 
		 {
			 
		     String query = "select * from phxswap";
		     rs = st.executeQuery(query);
		     System.out.println("Records from PHXSWAP Database");
		     
		     //query
		     boolean returningRows = st.execute(query);
		     if (returningRows)
		       rs = st.getResultSet();
		     
	
		     //get metadata
		     meta = rs.getMetaData();
	
		     //get column names
		     int colCount = meta.getColumnCount();
		     ArrayList<Object> thisRow = new ArrayList<Object>();
		   
		     ArrayList<String> cols = new ArrayList<String>();
		     for (int index=1; index<= colCount; index++)
		     {
		       cols.add(meta.getColumnName(index));
		       System.out.print(cols.get(index-1) + " ");
		     }
		     System.out.println("");
		     
		     //fetch out rows
		     ArrayList<HashMap<String,Object>> rows = 
		     new ArrayList<HashMap<String,Object>>();
	
		     while (rs.next()) 
		     {
		       HashMap<String,Object> row = new HashMap<String,Object>();
		       for (String colName:cols) {
		         Object val = rs.getObject(colName);
		         row.put(colName,val);
		         //System.out.println("col "+ colName + " val "+ val);
		         thisRow.add( val);
		       }
		       rows.add(row);
		       for (int xx = 0; xx < colCount; xx++)
		       {
		    	 System.out.print(thisRow.get(xx) + " "); 
		       }
		       System.out.println("");
		       thisRow.clear();
		       //System.out.println(row);
		     }
	
		     //close statement
		     st.close();
		     con.close();
		     return rs;
		     //pass back rows
		     //return rows;
		   }	

	 catch (Exception ee)
	 {
		   System.out.println(ee);
	 }
//	 catch (IOException e) 
//	 {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	 }	 		 
	return null; 
}

	     
//This really doesn't need a default object.
	    //Only works with bustered swap list.
public PHXSWAP getDefaultPHXSWAP()
{
	return (PHXSWAP) null;
}
	    
public PHXSWAP createARow(String packagename, String currentversion)
{
	String packageName = packagename;
	String currentVersion = currentversion;
	PHXSWAP rtnSQL = createARowNotDemo(packageName,currentVersion);
	return rtnSQL;
}	    

private PHXSWAP createARowNotDemo(String packagename, String currentversion)
{
	String packageName = packagename;
	String currentVersion = currentversion;
	PHXSWAP sql = new PHXSWAP();
	String newCOTS = "INSERT INTO phxswap (PackageName,CurrentVersion)"
			             + " values(?,?)";

try
{
 // create the mysql insert preparedstatement
   PreparedStatement preparedStmt = con.prepareStatement(newCOTS);
   preparedStmt.setString (1, packageName);
   preparedStmt.setString (2, currentVersion);
  

   // execute the preparedstatement
    boolean rtnval = preparedStmt.execute();
   
    sql.setSlice("Y");
    sql.setCpd("N");
    sql.setPackageName(packagename);
    sql.setCurrentVersion(currentversion);
    sql.setPkgStatus("NO");
 

	      
    con.close();
}
catch (Exception e)
{
   System.out.println(e.getStackTrace());
 }	
return sql;
}
public PHXSWAP readARow(int primaryKey)
{
	int primarykey = primaryKey;
	PHXSWAP rtnSQL = readARowNotDemo(primarykey);
	return rtnSQL;
}

    private PHXSWAP readARowNotDemo(int primarykey)
    {	
    	PHXSWAP sql = new PHXSWAP();
    	try
    	{
    	   int primaryKey = primarykey;
    	   String findNewCustomer = "SELECT * FROM phxswap WHERE PkgId = "+primaryKey;
    	   
    	   rs = st.executeQuery(findNewCustomer);
    	   rs.next(); 	
    	   
    	   String SLICE = rs.getString("SLICE");
    	   String CPD  =  rs.getString("CPD");
    	   String PackageName = rs.getString("PackageName");
    	   String CurrentVersion = rs.getString("CurrentVersion");
    	   String SwapListVersion = rs.getString("SwapListVersion");
    	   String PkgStatus = rs.getString("PkgStatus");
    	   String Problems = rs.getString("Problems");
    	   
    	   sql.setSlice(SLICE);
    	   sql.setCpd(CPD);
    	   sql.setPackageName(PackageName);
    	   sql.setCurrentVersion(CurrentVersion);
    	   sql.setSwapListVersion(SwapListVersion);
    	   sql.setPkgStatus(PkgStatus);
    	   sql.setProblems(Problems);
    	           	
    	}
    	catch (Exception e)
    	{
    		System.out.println(e.getStackTrace());	    		
    	}
	    return sql;
    }
    
    //Update a parameter in an existing row of SWAP table.
    public PHXSWAP updateARow(String whichTerm, String whichValue, int primaryKey)
    {
    	String whichterm = whichTerm;
    	String whichvalue = whichValue;
    	int primarykey = primaryKey;
    	PHXSWAP rtnSQL = updateARowNotDemo(whichterm, whichvalue, primarykey);
    	return rtnSQL;
    }
    
	    private PHXSWAP updateARowNotDemo(String whichTerm,String whichValue, int primaryKey)
	    {
	    	PHXSWAP sql = new PHXSWAP();
	    	String whichterm = whichTerm;
	    	String whichvalue = whichValue;
	    	int primarykey = primaryKey;
	    	
	    	try
	    	{
		        String updateString = "UPDATE phxswap SET "+whichTerm + " = ? WHERE PkgId = "+primaryKey;
		    	PreparedStatement pstmt = con.prepareStatement(updateString);
	    	   //Update the line.
	    	    pstmt.setString(1,whichvalue);
	    	   int rtnval = pstmt.executeUpdate();
	    	   
	    	   //Read the line and stuff PHXSWAP with it.
	    	   String findNewCustomer = "SELECT * FROM phxswap WHERE PkgId = "+primaryKey;
	    	   rs = st.executeQuery(findNewCustomer);
	    	   rs.next(); 
	    	   String CPD = rs.getString("CPD");
	    	   String SLICE = rs.getString("SLICE");
	    	   String PackageName = rs.getString("PackageName");
	    	   String CurrentVersion = rs.getString("CurrentVersion");
	    	   String SwapListVersion = rs.getString("SwapListVersion");
	    	   String PkgStatus = rs.getString("PkgStatus");
	    	   String Problems = rs.getString("Problems");
	    	   sql.setCpd(CPD);
	    	   sql.setSlice(SLICE);
	    	   sql.setPkgStatus(PkgStatus);
	    	   sql.setPackageName(PackageName);
	    	   sql.setCurrentVersion(CurrentVersion);
	    	   sql.setSwapListVersion(SwapListVersion);
	    	   sql.setProblems(Problems);
	    	   
	    	   con.close();
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e.getStackTrace());
	    	}
	    	
	    	return sql;
	    }   
	    
	       public PHXSWAP deleteARow(int primaryKey)
	        {
	           int primarykey = primaryKey;
	           
	           PHXSWAP rtnSQL = deleteARowNotDemo(primarykey);
	           
	           return rtnSQL;
	        }

	    	    private PHXSWAP deleteARowNotDemo(int primaryKey)
	    	    {
	    	    	PHXSWAP sql = new PHXSWAP();
	    	    	int primarykey = primaryKey;
	    	    	String deleteString = "DELETE FROM phxswap WHERE PkgId = "+ primarykey;
	    	    	try
	    	    	{
	    	    	   int rtnval = st.executeUpdate(deleteString);
	    	    	   con.close();
	    	    	}
	    	    	catch (Exception e)
	    	    	{
	    	    		System.out.println(e.getStackTrace());
	    	    	}
	    	    	
	    	    	return sql;
	    	    }

	    
	}	
