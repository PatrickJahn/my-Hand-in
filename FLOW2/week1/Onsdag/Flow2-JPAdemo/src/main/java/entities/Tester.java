/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DTO.PersonStyleDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Patrick
 */
public class Tester {
    
    public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();
    
    
    Person p1 = new Person("Jønke", 1994);
    Person p2 = new Person("Blondie", 1987);
    
    Address a1 = new Address("Njalsgade 22", 2300, "Copenhagen");
    Address a2 = new Address("Bredgade 12", 2200, "Copenhagen");

    p1.setAddress(a1);
    p2.setAddress(a2);
    
    Fee f1 = new Fee(200);
    Fee f2 = new Fee(500);
    Fee f3 = new Fee(100);
    
    p1.addFee(f1);
    p2.addFee(f2);
    p1.addFee(f3);
        
    SwimStyle s1 = new SwimStyle("Crawl");
    SwimStyle s2 = new SwimStyle("Butterfly");
    SwimStyle s3 = new SwimStyle("BreastStroke");

    p1.addStyles(s1);
    p1.addStyles(s3);
    p2.addStyles(s2);
    
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        
        System.out.println("p1:  " + p1.getP_id()+ " " + p1.getName());
        System.out.println("p2:  " + p2.getP_id()+ " " + p2.getName());
        System.out.println("Jønkes gade:  " + p1.getAddress().getStreet());
        System.out.println("p1:  " + p1.getP_id()+ " " + p1.getName());
        System.out.println("Lad os se om tovejs virker address1: " + a1.getPerson().getName());
        System.out.println("Hvem har betlat f2: " + f2.getPerson().getName());
        System.out.println("Hvad er der blevet bletalt i alt?");
       
        TypedQuery<Fee> q1 = em.createQuery("SELECT f FROM Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();
        
        for(Fee f : fees){
            System.out.println(f.getPerson().getName() + " har betalt " + f.getAmount() + " på dateon " + f.getPayDate() + " Han har addressen: " + f.getPerson().getAddress().getStreet());
        }        
        
        
        // Fjerne s3 fra p1:
        em.getTransaction().begin();
            p1.removeSwimStyle(s3);
        em.getTransaction().commit();
        
        
        
        TypedQuery<Person> q2 = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = q2.getResultList();
        
        for(Person p : persons){
            System.out.println("Navn: " + p.getName());
            System.out.println("Fees:");
            for (Fee f : p.getFees()){
                System.out.println("-- Beløb: " + f.getAmount());
            }
           System.out.println("Styles:");
            for (SwimStyle sw : p.getStyles()){
                System.out.println("-- Style: " + sw.getStyleName());
            }
           

        }
        
        
        /** Onsdags excersice herfra og ned */ 
        
        // Create JQP with contructer projections
        // Lettere for applicationen at køre, da det ikke er managed objecter som ovenfor, hvor man kan gå ned og ændre i DB'en via dem.  
        Query q3 = em.createQuery("SELECT new DTO.PersonStyleDTO(p.name, p.year, s.styleName) FROM Person p JOIN p.styles s ");
   
        List<PersonStyleDTO> personDetails = q3.getResultList();
        
        for (PersonStyleDTO p : personDetails){
            System.out.println("Navn: " + p.getName() + ", " + p.getYear() + ", "+ p.getSwimStyle());
        }
        
    }
    
    
}
