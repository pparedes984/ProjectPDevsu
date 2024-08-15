package com.example.projectP.accounttransactionService.repository;

import com.example.projectP.accounttransactionService.entity.Account;
import com.example.projectP.accounttransactionService.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
