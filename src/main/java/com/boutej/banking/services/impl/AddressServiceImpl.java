package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.AddressDto;
import com.boutej.banking.models.Address;
import com.boutej.banking.repositories.AddressRepository;
import com.boutej.banking.services.AddressService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository addressRepository;

  private final ObjectValidator<AddressDto> validator;

  @Override
  public Integer save(AddressDto dto) {
    validator.validate(dto);
    Address address = AddressDto.toEntity(dto);
    return addressRepository.save(address).getId();
  }

  @Override
  public AddressDto findById(Integer id) {
    return addressRepository.findById(id)
                            .map(AddressDto::fromEntity)
                            .orElseThrow(() -> new EntityNotFoundException("No address found with the ID : " + id));
  }

  @Override
  public List<AddressDto> findAll() {
    return addressRepository.findAll()
                            .stream()
                            .map(AddressDto::fromEntity)
                            .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    addressRepository.deleteById(id);
  }
}
