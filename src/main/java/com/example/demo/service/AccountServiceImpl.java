package com.example.demo.service;

import com.example.demo.mapper.AccountMapper;
import com.example.demo.model.ErrorResponse;
import com.example.demo.model.dto.AccountDTO;
import com.example.demo.model.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.validator.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;

    AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    public AccountDTO editBalance(AccountDTO accountdto) {
        Optional<Account> optionalAccountDTO = accountRepository.findById(accountdto.getId());
        Account account = optionalAccountDTO.orElseThrow(() -> new NullPointerException("Customer's account has not found"));
        AccountDTO toAccountDTO = AccountMapper.INSTANCE.toAccountDTO(account);

        toAccountDTO.setBalance(toAccountDTO.getBalance().add(accountdto.getBalance()));
        if (toAccountDTO.getBalance().compareTo(BigDecimal.ZERO) >= 0) {
            account.setBalance(toAccountDTO.getBalance());
        } else {
            CustomerValidator customerValidator = new CustomerValidator();
            throw new IllegalArgumentException("you don't have enough balance for this process");
        }
        account.setUpdateDate(LocalDateTime.now());
        accountRepository.save(account);
        return toAccountDTO;
    }
}
