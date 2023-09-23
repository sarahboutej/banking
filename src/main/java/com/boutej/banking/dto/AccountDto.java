package com.boutej.banking.dto;

import com.boutej.banking.models.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Sara Boutej
 * @since 22.09.2023
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

  private Integer id;

  private String iban;


  private UserDto user;

  public static AccountDto fromEntity(Account account) {
    return AccountDto.builder()
                     .id(account.getId())
                     .iban(account.getIban())
                     .user(UserDto.fromEntity(account.getUser()))
                     .build();
  }

  public static Account toEntity(AccountDto accountDto) {
    return Account.builder()
           .id(accountDto.getId())
           .iban(accountDto.getIban())
           .user(UserDto.toEntity(accountDto.getUser()))
           .build();
  }

}
