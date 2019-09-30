package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.CustomerMapperImpl;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
//@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    CustomerMapper customerMapper;

    public CustomerController() {
        this.customerMapper = new CustomerMapperImpl();
    }


    @GetMapping(value = "/all")
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(customerMapper.INSTANCE.toCustomerDTOs(customerService.getAllCustomers()));
//        return ResponseEntity.ok((customerService.getAllCustomers()));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerMapper.INSTANCE.toCustomerEntity(customerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") int id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerMapper.INSTANCE.toCustomerDTO(customer.get()));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.INSTANCE.toCustomerEntity(customerDTO);
        customer.setId(id);
        customerService.save(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
