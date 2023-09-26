package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.UserDto;
import com.boutej.banking.models.User;
import com.boutej.banking.repositories.UserRepository;
import com.boutej.banking.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final ObjectValidator<UserDto> validator;

  @Override
  public Integer save(UserDto userDto) {
    validator.validate(userDto);
    User user = UserDto.toEntity(userDto);
    return userRepository.save(user).getId();
  }

  @Override
  public UserDto findById(Integer id) {
    return userRepository.findById(id)
                         .map(UserDto::fromEntity)
                         .orElseThrow(() -> new EntityNotFoundException("No user was found with the provided ID : " + id));
  }

  @Override
  public List<UserDto> findAll() {
    return userRepository.findAll()
                         .stream().map(UserDto::fromEntity)
                         .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    userRepository.deleteById(id);
  }
}
