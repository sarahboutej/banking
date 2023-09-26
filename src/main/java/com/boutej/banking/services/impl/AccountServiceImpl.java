package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.Validators.OperationNonPermittedException;
import com.boutej.banking.dto.AccountDto;
import com.boutej.banking.models.Account;
import com.boutej.banking.repositories.AccountRepository;
import com.boutej.banking.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  private final ObjectValidator<AccountDto> validator;

  @Override
  public Integer save(AccountDto dto) {
    validator.validate(dto);
    Account account = AccountDto.toEntity(dto);
    boolean userHasAlreadyAnAccount = accountRepository.findByUserId(account.getUser().getId()).isPresent();
    if (userHasAlreadyAnAccount && account.getUser().isActive()) {
      throw new OperationNonPermittedException("the selected user has already an active account",
                                               "Create account",
                                               "Account service",
                                               "Account creation"
      );
    }
    // generate random IBAN when creating new account else do not update the IBAN
    if (dto.getId() == null) {
      account.setIban(generateRandomIban());
    }
    return accountRepository.save(account).getId();
  }

  @Override
  public AccountDto findById(Integer id) {
    return accountRepository.findById(id)
                            .map(AccountDto::fromEntity)
                            .orElseThrow(() -> new EntityNotFoundException("No account found"));

  }

  @Override
  public List<AccountDto> findAll() {
    return accountRepository.findAll()
                            .stream()
                            .map(AccountDto::fromEntity)
                            .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    accountRepository.deleteById(id);
  }

  private String generateRandomIban() {
    // generate an iban
    String iban = Iban.random(CountryCode.DE).toFormattedString();
    // check if iban is already exist
    boolean ibanExists = accountRepository.findByIban(iban).isPresent();
    if (ibanExists) {
      generateRandomIban();
    }
    return iban;
  }
}
