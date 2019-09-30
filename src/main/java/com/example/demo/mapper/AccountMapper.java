package com.example.demo.mapper;

import com.example.demo.dto.AccountDTO;
import com.example.demo.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO toAccountDTO(Account account);

    List<AccountDTO> toAccountDTOs(List<Account> accounts);

    Account toAccountEntity(AccountDTO accountDTO);

}
