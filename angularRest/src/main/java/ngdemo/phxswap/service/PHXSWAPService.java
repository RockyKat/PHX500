package ngdemo.phxswap.service;
	
import java.io.IOException;
import java.sql.*;

import ngdemo.phxswap.domain.PHXSWAP;
import ngdemo.phxswap.domain.SWAP;
import ngdemo.tools.console.StartUp;

import java.util.*;

public class PHXSWAPService {
    private Connection 			con;
    private Statement 			st;
    private ResultSet 			resutlSet;
    		ResultSetMetaData 	meta;
    		StartUp 			startUpLog;
    		int 				indexType;
    		PHXSWAP 			phxSwap;
    		
//-------------------------------------------------------------------------------	    
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
public SWAP getData() 
{
	 try 
	 {
	     SWAP swapResults 					= new SWAP();
	     ArrayList<PHXSWAP> arrayOfPhxSwap 	= new ArrayList<PHXSWAP>();
	     String query 						= "select * from phxswap";
	     boolean returningRows;
	     
	     System.out.println("Records from PHXSWAP Database");
	     
	     resutlSet 	  = st.executeQuery(query);
	     returningRows = st.execute(query);
	     if (returningRows)
	     {
	       resutlSet = st.getResultSet();
	     }
	     
	     resutlSet.first();
	     while (resutlSet.next()) 
	     {
		     phxSwap = new PHXSWAP();
		     phxSwap.setCpd				(resutlSet.getObject("CPD"				).toString());
		     phxSwap.setCurrentVersion	(resutlSet.getObject("CurrentVersion"	).toString());
		     phxSwap.setPackageName		(resutlSet.getObject("PackageName"		).toString());
		     phxSwap.setPkgStatus		(resutlSet.getObject("PkgStatus"		).toString());
		     phxSwap.setProblems		(resutlSet.getObject("Problems"			).toString());
		     phxSwap.setSlice			(resutlSet.getObject("Slice"			).toString());
		     phxSwap.setUrl				(resutlSet.getObject("url"				).toString());			     
		     phxSwap.setSwapListVersion	(resutlSet.getObject("SwapListVersion"	).toString());
		     arrayOfPhxSwap.add(phxSwap);
		     
	    	 System.out.print("-------------------------------------" + "\r"); 
	    	 System.out.print("COTS:  " 		+ phxSwap.getPackageName() + "\r"); 
	    	 System.out.print("VERSION:  " 		+ phxSwap.getCurrentVersion() + "\r"); 
	    	 System.out.print("DESCRIPTION:  " 	+ phxSwap.getProblems() + "\r"); 
	
	     }
	     swapResults.setArrayOfPhxSwap(arrayOfPhxSwap);
	         
	     st.close();
	     con.close();
	     return swapResults;
	   }	

	 catch (Exception ee)
	 {
		   System.out.println(ee);
		     try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
 
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
    	   
    	   resutlSet = st.executeQuery(findNewCustomer);
    	   resutlSet.next(); 	
    	   
    	   String SLICE = resutlSet.getString("SLICE");
    	   String CPD  =  resutlSet.getString("CPD");
    	   String PackageName = resutlSet.getString("PackageName");
    	   String CurrentVersion = resutlSet.getString("CurrentVersion");
    	   String SwapListVersion = resutlSet.getString("SwapListVersion");
    	   String PkgStatus = resutlSet.getString("PkgStatus");
    	   String Problems = resutlSet.getString("Problems");
    	   
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
	    	   resutlSet = st.executeQuery(findNewCustomer);
	    	   resutlSet.next(); 
	    	   String CPD = resutlSet.getString("CPD");
	    	   String SLICE = resutlSet.getString("SLICE");
	    	   String PackageName = resutlSet.getString("PackageName");
	    	   String CurrentVersion = resutlSet.getString("CurrentVersion");
	    	   String SwapListVersion = resutlSet.getString("SwapListVersion");
	    	   String PkgStatus = resutlSet.getString("PkgStatus");
	    	   String Problems = resutlSet.getString("Problems");
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
