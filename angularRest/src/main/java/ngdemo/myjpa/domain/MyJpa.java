package ngdemo.myjpa.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// from http://www.vogella.com/articles/REST/
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
//MODIFIED BY CGN: Is set up to return what is in CUSTOMER table of SAKILA database
//which comes with MYSQL workbench
public class MyJpa {

        private String bmp;
	private String first_name;
	private String last_name;
	private String strOutLog;
	
	
	public String getFirstName()
	{
		return first_name;		
	}
	public String getLastName()
	{
		return last_name;
	}

     public void setLastName(String last_name)
     {
    	 this.last_name = last_name;
     }
     public void setFirstName(String first_name)
     {
    	 this.first_name = first_name;
     }
    
     public void setStrOutLog(String strOutLog) {
         this.strOutLog = strOutLog;
     }
     
     public String getStrOutLog()
     {
    	 return strOutLog;
     }

   public String getBmp() {
        return bmp;
    }

    public void setBmp(String bmp) {
        this.bmp = bmp;
    }
}
