package com.boutej.banking.controllers;

import com.boutej.banking.dto.ContactDto;
import com.boutej.banking.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

  private final ContactService contactService;

  @PostMapping("/")
  public ResponseEntity<Integer> save(@RequestBody ContactDto accountDto) {
    return ResponseEntity.ok(contactService.save(accountDto));
  }

  @GetMapping("/")
  public ResponseEntity<List<ContactDto>> findAll() {
    return ResponseEntity.ok(contactService.findAll());
  }

  @GetMapping("{account-id}")
  public ResponseEntity<ContactDto> findById(@PathVariable("contact-id") Integer contactId) {
    return ResponseEntity.ok(contactService.findById(contactId));
  }

  @DeleteMapping("/{account-id}")
  public ResponseEntity<Void> delete(@PathVariable("contact-id") Integer contactId) {
    contactService.delete(contactId);
    return ResponseEntity.accepted().build();
  }
}
