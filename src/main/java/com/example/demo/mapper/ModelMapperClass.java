package com.example.demo.mapper;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.modelmapper.ModelMapper;

import java.text.ParseException;


public class ModelMapperClass {

    CustomerService  customerService;
    ModelMapper modelMapper;

    public CustomerDTO convertDto(Customer customer) {
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        customerDTO.setName(customer.getName());
        customerDTO.setId(customer.getId());
        return customerDTO;
    }

    public Customer convertToEntity(CustomerDTO customerDTO)  {
        ModelMapper modelMapper2 =  new ModelMapper();
        Customer customer = modelMapper2.map(customerDTO, Customer.class);
        System.out.println(customer.getName());
        customer.setName(customerDTO.getName());
        customer.setId(customer.getId());
        return customer;
    }

//    public Customer toEntity(CustomerDTO customerDTO, Customer customer) {
//        customer.setName(customerDTO.getName());
//        customerRepository.save(customer);
//        return customer;
//    }
//
//    public CustomerDTO toDto(Customer customer) {
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setName(customer.getName());
//        return customerDTO;
//    }


}
