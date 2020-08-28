package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CustomerDTO;
import entities.BankCustomer;
import facades.FacadeBankCustomer;
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


@Path("bankcustomer")
public class BankCustomerResource {

    //NOTE: Change Persistence unit name according to your setup
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    FacadeBankCustomer facade =  FacadeBankCustomer.getFacadeExample(emf);
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.setPrettyPrinting().create();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }
    
    
    @GET
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public String getByID(@PathParam("id") int id){
        CustomerDTO customer = facade.getCustomerByID(id);
        
         return gson.toJson(customer, CustomerDTO.class);
            }
    
    @GET
    @Path("all")
    @Consumes({MediaType.APPLICATION_JSON})
    public String getallCustomers(){
        List<BankCustomer> customers = facade.getAllBankCustomers();
        String res ="";
        for (BankCustomer b : customers) {
            res += gson.toJson(b, BankCustomer.class) + "\n";
        }
       //  return "All Bank customers: " + gson.toJson(customers, BankCustomer.class);
     return res;     
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(BankCustomer entity, @PathParam("id") int id) {
        
    }
}
