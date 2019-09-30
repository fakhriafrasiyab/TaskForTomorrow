package com.example.demo.dto;

import com.example.demo.model.Customer;
import lombok.Data;

@Data
public class AccountDTO {

    private int id;

    private String accountant_name;

    private String balance;

    private Customer customer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountant_name() {
        return accountant_name;
    }

    public void setAccountant_name(String accountant_name) {
        this.accountant_name = accountant_name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
