package com.example.projectP.accounttransactionService.controller;

import com.example.projectP.accounttransactionService.entity.AccountStatementReport;
import com.example.projectP.accounttransactionService.entity.Transaction;
import com.example.projectP.accounttransactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> getTransactionById(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.getTransactionById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTransaction) {
        return new ResponseEntity<>(transactionService.updateTransaction(id, updatedTransaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@GetMapping("/clients/{clientId}/report")
    public ResponseEntity<AccountStatementReport> getAccountStatementReport(
            @PathVariable Long clientId,
            @RequestParam String dateTransactionStart,
            @RequestParam String dateTransactionEnd) {

        AccountStatementReport report = transactionService.generateAccountStatementReport(clientId, dateTransactionStart, dateTransactionEnd);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }*/
}
