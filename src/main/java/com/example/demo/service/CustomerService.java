package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer addCustomer(Customer customer);

    List<Customer> deleteCustomer(int id);

    List<Customer> updateCustomer(int id, Customer customer);
}
