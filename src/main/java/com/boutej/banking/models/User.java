package com.boutej.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User extends AbstractEntity{

  private String firstName;

  private String lastName;

  @Column(unique = true)
  private String email;

  private String password;

  private boolean active;

  @OneToMany(mappedBy = "user")
  private List<Transaction> transactions;

  @OneToMany(mappedBy = "user")
  private List<Contact> contacts;

  @OneToOne
  private Address address;

  @OneToOne
  private Account account;

  @OneToOne
  private Role role;
}
