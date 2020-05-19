//Calls the Service class to do the real work
package ngdemo.drooltest.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import ngdemo.drooltest.domain.DroolTest;
import ngdemo.phxsql.domain.PHXSQL;
import ngdemo.tools.console.StartUp;


public class DroolTestService 
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

		DroolTest product = new DroolTest();
		product.setType("gold");

		workingMemory.insert(product);
		workingMemory.fireAllRules();

		System.out.println("The discount for the product " + product.getType()
				+ " is " + product.getDiscount()); 
		
		DroolTest product2 = new DroolTest();
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
   
    public DroolTest getDefaultDroolStuff(StartUp start, int index) {
      	
       startUpLog = start;
      	indexType = index;

      	try 
      	{
  			strOutLog = startUpLog.readStdOutLogFile(indexType);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		
      	
          DroolTest droolobj = new DroolTest();
          droolobj.setFirstName("JBOSS Drools");
          droolobj.setLastName("Demo Drools Rule Engine.");
          droolobj.setBmp("drools.png");
          droolobj.setStrOutLog(strOutLog);

          return droolobj;
      }
}