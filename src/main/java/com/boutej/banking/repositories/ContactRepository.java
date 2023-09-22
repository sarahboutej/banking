package com.boutej.banking.repositories;

import com.boutej.banking.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {

  List<Contact> findAllByUserId(Integer userId);
}
