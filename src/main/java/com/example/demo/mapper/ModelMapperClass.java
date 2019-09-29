package com.example.demo.mapper;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import org.modelmapper.ModelMapper;

public class ModelMapperClass {

    public CustomerDTO convertDto(Customer customer) {
        CustomerDTO customerDTO = new ModelMapper().map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public Customer convertToEntity(CustomerDTO customerDTO) {
        Customer customer = new ModelMapper().map(customerDTO, Customer.class);
        return customer;
    }


}
