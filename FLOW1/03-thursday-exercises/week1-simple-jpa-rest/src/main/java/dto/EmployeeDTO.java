/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author Patrick
 */
public class EmployeeDTO {
    
    public int id;
    public String name;
    public String address;
    
    
    public EmployeeDTO(Employee emp){
        this.id= emp.getId();
        this.name = emp.getName();
        this.address = emp.getAddress();
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "id=" + id + ", name=" + name + ", address=" + address + '}';
    }
    
    
    
}
