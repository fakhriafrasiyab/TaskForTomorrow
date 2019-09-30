package com.example.demo.service;


import com.example.demo.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAllCustomers();

    void deleteAccount(int id);

    Optional<Account> getCustomerById(int id);

    Account save(Account account);
}
