package com.example.demo.model.dto;

import com.example.demo.model.entity.Account;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CustomerDTO {
    @NotNull(message = "cannot be null")
    private int id;

    @NotNull(message = "Please provide a name")
    @Size(min = 2, max = 12, message = "Name should have at least 2 characters")
    private String name;

    private List<Account> accounts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
