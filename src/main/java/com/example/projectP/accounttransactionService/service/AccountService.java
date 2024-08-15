package com.example.projectP.accounttransactionService.service;

import com.example.projectP.accounttransactionService.entity.Account;
import com.example.projectP.accounttransactionService.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Crear una cuenta
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Obtener una cuenta por ID
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Obtener todas las cuentas
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Actualizar una cuenta
    public Account updateAccount(Long id, Account updatedAccount) {
        return accountRepository.findById(id)
                .map(account -> {
                    account.setNumber(updatedAccount.getNumber());
                    account.setType(updatedAccount.getType());
                    account.setInitialAmount(updatedAccount.getInitialAmount());
                    account.setActive(updatedAccount.isActive());
                    return accountRepository.save(account);
                })
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // Eliminar una cuenta
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}
