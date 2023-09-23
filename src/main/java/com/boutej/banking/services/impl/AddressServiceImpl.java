package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.AddressDto;
import com.boutej.banking.repositories.AddressRepository;
import com.boutej.banking.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;

  private final ObjectValidator<AddressDto> validator;

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
