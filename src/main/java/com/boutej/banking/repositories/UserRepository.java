package com.boutej.banking.repositories;

import com.boutej.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
}
