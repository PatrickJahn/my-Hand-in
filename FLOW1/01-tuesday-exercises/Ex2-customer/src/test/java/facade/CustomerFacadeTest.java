/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Patrick
 */
public class CustomerFacadeTest {
  
    private  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public CustomerFacadeTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
   
    
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    


    /**
     * Test of findByID method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testFindByID() {
        
         CustomerFacade cf = CustomerFacade.getFacadeExample(emf);
         cf.addCustommer("Hans", "Hansen");
         System.out.println("findByID");
        int id = 1;
        
        String expResult = "Hans";
        String result = cf.findByID(id).getFirstName();
         System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testFindByLastName() {
        System.out.println("findByLastName");
        CustomerFacade cf = CustomerFacade.getFacadeExample(emf);
         cf.addCustommer("Hans", "Hansen");
        String name = "Hansen";
       
       String expResult = "Hans";
        String result = cf.findByLastName("Hansen").get(0).getFirstName();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
      CustomerFacade cf = CustomerFacade.getFacadeExample(emf);
         cf.addCustommer("Hans", "Hansen");
        Long expResult = Long.parseLong("3"); // 3 fordi vi har lavet 3 før vi når hertil
        Long result = cf.getNumberOfCustomers();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of allCustomers method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testAllCustomers() {
        System.out.println("allCustomers");
        
        CustomerFacade cf = CustomerFacade.getFacadeExample(emf);
        customer cus = cf.addCustommer("Hans", "Hansen");
        List<customer> expResult = new ArrayList<customer>();
        expResult.add(cus);
        List<customer> result = cf.allCustomers();
        assertEquals(expResult.get(0).getFirstName(), result.get(0).getFirstName());
       
    }

   
    
}
