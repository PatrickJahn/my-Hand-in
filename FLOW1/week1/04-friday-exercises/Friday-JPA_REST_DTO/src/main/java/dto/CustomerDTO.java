/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;

/**
 *
 * @author Patrick
 */
public class CustomerDTO {
    
    int customerID;
    String fullName;
    String accountBumber;
    double balance;
    
  public CustomerDTO(){}
    
    public CustomerDTO(BankCustomer bc) {
        this.customerID = bc.getId();
        this.fullName = bc.getFirstName() + " " + bc.getLastName();
        this.accountBumber = bc.getAccountNumber();
        this.balance = bc.getBalance();
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccountBumber(String accountBumber) {
        this.accountBumber = accountBumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAccountBumber() {
        return accountBumber;
    }

    public double getBalance() {
        return balance;
    }
    
    
}
