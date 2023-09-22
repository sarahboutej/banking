package com.boutej.banking.repositories;

import com.boutej.banking.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
