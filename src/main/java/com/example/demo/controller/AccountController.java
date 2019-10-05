package com.example.demo.controller;

import com.example.demo.model.ErrorResponse;
import com.example.demo.model.dto.AccountDTO;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper.AccountMapperImpl;
import com.example.demo.model.entity.Account;
import com.example.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Validated
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    AccountMapper accountMapper;

    public AccountController() {
        this.accountMapper = new AccountMapperImpl();
    }


    @GetMapping(value = "/all")
    public ResponseEntity<List<AccountDTO>> getAll() {
        return ResponseEntity.ok(accountMapper.INSTANCE.toAccountDTOs(accountService.getAllAccounts()));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<AccountDTO> addAccount(@Valid @RequestBody AccountDTO accountDTO) {
        accountService.save(accountMapper.INSTANCE.toAccountEntity(accountDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(accountDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable("id") int id) {
        Optional<Account> customer = accountService.getAccountById(id);
        return ResponseEntity.ok(accountMapper.INSTANCE.toAccountDTO(customer.get()));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable("id") int id, @Valid @RequestBody AccountDTO accountDTO)  {
        Account customer = accountMapper.INSTANCE.toAccountEntity(accountDTO);
        customer.setId(id);
        accountService.save(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteAccount(@PathVariable("id") int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PutMapping(value = "/editBalance")
    public AccountDTO editBalance(@Valid @RequestBody AccountDTO accountDTO)  {
        return accountService.editBalance(accountDTO);
    }
}
