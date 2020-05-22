package ngdemo.json.domain;

public class Json {

	private String firstname;
	private String lastname;
	private String strOutLog;
	private String bmp;
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String  getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	   public String getBmp() {
	        return bmp;
	    }

	    public void setBmp(String bmp) {
	        this.bmp = bmp;
	    }
	
    public void setStrOutLog(String strOutLog) {
        this.strOutLog = strOutLog;
    }
    
    public String getStrOutLog()
    {
   	 return strOutLog;
    }	

}