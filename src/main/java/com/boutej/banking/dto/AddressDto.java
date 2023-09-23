package com.boutej.banking.dto;

import com.boutej.banking.models.Address;
import com.boutej.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sara Boutej
 * @since 12.09.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

  private Integer id;

  private String street;

  private Integer houseNumber;

  private Integer zipCode;

  private String city;

  private String country;

  private Integer userId;

  public static AddressDto fromEntity(Address address) {
    return AddressDto.builder()
                     .id(address.getId())
                     .street(address.getStreet())
                     .houseNumber(address.getHouseNumber())
                     .zipCode(address.getZipCode())
                     .city(address.getCity())
                     .country(address.getCountry())
                     .userId(address.getUser().getId())
                     .build();
  }

  public static Address toEntity(AddressDto addressDto) {
    return Address.builder()
                  .id(addressDto.getId())
                  .street(addressDto.getStreet())
                  .houseNumber(addressDto.getHouseNumber())
                  .zipCode(addressDto.getZipCode())
                  .city(addressDto.getCity())
                  .country(addressDto.getCountry())
                  .user(User.builder()
                            .id(addressDto.getUserId())
                            .build())
                  .build();
  }

}
