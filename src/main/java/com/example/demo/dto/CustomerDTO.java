package com.example.demo.dto;

import com.example.demo.model.Account;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerDTO {
    private int id;

    private String name;

    private Account account;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
