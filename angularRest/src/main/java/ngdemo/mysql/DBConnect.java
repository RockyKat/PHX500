package ngdemo.mysql;
	
	import java.sql.*;

	public class DBConnect {
	    private Connection con;
	    private Statement st;
	    private ResultSet rs;
	    private static final String RDS_URL = "jdbc:mysql://slice-test.cnsbrmylp4nh.us-east-1.rds.amazonaws.com:3306";
	    private static final String RDS_DATABASE = "phxcvd19";
	    private static final String RDS_UN = "admin";
	    private static final String RDS_PW = "slicetest";	  
	    
	    public DBConnect() {
	 try {
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phxcvd19?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin","admin");
	     //con = DriverManager.getConnection(RDS_URL + "/" + RDS_DATABASE, RDS_UN, RDS_PW);
	     st = con.createStatement();
	     //System.err.println("Connected to " + RDS_URL + "/" + "RDS_DATABASE");
	 } catch (Exception ex) {
		 System.err.println("Failed to connect to " + RDS_URL + "/" + "RDS_DATABASE");
	     System.err.println("ERRORCON: " + ex);
	     
	 }
	    }    
	    
	    public void getData() {
	 try {
	     String query = "select * from actor";
	     rs = st.executeQuery(query);
	     System.out.println("Records");
	     System.out.println("Records Database:");
	     while (rs.next()) {
	  String name = rs.getString("first_name");
	  String age = rs.getString("last_name");
	  System.out.println("Name: " + name + " " + age);
	     }
	 } catch(Exception ex) {
	     System.out.println(ex);
	 }
	    }
	
	    //Get the email for the customer.
	    //Change it in the table.
	    //Right now let it always be customer 1
	    public void updateData()
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
	    	//con.commit();
	    	
	    	//Now put old email back.
	    	sqlUpdateQuery = "UPDATE customer SET email=\""
	    			+  oldemail + "\" where customer_id=1";
	    	rtnval  = st.executeUpdate(sqlUpdateQuery);
	    	//con.commit();
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
	    
	    public void createARow()
	    {   
	    	try
	    	{
               String newCustomer = "INSERT INTO customer (address_id,store_id,first_name, last_name, email) VALUES ('604','1','Bob','Smith','b0bsmith@example.com')";                
               int rtnval = st.executeUpdate(newCustomer);
               //con.commit();
               
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
	    
	    public void deleteARow()
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
	    
	}	
