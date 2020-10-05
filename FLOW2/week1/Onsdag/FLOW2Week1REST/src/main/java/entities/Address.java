/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Patrick
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private int zip;
    
    @OneToOne(mappedBy = "address", cascade = CascadeType.PERSIST)
    private Person person;
    
    public Address(){}
    
    public Address(String street, String city, int zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    
    
    
    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getZip() {
        return zip;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", city=" + city + ", zip=" + zip + ", person=" + person + '}';
    }
    
    
}
