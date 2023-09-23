package com.boutej.banking.dto;

import com.boutej.banking.models.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sara Boutej
 * @since 22.09.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

  private Integer id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private boolean active;

  private String iban;

  public static UserDto fromEntity(User user) {
    return UserDto.builder()
                  .id(user.getId())
                  .firstName(user.getFirstName())
                  .lastName(user.getLastName())
                  .email(user.getEmail())
                  .active(user.isActive())
                  .iban(user.getAccount() == null ? "" : user.getAccount().getIban())
                  .build();
  }

  public static User toEntity(UserDto userDto) {
    return User.builder()
               .id(userDto.getId())
               .firstName(userDto.getFirstName())
               .lastName(userDto.getLastName())
               .email(userDto.getEmail())
               .password(userDto.getPassword())
               .active(userDto.isActive())
               .build();
  }

}
