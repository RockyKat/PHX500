package ngdemo.phxsql.service;

import ngdemo.phxsql.domain.PHXSQL;
import ngdemo.sql.domain.SQL;
import ngdemo.tools.console.StartUp;

import java.io.IOException;
import java.sql.*;
// ORIGINALLY returns canned info to REST service.
//MODIFY to perform specified entry on database.
//Methods here call DBCOnnect class and do their thing.

public class PHXSQLService {

 
      private Connection con;
      private Statement st;
      private ResultSet rs;
	  private static final String RDS_URL = "jdbc:mysql://slice-test.cnsbrmylp4nh.us-east-1.rds.amazonaws.com:3306";
	  private static final String RDS_DATABASE = "phxcvd19";
	  private static final String RDS_UN = "admin";
	  private static final String RDS_PW = "slicetest";  
	  
  	   StartUp startUpLog;
  	   int indexType;
  	   String strOutLog = null;

           public PHXSQLService()
           {
             try 
             {
            	 Class.forName("com.mysql.cj.jdbc.Driver");
            	 //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sliceDS?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin","admin");
            	 con = DriverManager.getConnection(RDS_URL + "/" + RDS_DATABASE, RDS_UN, RDS_PW);
            	 System.out.println("Connected to " + RDS_URL + "/" + RDS_DATABASE);
            	 st = con.createStatement();
             } 
             catch (Exception ex) 
             {
        		 System.out.println("Failed to connect to " + RDS_URL + "/" + RDS_DATABASE);
            	 System.out.println("ERRORCON: " + ex);
             }
           }
           
           public PHXSQL getDefaultSQL() {
               PHXSQL sql = new PHXSQL();
               sql.setFirstName("My SQL Server");
               sql.setLastName("Demo Database Access.");
               sql.setBmp("mysql.png");
               return sql;
           }
           
           public PHXSQL getDefaultSQL(StartUp start, int index) {
           	
            startUpLog = start;
           	indexType = index;

           	try 
           	{
       			strOutLog = startUpLog.readStdOutLogFile(indexType);
       		} catch (IOException e) {
       			// TODO Auto-generated catch block
       			e.printStackTrace();
       		}
       		
           	
               PHXSQL sql = new PHXSQL();
               sql.setFirstName("My SQL Server");
               sql.setLastName("Demo Database Access.");
               sql.setBmp("mysql.png");
               sql.setStrOutLog(strOutLog);

               return sql;
           }
    	     
     	private void getDataDemo() {
    	 try 
             {
    	        String query = "select * from customer";
    	        rs = st.executeQuery(query);
    	        System.out.println("Records from Database");
    	        while (rs.next()) {
    	        String name = rs.getString("first_name");
    	        String age = rs.getString("last_name");
    	        System.out.println("Name: " + name + " " + age);
    	    }
         }
    	 catch(Exception ex) 
    	{
    	     System.out.println(ex);
    	 }
    }
    	    //Change the email to verizon.net.
    	    //SHow it.
                //Change it back to what it was.
    	    //SHow that
    	    private void updateDataDemo()
    	    {
    	    	try {
    	    	String query = "SELECT * FROM customer WHERE customer_id = 1";
    	    	rs = st.executeQuery(query);
    	    	rs.next();
    	    	String firstn = rs.getString("first_name");
    	    	String lastn = rs.getString("last_name");
    	    	String oldemail = rs.getString("email");
    	    	String newemail = "@verizon.net";
    	    	newemail = firstn + "." + lastn + newemail;
    	    	System.out.println("Old email was "+oldemail);
    	    	
    	    	String sqlUpdateQuery = "UPDATE customer SET email=\""
    	    			+  newemail + "\" where customer_id=1";
    	    	int rtnval  = st.executeUpdate(sqlUpdateQuery);
    	    	rs = st.executeQuery(query);
    	    	rs.next();
    	    	String changedEmail = rs.getString("email");
    	    	System.out.println("New email is "+changedEmail);
    	    	
    	    	//Now put old email back.
    	    	sqlUpdateQuery = "UPDATE customer SET email=\""
    	    			+  oldemail + "\" where customer_id=1";
    	    	rtnval  = st.executeUpdate(sqlUpdateQuery);
    	    	//Now retrieve replaced email and show it is same as original.
    	    	rs = st.executeQuery(query);
    	    	rs.next();
    	    	String replacedMail = rs.getString("email");
    	    	System.out.println("PUT OLD EMAIL BACK to "+replacedMail);
    	    	}
    	    	catch (Exception ex)
    	    	{
    	    		System.out.println(ex);
    	    	}
    	    }

    	   //Create a row with Bob Smith and then read via query and print.
                private void createARowDemo()
    	    {   
    	    	try
    	    	{
                       String newCustomer = "INSERT INTO customer (address_id,store_id,first_name, last_name, email) VALUES ('604','1','Bob','Smith','b0bsmith@example.com')";                
                       int rtnval = st.executeUpdate(newCustomer);
                                
                       //Now display new entry.
                        String findNewCustomer = "SELECT * FROM customer WHERE first_name = 'Bob' AND last_name = 'Smith'";
       	    		rs = st.executeQuery(findNewCustomer);
       	    		rs.next();
       	    		String firstname = rs.getString("first_name");
       	    		String lastname = rs.getString("last_name");
       	    		String email = rs.getString("email");
       	    		System.out.println("READ NEW GUY FROM DB "+firstname +" " + lastname+ " " + email);
    	    	}
    	    	catch (Exception ex)
    	    	{
    	    		System.out.println(ex);
    	    	}
    	    	
    	    }
    	    
    	//Delete the row with Bob Smith.
    	    private void deleteARowDemo()
    	    {
    	    	try
    	    	{
    	    		String deletem = "DELETE FROM customer WHERE first_name = 'Bob' AND last_name = 'Smith'";
    	    	    int rtnval = st.executeUpdate(deletem);
    	    	    //con.commit();
    	    	    con.close();
    	    	}
    	    	catch (Exception ex)
    	    	{
    	    		System.out.println(ex);
    	    	}
    	    	
    	    }


    		public void doDemo()
    		{
    			//List of names in CUSTOMER DB.
    		 	  getDataDemo();    		 
    			 System.out.println("Names in customer DB");
    			 
    			 //Change the email in CUSTOMER DB for PK = 1.
    			 updateDataDemo();
    			 
    			 System.out.println("UPDATED AND THEN REVERTED EMAIL FOR ONE CUSTOMER");
    			 
    			 createARowDemo();
    			 System.out.println("CREATED A NEW ROW");
    			 
    			 deleteARowDemo();
    			 System.out.println("DELETED THAT NEW ROW");
    		}

    		public PHXSQL createARow(String firstname, String lastname)
        		{
        			String myFirstName = firstname;
        			String myLastName = lastname;
        			PHXSQL rtnSQL = createARowNotDemo(myFirstName,myLastName);
        			return rtnSQL;
        		}

    	private PHXSQL createARowNotDemo(String firstname,String lastname)
    	    {
    	    	String firstName = firstname;
    	    	String lastName = lastname;
    	    	String email = firstName + "." + lastName + "@sakilacustomer.org";
    	    	PHXSQL sql = new PHXSQL();
    	    	double a = Math.random();
    	    	int addressId = (int)(a*600);
    	    	int storeId = 1;
    	    	boolean rtnval = false;
    	    	String newCustomer = "INSERT INTO customer (address_id,store_id,first_name, last_name, email)"
    	    			             + " values(?,?,?,?,?)";

    	    try
    	    {
    	     // create the mysql insert preparedstatement
    	       PreparedStatement preparedStmt = con.prepareStatement(newCustomer);
    	       preparedStmt.setInt (1, addressId);
    	       preparedStmt.setInt (2, storeId);
    	       preparedStmt.setString(3, firstName);
    	       preparedStmt.setString(4, lastName);
    	       preparedStmt.setString(5, email);

    	       // execute the preparedstatement
    	        rtnval = preparedStmt.execute();
    	       
    	        sql.setFirstName(firstName);
    	        sql.setLastName(lastName);
    	        sql.setAddressId(addressId);
    	        sql.setStoreId(storeId);
    	        sql.setEmail(email);
   
    	    	      
    	        con.close();
    	    }
    	    catch (Exception e)
    	    {
    	       System.out.println(e.getStackTrace());
    	     }	
    	    return sql;
    	  }

        public PHXSQL readARow(int primaryKey)
        {
        	int primarykey = primaryKey;
        	PHXSQL rtnSQL = readARowNotDemo(primarykey);
        	return rtnSQL;
        }

    	    private PHXSQL readARowNotDemo(int primarykey)
    	    {	
    	    	PHXSQL sql = new PHXSQL();
    	    	try
    	    	{
    	    	   int primaryKey = primarykey;
    	    	   String findNewCustomer = "SELECT * FROM customer WHERE customer_id = "+primaryKey;
    	    	   rs = st.executeQuery(findNewCustomer);
    	    	   rs.next(); 		
    	    	   String firstname = rs.getString("first_name");
      	    	   String lastname = rs.getString("last_name");
      	    	   String email = rs.getString("email");
      	    	   int storeid = rs.getInt("store_id");
      	    	   int addressid = rs.getInt("address_id");
      	    	   sql.setFirstName(firstname);
      	    	   sql.setLastName(lastname);
      	    	   sql.setEmail(email);
      	    	   sql.setStoreId(storeid);
      	    	   sql.setAddressId(addressid);
      	    	   con.close();
    	    	}
    	    	catch (Exception e)
    	    	{
    	    		System.out.println(e.getStackTrace());	    		
    	    	}
    	    	return sql;
    	    }

     public PHXSQL updateARow(String firstName, String lastName, int primaryKey)
        {
        	String firstname = firstName;
        	String lastname = lastName;
        	int primarykey = primaryKey;
        	PHXSQL rtnSQL = updateARowNotDemo(firstname,lastname,primarykey);
        	return rtnSQL;
        }

    	    //Change firstname and lastname of customer whose primary key is specified.
    	    //Also change email since it is FIRSTNAME.LASTNAME@sakilacustomer.org
    	    private PHXSQL updateARowNotDemo(String firstName,String lastName, int primaryKey)
    	    {
    	    	PHXSQL sql = new PHXSQL();
    	    	String firstname = firstName;
    	    	String lastname = lastName;
    	    	int primarykey = primaryKey;
    	    	String email = firstname + "." + lastname + "@sakilacustomer.org";
    	    	String updateString = "UPDATE customer SET first_name = ?," +
    	    	                     "last_name = ?,  email = ? WHERE customer_id = ?";
    	    	try
    	    	{
    	    	   PreparedStatement pstmt = con.prepareStatement(updateString);
    	    	   pstmt.setString(1,firstname);
    	    	   pstmt.setString(2, lastname);
    	    	   pstmt.setString(3,email);
    	    	   pstmt.setInt(4, primarykey);
    	    	   int rtnval = pstmt.executeUpdate();
    	    	   sql.setFirstName(firstname);
    	    	   sql.setLastName(lastname);
    	    	   sql.setEmail(email);
    	    	   
    	    	   con.close();
    	    	}
    	    	catch(Exception e)
    	    	{
    	    		System.out.println(e.getStackTrace());
    	    	}
    	    	
    	    	return sql;
    	    }

        public PHXSQL deleteARow(int primaryKey)
        {
           int primarykey = primaryKey;
           
           PHXSQL rtnSQL = deleteARowNotDemo(primarykey);
           
           return rtnSQL;
        }

    	    private PHXSQL deleteARowNotDemo(int primaryKey)
    	    {
    	    	PHXSQL sql = new PHXSQL();
    	    	int primarykey = primaryKey;
    	    	String deleteString = "DELETE FROM customer WHERE customer_id = "+ primarykey;
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
    