//Calls the Service class to do the real work
package ngdemo.drools.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import ngdemo.drools.domain.Drools;
import ngdemo.tools.console.StartUp;


public class DroolsService 
{
	StartUp startUpLog;
 	 int indexType;
 	 String strOutLog = null;

	
   public void executeDrools()
   {
	   try
	   {
	   PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		Drools product = new Drools();
		product.setType("gold");

		workingMemory.insert(product);
		workingMemory.fireAllRules();

		System.out.println("The discount for the product " + product.getType()
				+ " is " + product.getDiscount()); 
		
		Drools product2 = new Drools();
		product2.setType("diamond");
		workingMemory.insert(product2);
		workingMemory.fireAllRules();
		System.out.println("The discount for the product " + product2.getType()
		+ " is " + product2.getDiscount()); 
		
	   }
	   catch (Exception ee)
	   {
	       System.out.println(ee);	
	   }
   }
   
    public Drools getDefaultDrools(StartUp start, int index) {
      	
       startUpLog = start;
      	indexType = index;

      	try 
      	{
  			strOutLog = startUpLog.readStdOutLogFile(indexType);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		
      	
          Drools droolsObj = new Drools();
          droolsObj.setFirstName("JBOSS Drools");
          droolsObj.setLastName("Demo Drools Rule Engine.");
          droolsObj.setBmp("drools.png");
          droolsObj.setStrOutLog(strOutLog);

          return droolsObj;
      }
}