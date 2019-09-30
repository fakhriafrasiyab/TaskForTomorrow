package com.example.demo.mapper;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toCustomerDTO(Customer customer);

    List<CustomerDTO> toCustomerDTOs(List<Customer> customers);

    Customer toCustomerEntity(CustomerDTO customerDTO);

}
