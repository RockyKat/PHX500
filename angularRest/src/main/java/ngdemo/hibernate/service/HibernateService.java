package ngdemo.hibernate.service;
 
import ngdemo.hibernate.domain.EmployeeEntity;
import ngdemo.hibernate.domain.Hibernate;
import ngdemo.tools.console.StartUp;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
 
public class HibernateService {
	
	   StartUp startUpLog;
	   int indexType;
	   String strOutLog = null;
 
    public void TestHibernate() {
    	
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	
        //Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        // Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("lokesh@mail.com");
        emp.setFirstName("Dan");
        emp.setLastName("Duryea");
        System.out.println("ADDING NEW ENTRY TO TABLE: "+emp.getFirstName()+ " "+emp.getLastName());
 
        session.save(emp);
 
        Integer empId = emp.getEmployeeId();
        session.getTransaction().commit();
        session.close();
        //HibernateUtil.shutdown();
        
        //Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
        Session sessionTwo = sessionFactory.openSession();
        sessionTwo.beginTransaction();
        
        EmployeeEntity emp1 = (EmployeeEntity) sessionTwo.load(EmployeeEntity.class, empId);
        System.out.println("READ FROM TABLE: " +emp1.getFirstName() + "  " +emp1.getLastName());
        sessionTwo.getTransaction().commit();
        sessionTwo.close();
        
        Session sessionThree = sessionFactory.openSession();
        //Session sessionThree = HibernateUtil.getSessionFactory().openSession();
        sessionThree.beginTransaction();
        
        emp1.setLastName("Blocker");
        sessionThree.saveOrUpdate(emp1);
        
        System.out.println("SETTING NEW LAST NAME IN TABLE: " + emp1.getLastName());
        empId = emp1.getEmployeeId();
        sessionThree.getTransaction().commit();
        sessionThree.close();
        
        //Session sessionFour = HibernateUtil.getSessionFactory().openSession();
        Session sessionFour = sessionFactory.openSession();
        sessionFour.beginTransaction();
        
        EmployeeEntity emp11 = (EmployeeEntity) sessionFour.load(EmployeeEntity.class, empId);
        System.out.println("READ NAME FROM TABLE : "+emp11.getFirstName() + " " + emp11.getLastName());
        sessionFour.delete(emp11);
        sessionFour.getTransaction().commit(); 
        sessionFour.close();
        System.out.println("DELETED ENTRY FROM TABLE\n");
    
        
        //HibernateUtil.shutdown();
        sessionFactory.close();       
    }
    
    public Hibernate getDefaultHibTest(StartUp start, int index) {
       	
        startUpLog = start;
       	indexType = index;

       	try 
       	{
   			strOutLog = startUpLog.readStdOutLogFile(indexType);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			System.err.println(e.getStackTrace());
   		}
   		
       	
           Hibernate hibTest = new Hibernate();
           hibTest.setFirstName("Hibernate 4.3");
           hibTest.setLastName("Demo Hibernate Access.");
           hibTest.setBmp("hibernate_small.jpg");
           hibTest.setStrOutLog(strOutLog);

           return hibTest;
       }    
}