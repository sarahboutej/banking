package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.ContactDto;
import com.boutej.banking.dto.TransactionDto;
import com.boutej.banking.models.Contact;
import com.boutej.banking.repositories.ContactRepository;
import com.boutej.banking.services.ContactService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  private final ContactRepository contactRepository;

  private final ObjectValidator<ContactDto> validator;

  @Override
  public Integer save(ContactDto dto) {
    validator.validate(dto);
    Contact contact = ContactDto.toEntity(dto);
    return contactRepository.save(contact).getId();
  }

  @Override
  public ContactDto findById(Integer id) {

    return contactRepository.findById(id)
                            .map(ContactDto::fromEntity)
                            .orElseThrow(() -> new EntityNotFoundException("No contact was found with the ID :" + id));
  }

  @Override
  public List<ContactDto> findAll() {
    return contactRepository.findAll()
                            .stream()
                            .map(ContactDto::fromEntity)
                            .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    contactRepository.deleteById(id);
  }
}
