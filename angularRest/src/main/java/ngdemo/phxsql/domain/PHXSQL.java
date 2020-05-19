package ngdemo.phxsql.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// from http://www.vogella.com/articles/REST/
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
//MODIFIED BY CGN: Is set up to return what is in CUSTOMER table of SAKILA database
//which comes with MYSQL workbench
public class PHXSQL {

    public String getBmp() {
        return bmp;
    }

    public void setBmp(String bmp) {
        this.bmp = bmp;
    }
	

    private String bmp;
    //Above are demo variables.
	private int customer_id;
	private int store_id;
	private String first_name;
	private String last_name;
	private String email;
	private int address_id;
	private int active;
	private String  timestamp;
	private String datetime;
	private String strOutLog;
	
	public int getCustomerId()
	{
		return customer_id;
	}
	
	public int getStoreId()
	{
		return store_id;
	}
	
	public String getFirstName()
	{
		return first_name;		
	}
	public String getLastName()
	{
		return last_name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
     public int getAddressId()
     {
        return address_id;
     }
     
     public int getActive()
     {
    	 return active;
     }
     
     public String getTimeStamp()
     {
    	 return timestamp;
     }
     
     public String getDateTime()
     {
    	 return datetime;
     }
     
     public void setDateTime(String datetime)
     {
    	 this.datetime = datetime;
     }
     
     public void setTimeStamp(String timestamp)
     {
    	 this.timestamp  = timestamp;
     }
     
     public void setActive(int active)
     {
    	 this.active = active;
     }
     
     public void setAddressId(int address_id)
     {
    	 this.address_id = address_id;
     }
     
     public void setEmail(String email)
     {
    	 this.email = email;
     }
     public void setLastName(String last_name)
     {
    	 this.last_name = last_name;
     }
     public void setFirstName(String first_name)
     {
    	 this.first_name = first_name;
     }
     public void setStoreId(int store_id)
     {
    	 this.store_id = store_id;
     }
     
     public void setStrOutLog(String strOutLog) {
         this.strOutLog = strOutLog;
     }
     
     public String getStrOutLog()
     {
    	 return strOutLog;
     }
}
