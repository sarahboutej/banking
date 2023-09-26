package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.TransactionDto;
import com.boutej.banking.models.Transaction;
import com.boutej.banking.models.TransactionType;
import com.boutej.banking.repositories.TransactionRepository;
import com.boutej.banking.services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  private final ObjectValidator<TransactionDto> validator;

  @Override
  public Integer save(TransactionDto dto) {
    validator.validate(dto);
    Transaction transaction = TransactionDto.toEntity(dto);
    BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getType()));
    BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
    transaction.setAmount(amount);
    return transactionRepository.save(transaction).getId();
  }

  @Override
  public TransactionDto findById(Integer id) {
    return transactionRepository.findById(id)
        .map(TransactionDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException("No transaction was found with the ID: " + id));

  }

  @Override
  public List<TransactionDto> findAll() {
    return transactionRepository.findAll()
                                .stream()
                                .map(TransactionDto::fromEntity)
                                .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    transactionRepository.deleteById(id);
  }

  private int getTransactionMultiplier(TransactionType type) {
    return TransactionType.TRANSFERT == type ? -1 : 1;
  }

}
