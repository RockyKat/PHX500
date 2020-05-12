package ngdemo.phxswap.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// from http://www.vogella.com/articles/REST/
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
//Object that represents the SWAP table parameters.
public class PHXSWAP {
   
    private String slice;
    private String cpd;
    private String  PackageName;
    private String CurrentVersion;
    private String SwapListVersion;
    private String PkgStatus;
    private String Problems;
    
    public String getSlice()
    {
    	return slice;
    }
    
    public void setSlice(String Slice)
    {
    	this.slice = Slice;
    }
    
    public String getCpd()
    {
    	return cpd;
    }
    
    public void setCpd(String Cpd)
    {
    	this.cpd = Cpd;
    }
    
    public String getPackageName()
    {
    	return PackageName;
    }
    
    public void setPackageName(String PackageName)
    {
    	this.PackageName = PackageName;
    }
    
    public String getCurrentVersion()
    {
    	return CurrentVersion;
    }
    
    public void setCurrentVersion(String CurrentVersion)
    {
    	this.CurrentVersion = CurrentVersion;
    }
    
    public String getSwapListVersion()
    {
    	return SwapListVersion;
    }
    
    public void setSwapListVersion(String SwapListVersion)
    {
    	this.SwapListVersion = SwapListVersion;
    }
    
    public String getPkgStatus()
    {
    	return PkgStatus;
    }
    
    public void setPkgStatus(String PkgStatus)
    {
    	this.PkgStatus = PkgStatus;
    }
    
    public String getProblems()
    {
    	return Problems;
    }
    
    public void setProblems(String Problems)
    {
    	this.Problems = Problems;
    }

    
}