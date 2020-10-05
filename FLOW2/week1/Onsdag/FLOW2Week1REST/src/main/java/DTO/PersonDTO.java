/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Address;
import entities.Person;
import java.util.Objects;

/**
 *
 * @author Patrick
 */
public class PersonDTO {
    

    private Long id;
     private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String street;
    private int zip;
    
    public PersonDTO(){}
    
        public PersonDTO(Person p){
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.phone = p.getPhone();
        this.city = p.getAddress().getCity();
        this.street = p.getAddress().getStreet();
        this.zip = p.getAddress().getZip();
                
                }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public PersonDTO(String firstName, String lastName, String phone, Long id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // For at indsætte adresse også
    public PersonDTO(String firstName, String lastName, String phone, String city, String street, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.zip = zip;
    }
    
    
 public PersonDTO(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getZip() {
        return zip;
    }

   
    

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonDTO other = (PersonDTO) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    
}
