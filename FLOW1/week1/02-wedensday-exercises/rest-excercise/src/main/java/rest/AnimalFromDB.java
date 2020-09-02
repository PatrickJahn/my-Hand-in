/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entity.Animal;
import java.util.Random;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Patrick
 */
@Path("animals_db")
public class AnimalFromDB {

    @Context
    private UriInfo context;

     private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    /**
     * Creates a new instance of AnimalFromDB
     */
    public AnimalFromDB() {
    }


@GET
@Path("animals")
@Produces(MediaType.APPLICATION_JSON)
public String getAnimals() {
  EntityManager em = emf.createEntityManager();
  try{
    
      TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
     List<Animal> animals = query.getResultList();
      return new Gson().toJson(animals);
   } finally {
          em.close();
   }
}


@GET
@Path("animalbyid/{id}")
@Produces(MediaType.APPLICATION_JSON)
public String getAnimal(@PathParam("id") int id) {
  EntityManager em = emf.createEntityManager();
  try{
    
      Animal a = em.find(Animal.class, id);
    
      return new Gson().toJson(a);
   } finally {
          em.close();
   }
}

@GET
@Path("animalbytype/{type}")
@Produces(MediaType.APPLICATION_JSON)
public String getAnimal(@PathParam("type") String type) {
  EntityManager em = emf.createEntityManager();
  try{
    
     TypedQuery<Animal> tq = em.createQuery("SELECT a FROM Animal a WHERE a.type = " + "\""+ type+"\"", Animal.class);
     
    
      return tq.getSingleResult().toString();
   } finally {
          em.close();
   }
}



@GET
@Path("animalrandom")
@Produces(MediaType.APPLICATION_JSON)
public String getAnimal() {
  EntityManager em = emf.createEntityManager();
  try{
    
      TypedQuery<Long> count = em.createQuery("SELECT COUNT(a) FROM Animal a", Long.class);
      
    
    int max = Integer.parseInt(""+count.getSingleResult());
    int id = (int)(Math.random()*((max-1)+1))+1;

    
    Animal a = em.find(Animal.class, id);
    
    
      return  new Gson().toJson(a);
   } finally {
          em.close();
   }
}

}
