package com.myapp.hbem;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // we need to create an object of entity manager factory
    	EntityManagerFactory entityManagerFactory =	Persistence.createEntityManagerFactory("persistence");
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
    	
//    	Student s = new Student();
//    	s.setName("Rahul");
//    	s.setMarks(85);
//    	
//    	entityManager.persist(s);
//    	
//    	
//    	Student s =entityManager.find(Student.class, 1);
//    	System.out.println(s);
    	
    	Iterator<Student> itr = entityManager.createQuery("FROM Student").getResultList().iterator();
    	while(itr.hasNext()) {
    		Student s =itr.next();
    		System.out.println(s);
    	}
    	entityManager.getTransaction().commit();
    	
    }
}
