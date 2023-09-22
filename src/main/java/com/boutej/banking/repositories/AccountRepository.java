package com.boutej.banking.repositories;

import com.boutej.banking.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

  Optional<Account> findByIban(String iban);

  Optional<Account> findByUserId(Integer userId);
}
