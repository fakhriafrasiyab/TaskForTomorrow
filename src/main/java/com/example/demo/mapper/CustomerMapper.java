package com.example.demo.mapper;

import com.example.demo.model.dto.CustomerDTO;
import com.example.demo.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = AccountMapper.class)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toCustomerDTO(Customer customer);

    List<CustomerDTO> toCustomerDTOs(List<Customer> customers);

    Customer toCustomerEntity(CustomerDTO customerDTO);

}
