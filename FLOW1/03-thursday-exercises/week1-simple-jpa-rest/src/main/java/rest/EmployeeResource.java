package rest;

import com.google.gson.Gson;
import dto.EmployeeDTO;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("employee")
public class EmployeeResource {
    
    //NOTE: Change Persistence unit name according to your setup
   
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    EmployeeFacade facade =  EmployeeFacade.getFacadeExample(emf);
   static Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
       
        Employee emp = facade.createEmployee("Bo", "lykkevej", 200000);
        System.out.println(emp.toString());
            System.out.println("NEXT");
        List<Employee> emps = facade.getAllEmployees();
        for (Employee e : emps){
            System.out.println(e.toString());
        }
           System.out.println("NEXT");
         Employee emp2 = facade.getEmployeeById(emp.getId());
         System.out.println(emp2.toString());
                    System.out.println("NEXT");
              System.out.println(facade.getEmployeeWithHighestSalary().toString());
              facade.getEmployeesByName("bo");

        return "{\"msg\":\"succes\"}";
    }
    
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllEmps(){
        
         List<Employee> emps = facade.getAllEmployees();
        List<EmployeeDTO> dtoEmps = new ArrayList<EmployeeDTO>();
  
        System.out.println(emps.toString());
        for (Employee e : emps){
            dtoEmps.add(new EmployeeDTO(e));
        }
         
        return gson.toJson(dtoEmps);
    }
  
    @GET
    @Path("highestpaid")
    @Produces({MediaType.APPLICATION_JSON})
    public String gethighestPaid(){
        
         List<Employee> emps = facade.getEmployeeWithHighestSalary();
        List<EmployeeDTO> dtoEmps = new ArrayList<EmployeeDTO>();
  
        System.out.println(emps.toString());
        for (Employee e : emps){
            dtoEmps.add(new EmployeeDTO(e));
        }
         
        return "Highest paid: " + gson.toJson(dtoEmps);
    }
    
     @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getempbyID(@PathParam("id") int id){
        
       EmployeeDTO emp = new EmployeeDTO(facade.getEmployeeById(id));
         
        return "Employee by id: " + gson.toJson(emp);
    }
    
    @GET
    @Path("/name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getempbyID(@PathParam("name") String name){
        
       List<Employee> emps = facade.getEmployeesByName(name);
        List<EmployeeDTO> dtoEmps = new ArrayList<EmployeeDTO>();
        for (Employee e : emps){
            dtoEmps.add(new EmployeeDTO(e));
        } 
        
        return "Employees by name: " + gson.toJson(dtoEmps);
    }

    /*
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    */
    /*
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Employee entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
*/
}
