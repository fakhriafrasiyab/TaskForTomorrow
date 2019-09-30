package com.example.demo.controller;

import com.example.demo.dto.AccountDTO;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper.AccountMapperImpl;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.CustomerMapperImpl;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
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
        return ResponseEntity.ok(accountMapper.INSTANCE.toAccountDTOs(accountService.getAllCustomers()));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<AccountDTO> addCustomer(@RequestBody AccountDTO accountDTO) {
        accountService.save(accountMapper.INSTANCE.toAccountEntity(accountDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(accountDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> getCustomerById(@PathVariable("id") int id) {
        Optional<Account> customer = accountService.getCustomerById(id);
        return ResponseEntity.ok(accountMapper.INSTANCE.toAccountDTO(customer.get()));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AccountDTO> updateCustomer(@PathVariable("id") int id, @RequestBody AccountDTO accountDTO) {
        Account customer = accountMapper.INSTANCE.toAccountEntity(accountDTO);
        customer.setId(id);
        accountService.save(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
