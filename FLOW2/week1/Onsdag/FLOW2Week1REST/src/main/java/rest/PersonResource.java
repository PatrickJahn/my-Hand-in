package rest;

import DTO.PersonDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Person;
import utils.EMF_Creator;
import facades.PersonFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    
    private static final PersonFacade FACADE =  PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
   
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getById(@PathParam("id") long id) {
        PersonFacade pf = PersonFacade.getFacadeExample(EMF);
        PersonDTO personJS= pf.getPerson(id);
        if (personJS.getLastName() != null){
             return GSON.toJson(pf.getPerson(id));
    }
      
        return "{\"Person not found\":\" id not in Db\"}";
      
}
    
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        return GSON.toJson(FACADE.getAllPersons());
      
}
    
    @POST
    @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addPerson(String person){
        PersonDTO p = GSON.fromJson(person, PersonDTO.class);
        return GSON.toJson( FACADE.addPerson(p.getFirstName(), p.getLastName(), p.getPhone()));
}
    
    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String deletePerson(@PathParam("id") Long id){
        
        return GSON.toJson( FACADE.deletePerson(id));
}
    
    @PUT
    @Path("update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String updatePerson(@PathParam("id") Long id, String person){
        PersonDTO p = GSON.fromJson(person, PersonDTO.class);
        p.setId(id);
        return GSON.toJson( FACADE.editPerson(p));
}
}