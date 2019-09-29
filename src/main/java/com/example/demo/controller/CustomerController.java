package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.mapper.ModelMapperClass;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/all")
    public List<Customer> getAll() {
        return customerService.getCustomers();
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public List<CustomerDTO> addCustomer(@Valid @RequestBody List<CustomerDTO> customerDTOList) {
        ModelMapperClass modelMapperClass = new ModelMapperClass();
        List<Customer> customerList = new ArrayList<>();

        for (CustomerDTO customerDTO: customerDTOList){
            Customer customer = modelMapperClass.convertToEntity(customerDTO);
            Customer customerCreated = customerService.addCustomer(customer);
            customerList.add(customerCreated);
        }

        List<CustomerDTO> custDTOList = new ArrayList<>();
        for (Customer customer: customerList){
            custDTOList.add(modelMapperClass.convertDto(customer));
        }

        return custDTOList;
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
