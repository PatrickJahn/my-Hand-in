/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import facade.CustomerFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Patrick
 */
public class EntityTested {
 
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        CustomerFacade cf; 
        try {
            em.getTransaction().begin();
            em.persist(new customer("Hans","Hansen"));
            em.persist(new customer("Lars","Larsen"));
            em.persist(new customer("Bo","Christiansen"));
            em.getTransaction().commit();
            
            cf = CustomerFacade.getFacadeExample(emf);
            
           customer cus1 = cf.addCustommer("New", "name");
           System.out.println("Addcustomer returns: " + cus1.toString() + "\n");
            
           customer cus2 = cf.findByID(1);
           System.out.println("findbyid returns: " + cus2.toString() + "\n");

           System.out.println("getNumberofCustomers returns: " + cf.getNumberOfCustomers() + "\n");
        
           List<customer> lCus1 = cf.allCustomers();
            System.out.println("allCustomers returns:");
           for (customer c : lCus1){
               System.out.println(c.toString());
           }
               
           List<customer> lCus2 = cf.findByLastName("Hansen");
           System.out.println("\n findByLastName returns:");
           for (customer c : lCus2){
               System.out.println(c.toString());
           }

        } finally {
            em.close();
        }
        
        
    }
}
