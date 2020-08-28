/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Patrick
 */
public class MakeTestData {
 
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(new BankCustomer("Carsten", "Johanson", "ax1234", 200000, 2, "Best customer ever"));
            em.persist(new BankCustomer("Lars", "Larsen", "ab2234", 2200000, 3, "Not the best but okay"));
            em.persist(new BankCustomer("Bob", "Byggemand", "ac4321", 10000, 1, "Number 1"));
            em.persist(new BankCustomer("Hans", "Hansen", "ax1234", 200000, 4, "About him..."));
            em.getTransaction().commit();
        
        
        }finally {
        em.close();
        }
    }
    
}
