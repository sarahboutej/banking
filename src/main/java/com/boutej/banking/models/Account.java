package com.boutej.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends AbstractEntity{

  private String iban;

  @OneToOne
  @JoinColumn(name="user_id")
  private User user;

}
