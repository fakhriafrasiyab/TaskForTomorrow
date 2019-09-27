package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.mapper.ModelMapperClass;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    ModelMapperClass modelMapperClass;

    @GetMapping(value = "/all")
    public List<Customer> getAll() {
        return customerService.getCustomers();
    }

    @PostMapping(value = "/add")
    public List<CustomerDTO> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        //System.out.println(customerDTO.getName());
        modelMapperClass = new ModelMapperClass();
        Customer customer = modelMapperClass.convertToEntity(customerDTO);
        Customer customerCreated = (Customer) customerService.addCustomer(customer);
        return (List<CustomerDTO>) modelMapperClass.convertDto(customerCreated);
    }

    @DeleteMapping(value = "/delete/{id}")
    public List<Customer> deleteCustomer(@PathVariable("id") int id) {
        return customerService.deleteCustomer(id);
    }

    @PutMapping(value = "/update/{id}")
    public List<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
}
