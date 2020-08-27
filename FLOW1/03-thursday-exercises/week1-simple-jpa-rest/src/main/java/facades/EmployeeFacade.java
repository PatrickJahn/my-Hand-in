package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Employee;
import java.util.List;
import javax.persistence.TypedQuery;
/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private EmployeeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Employee getEmployeeById(int id){
        EntityManager em = getEntityManager();
        try {
            Employee emp = em.find(Employee.class, id);
            if (emp == null) {
               return new Employee();
            }
            return emp;
                         
        } finally {
            em.close();
        }
    }
    
        public List<Employee> getEmployeesByName(String name){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e WHERE e.name = " +"\""+ name+"\"", Employee.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }
        
        public List<Employee> getAllEmployees(){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e", Employee.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }
     
        public List<Employee> getEmployeeWithHighestSalary(){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Integer> tq = em.createQuery("SELECT MAX(e.salary) FROM Employee e", Integer.class);
            int sal = tq.getSingleResult();
             TypedQuery<Employee> tq2 = em.createQuery("SELECT e FROM Employee e WHERE e.salary = " + sal, Employee.class);
            return tq2.getResultList();
        } finally {
            em.close();
        }
    }
        
        public Employee createEmployee(String name, String address, int salary){
        EntityManager em = getEntityManager();
        Employee emp = new Employee(name, address, salary);
        try {
           em.getTransaction().begin();
           em.persist(emp);
           em.getTransaction().commit();
            return emp;
        } finally {
            em.close();
        }
    }
        
    /*
    
    getEmployeeById
getEmployeesByName
getAllEmployees
getEmployeesWithHighestSalary
createEmployee	

    */
}
