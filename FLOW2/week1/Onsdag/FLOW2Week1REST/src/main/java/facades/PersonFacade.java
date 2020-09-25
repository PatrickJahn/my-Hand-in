package facades;


import DTO.PersonDTO;
import DTO.PersonsDTO;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade implements IPersonFacade{

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public PersonDTO addPerson(String fName, String lName, String phone) {
         EntityManager em = getEntityManager();
         Person p = new Person(fName, lName, phone);
         em.getTransaction().begin();
         
         em.persist(p);
         
         em.getTransaction().commit();
        return new PersonDTO(p.getFirstName(), p.getLastName(), p.getPhone(), p.getId());

    }

    @Override
    public PersonDTO deletePerson(Long id) {
                 EntityManager em = getEntityManager();
        Person person = em.find(Person.class, id);

  em.getTransaction().begin();
  em.remove(person);
  em.getTransaction().commit();
  
  return new PersonDTO(person);
        
    }

    @Override
    public PersonDTO getPerson(Long id) {
        EntityManager em = getEntityManager();
     
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
       em.getTransaction().commit();
       PersonDTO pDTO;
       if (p != null){
        pDTO = new PersonDTO(p.getFirstName(), p.getLastName(), p.getPhone(), p.getId());
       } else {
         pDTO = new PersonDTO();
       }
           return pDTO;     

    }

    @Override
    public PersonsDTO getAllPersons() {
        EntityManager em = getEntityManager();
        TypedQuery<Person> tq = em.createQuery("SELECT p FROM Person p", Person.class);
        return new PersonsDTO(tq.getResultList());
        
    }

    @Override
    public PersonDTO editPerson(PersonDTO p) {
             EntityManager em = getEntityManager();
           Person pEdit =  em.find(Person.class, p.getId());
           
           if (p.getFirstName() != null){
            pEdit.setFirstName(p.getFirstName());
           }
  if (p.getLastName()!= null){
      pEdit.setLastName(p.getLastName());  
  }
  
             if (p.getPhone()!= null){  
              pEdit.setPhone(p.getPhone());
             }
             em.getTransaction().begin();
             em.persist(pEdit);
             em.getTransaction().commit();
               return new PersonDTO(pEdit);
    }
    
   
}