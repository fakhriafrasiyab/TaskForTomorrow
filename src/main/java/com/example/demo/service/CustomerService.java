package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    List<Customer> getAllCustomers();

    void deleteCustomer(int id);

    Optional<Customer> getCustomerById(int id);

    Customer save(Customer customer);


}
