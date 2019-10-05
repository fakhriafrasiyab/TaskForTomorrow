package com.example.demo.controller;

import com.example.demo.model.dto.CustomerDTO;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.CustomerMapperImpl;
import com.example.demo.model.entity.Customer;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/customers")
@Validated
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
    }

    @PostMapping(value = "/add")
    public ResponseEntity<CustomerDTO> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        customerService.save(customerMapper.INSTANCE.toCustomerEntity(customerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") @NotBlank(message = "cannot be empty") int id) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerMapper.INSTANCE.toCustomerDTO(optionalCustomer.get()));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") @NotBlank int id, @Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.INSTANCE.toCustomerEntity(customerDTO);
        customer.setId(id);
        customerService.save(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") @NotNull int id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
