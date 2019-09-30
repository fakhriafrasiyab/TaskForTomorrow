package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "accountant_name")
//    @NotNull(message = "Please provide a name")
  //  @Size(min = 2, max = 12, message = "Name should have at least 2 characters")
    private String accountant_name;

    @Column(name = "balance")
    private String balance;

    @ManyToOne
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

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
}
