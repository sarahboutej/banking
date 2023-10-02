package com.boutej.banking.controllers;

import com.boutej.banking.dto.TransactionDto;
import com.boutej.banking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
  private final TransactionService transactionService;

  @PostMapping("/")
  public ResponseEntity<Integer> save(
      @RequestBody TransactionDto transactionDto
  ) {
    return ResponseEntity.ok(transactionService.save(transactionDto));
  }

  @GetMapping("/")
  public ResponseEntity<List<TransactionDto>> findAll() {
    return ResponseEntity.ok(transactionService.findAll());
  }

  @GetMapping("/{transaction-id}")
  public ResponseEntity<TransactionDto> findById(
      @PathVariable("transaction-id") Integer transactionId
  ) {
    return ResponseEntity.ok(transactionService.findById(transactionId));
  }

  @DeleteMapping("/{transaction-id}")
  public ResponseEntity<Void> delete(
      @PathVariable("transaction-id") Integer transactionId
  ) {
    transactionService.delete(transactionId);
    return ResponseEntity.accepted().build();
  }

}
