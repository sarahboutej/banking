package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.ContactDto;
import com.boutej.banking.dto.TransactionDto;
import com.boutej.banking.repositories.ContactRepository;
import com.boutej.banking.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  private final ContactRepository contactRepository;

  private final ObjectValidator<ContactDto> validator;

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
