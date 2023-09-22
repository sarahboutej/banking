package com.boutej.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction extends AbstractEntity{

  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private TransactionType type;

  private String destinationIban;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

}
