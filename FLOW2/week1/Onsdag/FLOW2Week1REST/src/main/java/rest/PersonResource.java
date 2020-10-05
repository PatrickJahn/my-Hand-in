package rest;

import DTO.PersonDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Address;
import entities.Person;
import exceptions.MissingInputException;
import exceptions.PersonNotFoundException;
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
import javax.ws.rs.core.Response;

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
    public String getById(@PathParam("id") long id) throws PersonNotFoundException {
   
        PersonDTO personJS = FACADE.getPerson(id);
        
        return  GSON.toJson(personJS);
  
    
             
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
    public String addPerson(String person) throws MissingInputException{
       
        PersonDTO p = GSON.fromJson(person, PersonDTO.class);
        if (p.getFirstName() == null || p.getLastName() == null || p.getPhone() == null || p.getStreet() == null){
            throw new MissingInputException("First Name and/or Last Name and/or phone number and/or address is missing");
        }
        Address a = new Address(p.getStreet(), p.getCity(), p.getZip());
        return GSON.toJson( FACADE.addPerson(p.getFirstName(), p.getLastName(), p.getPhone(), a));
}
    
    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String deletePerson(@PathParam("id") Long id) throws PersonNotFoundException{
        PersonDTO p = FACADE.deletePerson(id);
        return GSON.toJson(p);
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