package ngdemo.phxswap.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// from http://www.vogella.com/articles/REST/
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
//Object that represents the SWAP table parameters.
public class SWAP {
   
    private String phxSwapLog;
    private ArrayList<PHXSWAP> arrayOfPhxSwap;


    
    public String getPhxSwapLog()
    {
    	return phxSwapLog;
    }
    
    public void setPhxSwapLog(String readLog)
    {
    	this.phxSwapLog = readLog;
    }
    
    public ArrayList<PHXSWAP>  getArrayOfPhxSwap()
    {
    	return arrayOfPhxSwap;
    }
    public void setArrayOfPhxSwap(ArrayList<PHXSWAP> swapList)
    {
	     this.arrayOfPhxSwap = swapList;

    }
    public void addArrayOfPhxSwap(PHXSWAP phxSwap)
    {
	     arrayOfPhxSwap.add(phxSwap);

    }


    
}