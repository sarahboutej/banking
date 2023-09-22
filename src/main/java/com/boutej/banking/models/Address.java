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
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AbstractEntity{

  private String street;

  private Integer houseNumber;

  private Integer zipCode;

  private String city;

  private String country;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;
}
