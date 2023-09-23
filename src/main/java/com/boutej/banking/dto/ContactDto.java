package com.boutej.banking.dto;

import com.boutej.banking.models.Contact;
import com.boutej.banking.models.User;
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
public class ContactDto {

  private Integer id;

  private String firstName;

  private String lastName;

  private String email;

  private String iban;

  private Integer userId;

  public static ContactDto fromEntity(Contact contact) {
    return ContactDto.builder()
                     .id(contact.getId())
                     .firstName(contact.getFirstName())
                     .lastName(contact.getLastName())
                     .email(contact.getEmail())
                     .iban(contact.getIban())
                     .userId(contact.getUser().getId())
                     .build();
  }

  public static Contact toEntity(ContactDto contactDto) {
    return Contact.builder()
                  .id(contactDto.getId())
                  .firstName(contactDto.getFirstName())
                  .lastName(contactDto.getLastName())
                  .email(contactDto.getEmail())
                  .iban(contactDto.getIban())
                  .user(User.builder()
                            .id(contactDto.getUserId())
                            .build())
                  .build();
  }

}
