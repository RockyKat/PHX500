package ngdemo.phxswap.service;
	
import java.io.IOException;
import java.sql.*;

import ngdemo.phxswap.domain.PHXSWAP;
import ngdemo.phxswap.domain.SWAP;
import ngdemo.tools.console.StartUp;

import java.util.*;

public class PHXSWAPService {
	  private static final 	String RDS_URL 		= "jdbc:mysql://slice-test.cnsbrmylp4nh.us-east-1.rds.amazonaws.com:3306";
	  private static final 	String RDS_DATABASE = "phxcvd19";
	  private static final 	String RDS_UN 		= "admin";
	  private static final 	String RDS_PW 		= "slicetest"; 	
	  private 				Connection 			con;
	  private 				Statement 			st;
	  private 				ResultSet 			resultSet;
    						ResultSetMetaData 	meta;
    						StartUp 			startUpLog;
    						int 				indexType;
    						PHXSWAP 			phxSwap;
    		
//-------------------------------------------------------------------------------	    
public PHXSWAPService() 
{ 	  
	 try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phxcvd19?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "PaulShock1");
	     //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phxcvd19?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin");
    	 //con = DriverManager.getConnection(RDS_URL + "/" + RDS_DATABASE, RDS_UN, RDS_PW);
    	 System.err.println("Connected to " + RDS_URL + "/" + RDS_DATABASE);
	     st = con.createStatement();
	 } 
	 catch (Exception ex) 
	 {
		 System.err.println("Failed to connect to " + RDS_URL + "/" + RDS_DATABASE);
    	 System.err.println("ERRORCON: " + ex);	     
	     
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
	     
	     resultSet 	  = st.executeQuery(query);
	     returningRows = st.execute(query);
	     if (returningRows)
	     {
	       resultSet = st.getResultSet();
	     }
	     
//	     resultSet.first();
	     while (resultSet.next()) 
	     {
		     phxSwap = new PHXSWAP();
		     phxSwap.setCpd				(resultSet.getObject("CPD"				).toString());
		     phxSwap.setCurrentVersion	(resultSet.getObject("CurrentVersion"	).toString());
		     phxSwap.setPackageName		(resultSet.getObject("PackageName"		).toString());
		     phxSwap.setPkgStatus		(resultSet.getObject("PkgStatus"		).toString());
		     phxSwap.setProblems		(resultSet.getObject("Problems"			).toString());
		     phxSwap.setSlice			(resultSet.getObject("Slice"			).toString());
		     phxSwap.setUrl				(resultSet.getObject("url"				).toString());			     
		     phxSwap.setSwapListVersion	(resultSet.getObject("SwapListVersion"	).toString());
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
				System.err.println(e.getStackTrace());
			}
		     try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					System.err.println(e.getStackTrace());
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
   System.err.println(e.getStackTrace());
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
    	   
    	   resultSet = st.executeQuery(findNewCustomer);
    	   resultSet.next(); 	
    	   
    	   String SLICE = resultSet.getString("SLICE");
    	   String CPD  =  resultSet.getString("CPD");
    	   String PackageName = resultSet.getString("PackageName");
    	   String CurrentVersion = resultSet.getString("CurrentVersion");
    	   String SwapListVersion = resultSet.getString("SwapListVersion");
    	   String PkgStatus = resultSet.getString("PkgStatus");
    	   String Problems = resultSet.getString("Problems");
    	   
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
    		System.err.println(e.getStackTrace());	    		
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
	    	   resultSet = st.executeQuery(findNewCustomer);
	    	   resultSet.next(); 
	    	   String CPD = resultSet.getString("CPD");
	    	   String SLICE = resultSet.getString("SLICE");
	    	   String PackageName = resultSet.getString("PackageName");
	    	   String CurrentVersion = resultSet.getString("CurrentVersion");
	    	   String SwapListVersion = resultSet.getString("SwapListVersion");
	    	   String PkgStatus = resultSet.getString("PkgStatus");
	    	   String Problems = resultSet.getString("Problems");
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
	    		System.err.println(e.getStackTrace());
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
	    	    		System.err.println(e.getStackTrace());
	    	    	}
	    	    	
	    	    	return sql;
	    	    }

	    
	}	
