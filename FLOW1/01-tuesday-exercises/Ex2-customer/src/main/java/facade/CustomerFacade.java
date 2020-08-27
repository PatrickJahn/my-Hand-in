/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Patrick
 */
public class CustomerFacade {
    private static CustomerFacade instance;
    private static EntityManagerFactory emf;
    
    private CustomerFacade(){}
    
        public static CustomerFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    public customer findByID(int id){
        EntityManager em = getEntityManager();
        
        try {
            customer cus = em.find(customer.class, id);
            return cus; 
        } finally{
            em.close();
        }   
    }
    
    
    public List<customer> findByLastName(String name){
        EntityManager em = getEntityManager();
        
        try {
            TypedQuery<customer> tq = em.createQuery("SELECT c FROM customer c WHERE c.lastName = " +"\""+ name+ "\"", customer.class);
            return tq.getResultList();
        } finally{
            em.close();
        }   
    }
    
    public Long getNumberOfCustomers(){
        EntityManager em = getEntityManager();
        
        try {
               TypedQuery<Long> tq2 = em.createQuery("SELECT COUNT(c) FROM customer c", Long.class);
               return tq2.getSingleResult();
        } finally{
            em.close();
        }   
    }
    
     public List<customer> allCustomers(){
        EntityManager em = getEntityManager();
        
        try {
            TypedQuery<customer> tq = em.createQuery("SELECT c FROM customer c", customer.class);
            return tq.getResultList();
        } finally{
            em.close();
        }   
    }
     
     
      public customer addCustommer(String fName, String lName){
        EntityManager em = getEntityManager();
        customer cus = new customer(fName, lName);
        try {

            em.getTransaction().begin();
            em.persist(cus);
            em.getTransaction().commit();
            return cus;
        } finally{
            em.close();
        }   
    }
    
    
}
