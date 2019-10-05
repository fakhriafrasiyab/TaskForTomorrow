package com.example.demo.service;


import com.example.demo.model.ErrorResponse;
import com.example.demo.model.dto.AccountDTO;
import com.example.demo.model.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAllAccounts();

    void deleteAccount(int id);

    Optional<Account> getAccountById(int id);

    Account save(Account account);

    AccountDTO editBalance(AccountDTO accountDTO);
}
