package org.example;

import entity.Employee;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Employee employee = new Employee();
        employee.setEmpName("Pratham Jain");
        employee.setEmpEmail("pratham.jain@accolite.com");
        
        Employee emp1 = new Employee();
        emp1.setEmpName("Prankit jaini");
        emp1.setEmpEmail("prankit.jaini@accolite.com");

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.persist(emp1);
        session.getTransaction().commit();
        
        System.out.println("\nEmployees after create:");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);

        session.beginTransaction();
        Employee savedEmployee = session.get(Employee.class, 1L);
        if (savedEmployee != null) {
            savedEmployee.setEmpName("Avadacadavra");
            savedEmployee.setEmpEmail("avadacadvra@accolitedigital.com");
            session.merge(savedEmployee);
        }
        session.getTransaction().commit();

        
        System.out.println("\nEmployees after update:");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        
   
        session.beginTransaction();
        Employee empToDelete = session.get(Employee.class, 2L);
        if (empToDelete != null) {
            session.remove(empToDelete);
        }
        session.getTransaction().commit();

        System.out.println("\nEmployees after delete:");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);



        session.close();
    }
}