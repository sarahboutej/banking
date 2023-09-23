package com.boutej.banking.services.impl;

import com.boutej.banking.Validators.ObjectValidator;
import com.boutej.banking.dto.UserDto;
import com.boutej.banking.repositories.UserRepository;
import com.boutej.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository           userRepository;

  private final ObjectValidator<UserDto> validator;

  @Override
  public Integer save(UserDto dto) {
    return null;
  }

  @Override
  public UserDto findById(Integer id) {
    return null;
  }

  @Override
  public List<UserDto> findAll() {
    return null;
  }

  @Override
  public void delete(Integer id) {

  }
}
