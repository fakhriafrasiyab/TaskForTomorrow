package com.example.demo.model.dto;

import com.example.demo.model.entity.Customer;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountDTO {

    @NotNull(message = "cannot be null")
    private int id;

    private String accountant_name;


    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;

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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
