package tester;

import entity.Employee;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Employee("xa12tt", "Kurt", "Wonnegut", new BigDecimal(335567)));
            em.persist(new Employee("hyu654", "Hanne", "Olsen", new BigDecimal(435867)));
            em.persist(new Employee("uio876", "Jan", "Olsen", new BigDecimal(411567)));
            em.persist(new Employee("klo999", "Irene", "Petersen", new BigDecimal(33567)));
            em.persist(new Employee("jik666", "Tian", "Wonnegut", new BigDecimal(56567)));
            em.getTransaction().commit();
            
            //Complete all these small tasks. Your will find the solution to all, but the last,
            //In this document: https://en.wikibooks.org/wiki/Java_Persistence/JPQL#JPQL_supported_functions
            
            //1) Create a query to fetch all employees with a salary > 100000 and print out all the salaries
            TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e WHERE e.salary > 100000", Employee.class);
           System.out.println("Employees with salary over 100000: ");
            for (Employee e : tq.getResultList()){
                System.out.println(e);
            }
            
            //2) Create a query to fetch the employee with the id "klo999" and print out the firstname
             Employee e = em.find(Employee.class, "klo999");
             System.out.println("Employee with id \"klo99\"");
             System.out.println(e.getFirstName());
             
            //3) Create a query to fetch the highest salary and print the value
                TypedQuery<BigDecimal> tq2 = em.createQuery("SELECT MAX(e.salary) FROM Employee e", BigDecimal.class);
                BigDecimal sal = tq2.getSingleResult();
                System.out.println("Higest salary is: " + sal);
                
            //4) Create a query to fetch the firstName of all Employees and print the names
                TypedQuery<String> tq3 = em.createQuery("SELECT e.firstName FROM Employee e", String.class);
                   for (String ee : tq3.getResultList()){
                       System.out.println(ee);
                   }
            
            //5 Create a query to calculate the number of employees and print the number
               TypedQuery<Long> tq4 = em.createQuery("SELECT COUNT(e) FROM Employee e", Long.class);
                System.out.println("Number of employees: " +tq4.getSingleResult());
            
            //6 Create a query to fetch the Employee with the higest salary and print all his details
                TypedQuery<Employee> tq5 = em.createQuery("SELECT e FROM Employee e WHERE e.salary = " + sal, Employee.class);

        } finally {
            em.close();
            emf.close();
        }
    }

}
