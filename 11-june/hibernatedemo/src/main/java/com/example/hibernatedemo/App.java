package com.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import java.io.FilterOutputStream;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Product.class).addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();
//        Product p = new Product();
//        p.setId(102);
//        p.setName("Headphone");
//        p.setPrice(8200);
//        p.setQty(6);
//        
//        session.save(p);
//        Employee emp = new Employee();
//        emp.setName("Aashish");
//        emp.setPhone("8877666");
//        emp.setSalary(8777);
//        session.save(emp);
        
        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);
        // HQL
        txn.commit();
      session.close();
    }
}
