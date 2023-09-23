package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.AccountDto;
import com.boutej.banking.repositories.AccountRepository;
import com.boutej.banking.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  private final ObjectValidator<AccountDto> validator;

  @Override
  public Integer save(Object dto) {
    return null;
  }

  @Override
  public Object findById(Integer id) {
    return null;
  }

  @Override
  public List findAll() {
    return null;
  }

  @Override
  public void delete(Integer id) {

  }
}
