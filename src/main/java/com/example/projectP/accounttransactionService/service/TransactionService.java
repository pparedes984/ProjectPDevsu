package com.example.projectP.accounttransactionService.service;

import com.example.projectP.accounttransactionService.entity.Account;
import com.example.projectP.accounttransactionService.entity.AccountStatementReport;
import com.example.projectP.accounttransactionService.entity.Transaction;
import com.example.projectP.accounttransactionService.exception.InsufficientFundsException;
import com.example.projectP.accounttransactionService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    // Crear una transacción
    public Transaction createTransaction(Transaction transaction) {
        Account account = transaction.getAccount();

        // Actualizar el saldo
        double newBalance = account.getInitialAmount() + transaction.getAmount();
        if (newBalance < 0) {
            throw new InsufficientFundsException("Saldo insuficiente para realizar la transacción");
        }

        account.setInitialAmount(newBalance);
        accountService.updateAccount(account.getId(), account);

        transaction.setBalance(newBalance);
        return transactionRepository.save(transaction);
    }

    // Obtener una transacción por ID
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Obtener todas las transacciones
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Actualizar una transacción
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        return transactionRepository.findById(id)
                .map(transaction -> {
                    transaction.setDate(updatedTransaction.getDate());
                    transaction.setType(updatedTransaction.getType());
                    transaction.setAmount(updatedTransaction.getAmount());
                    transaction.setBalance(updatedTransaction.getBalance());
                    return transactionRepository.save(transaction);
                })
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    // Eliminar una transacción
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }


}

