/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.PersonDTO;
import DTO.PersonsDTO;

/**
 *
 * @author Patrick
 */
public interface IPersonFacade {
    
   public PersonDTO addPerson(String fName, String lName, String phone);  
  public PersonDTO deletePerson(Long id);  
  public PersonDTO getPerson(Long id);  
  public PersonsDTO getAllPersons();  
  public PersonDTO editPerson(PersonDTO p); 

}
