/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import entity.Point;
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
public class Main {
    
    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
  
        
        
        em.getTransaction().begin();
        for (int i = 0; i< 1000; i++){
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();
        
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total point: " + q1.getSingleResult());
        
         Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());
        
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results){
            System.out.println(p);
        }
        
        // Close the DB connection
        em.close();
        emf.close();
        
        
    }
    
    
    
}
