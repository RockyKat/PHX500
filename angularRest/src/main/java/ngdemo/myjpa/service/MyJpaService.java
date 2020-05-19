package ngdemo.myjpa.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ngdemo.myjpa.domain.*;
//import net.javaguides.hibernate.util.JPAUtil;
import ngdemo.tools.console.StartUp;

/**
 *  JPA CRUD Operations
 * @author Ramesh Fadatare
 *
 */
public class  MyJpaService{
	    int primaryKey = 0;
	  	   StartUp startUpLog;
	  	   int indexType;
	  	   String strOutLog = null;
	  	   
    public void insertEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        primaryKey =student.getId();
        System.out.println("CREATED STUDENT WITH PRIMARY KEY = "+primaryKey);
        System.out.println("");
        entityManager.close();
    }

    public void findEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class,primaryKey);
        System.out.println("READING STUDENT INFO FROM TABLE");
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, primaryKey);
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        // The entity object is physically updated in the database when the transaction
        // is committed
        student.setFirstName("Ram");
        student.setLastName("jadhav");
        System.out.println("UPDATED STUDENT FIRST NAME to "+student.getFirstName());
        System.out.println("UPDATED STUDENT LAST NAME to  "+student.getLastName());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("\n READING NEW STUDENT DATA FROM TABLE");
        Student student = entityManager.find(Student.class, primaryKey);
        System.out.println("student id :: " + student.getId());
        System.out.println("student firstname :: " + student.getFirstName());
        System.out.println("student lastname :: " + student.getLastName());
        System.out.println("student email :: " + student.getEmail());
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        System.out.println("DELETED STUDENT FROM TABLE\n");
        entityManager.close();
    }
    
    public MyJpa getDefaultJPA(StartUp start, int index) {
       	
        startUpLog = start;
       	indexType = index;

       	try 
       	{
   			strOutLog = startUpLog.readStdOutLogFile(indexType);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
       	
           MyJpa myJpa = new MyJpa();
           myJpa.setFirstName("JPA - Java Persistence API");
           myJpa.setLastName("Demo Database Access.");
           myJpa.setBmp("hibernate_small.jpg");
           myJpa.setStrOutLog(strOutLog);

           return myJpa;
       }
    
    
}