package com.example.demo.service;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public List<Customer> deleteCustomer(int id) {
        customerRepository.deleteById(id);
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> updateCustomer(int id, Customer customer) {
        customer.setId(id);
        customerRepository.save(customer);
        return customerRepository.findAll();
    }


}
