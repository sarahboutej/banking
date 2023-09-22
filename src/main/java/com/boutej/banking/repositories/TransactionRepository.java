package com.boutej.banking.repositories;

import com.boutej.banking.models.Transaction;
import com.boutej.banking.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

  List<Transaction> findAllByUserId(Integer userId);

  @Query("select sum(t.amount) from Transaction t where t.user.id = :userId")
  BigDecimal findAccountBalance(@Param("userId") Integer userId);

  @Query("select max(abs(t.amount)) as amount from Transaction t where t.user.id = :userId and t.type = :transactionType")
  BigDecimal findHighestAmountByTransactionType(Integer userId, TransactionType transactionType);
}
