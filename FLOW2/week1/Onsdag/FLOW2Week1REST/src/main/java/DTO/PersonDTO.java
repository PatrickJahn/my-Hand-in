/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Person;

/**
 *
 * @author Patrick
 */
public class PersonDTO {
    
    
    private Long id;
     private String firstName;
    private String lastName;
    private String phone;

    
    public PersonDTO(){}
    
        public PersonDTO(Person p){
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.phone = p.getPhone();
                
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

    
}
