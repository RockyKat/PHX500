package ngdemo.drools.domain;

public class Drools{

	private String type;
	private int discount;
	private String first_name;
	private String last_name;
	private String bmp;
	private String strOutLog;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
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