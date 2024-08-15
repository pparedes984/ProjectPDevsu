package com.example.projectP.accounttransactionService.entity;

import java.util.List;

public class AccountStatementReport {

    private List<Account> accounts;
    private List<Transaction> transactions;

    // Getters y setters

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

