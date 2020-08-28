package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import javax.persistence.TypedQuery;
/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeBankCustomer {

    private static FacadeBankCustomer instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeBankCustomer() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeBankCustomer getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeBankCustomer();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   public CustomerDTO getCustomerByID(int id) {
        EntityManager em = getEntityManager();
        try {
            BankCustomer bc = em.find(BankCustomer.class, id);
            return new CustomerDTO((bc));
        } finally {
            em.close();
        }
    }
   
   public List<CustomerDTO> getCustomerByName(String name) {
        EntityManager em = getEntityManager();
        List<CustomerDTO> liste = new ArrayList<CustomerDTO>();
        try {
            TypedQuery<BankCustomer> tq = em.createQuery("SELECT b FROM BankCustomer b WHERE b.firstName = ?1 ", BankCustomer.class);
           tq.setParameter(1, name);
          for (BankCustomer b : tq.getResultList()) {
              liste.add(new CustomerDTO(b));
          }
            return liste;
        } finally {
            em.close();
        }
    }
   
   
   public BankCustomer addCustomer(BankCustomer cust) {
        EntityManager em = getEntityManager();
        BankCustomer bc = cust;
        try {
            em.getTransaction().begin();;
            em.persist(bc);
            em.getTransaction().commit();
            return bc;
        } finally {
            em.close();
        }
    }
   
    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = getEntityManager();

        try {
           TypedQuery<BankCustomer> tq = em.createQuery("SELECT b FROM BankCustomer b", BankCustomer.class);
            
           
           return tq.getResultList();
        } finally {
            em.close();
        }
    }
    
    
}
