package com.example.demo.mapper;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;


public interface SimpleSourceMapper {
    Customer customerToAccount(Account account);
    Account accountToCustomer(Customer customer);
}
