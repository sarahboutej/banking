package com.boutej.banking.repositories;

import com.boutej.banking.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findByName(String roleName);
}
