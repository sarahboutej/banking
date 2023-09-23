package com.boutej.banking.dto;

import com.boutej.banking.models.Transaction;
import com.boutej.banking.models.TransactionType;
import com.boutej.banking.models.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Sara Boutej
 * @since 22.09.2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {

  private Integer id;

  private BigDecimal amount;

  private TransactionType type;

  private String destinationIban;

  private LocalDateTime transactionDate;

  private Integer userId;

  public static TransactionDto fromEntity(Transaction transaction) {
    return TransactionDto.builder()
                         .id(transaction.getId())
                         .amount(transaction.getAmount())
                         .type(transaction.getType())
                         .destinationIban(transaction.getDestinationIban())
                         .userId(transaction.getUser().getId())
                         .build();
  }

  public static Transaction toEntity(TransactionDto transactionDto) {
    return Transaction.builder()
                      .id(transactionDto.getId())
                      .amount(transactionDto.getAmount())
                      .type(transactionDto.getType())
                      .destinationIban(transactionDto.getDestinationIban())
                      .user(User.builder()
                                .id(transactionDto.getUserId())
                                .build())
                      .build();
  }

}
