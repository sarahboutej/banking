package com.boutej.banking.controllers;

import com.boutej.banking.dto.UserDto;
import com.boutej.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/")
  public ResponseEntity<Integer> save(
      @RequestBody UserDto userDto
  ) {
    return ResponseEntity.ok(userService.save(userDto));
  }

  @GetMapping("/")
  public ResponseEntity<List<UserDto>> getAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/{user-id}")
  public ResponseEntity<UserDto> findById(
      @PathVariable("user-id") Integer userId
  ) {
    return ResponseEntity.ok(userService.findById(userId));
  }

  @DeleteMapping("/{user-id}")
  public ResponseEntity<Void> delete(
      @PathVariable("user-id") Integer userId
  ) {
    userService.delete(userId);
    return ResponseEntity.accepted().build();
  }
}
