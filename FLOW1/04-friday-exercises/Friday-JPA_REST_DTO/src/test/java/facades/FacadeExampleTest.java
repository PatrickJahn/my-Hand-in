package facades;

import entities.BankCustomer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class FacadeExampleTest {
   private static final EntityManagerFactory ENF = Persistence.createEntityManagerFactory("pu");
   private static final FacadeBankCustomer FE = FacadeBankCustomer.getFacadeExample(ENF);
    public FacadeExampleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
//        Add code to setup entities for test before running any test methods
    
    }
    
    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }
    
    @BeforeEach
    public void setUp() {
//        Put the test database in a proper state before each test is run
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    /**
     * Test a method here.
     */
    //@Test
    public void testSomeMethod() {
     BankCustomer bc = FE.addCustomer(new BankCustomer("Per", "Knudsen", "dad22222", 21110, 5, "Postman per"));

     String result = bc.getFirstName();
      String expResult = "Per";
        Assertions.assertEquals(expResult, expResult);
    }
    
}
