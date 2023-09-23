package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.TransactionDto;
import com.boutej.banking.repositories.TransactionRepository;
import com.boutej.banking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  private final ObjectValidator<TransactionDto> validator;

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
