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
public class Contact extends AbstractEntity{

  private String firstName;

  private String lastName;

  @Column(unique = true)
  private String email;

  private String iban;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToOne
  private Account account;
}
