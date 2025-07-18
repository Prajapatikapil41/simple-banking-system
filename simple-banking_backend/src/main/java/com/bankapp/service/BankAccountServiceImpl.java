package com.bankapp.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.BankAccount;
import com.bankapp.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository repository;

    @Override
    public double deposit(Long id, double amount) {
        BankAccount account = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account Not Found!"));
        account.setBalance(account.getBalance() + amount);
        repository.save(account);
        return account.getBalance();
    }

    @Override
    public double withdraw(Long id, double amount) {
        BankAccount account = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account Not Found!"));
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient Balance");
        }
        account.setBalance(account.getBalance() - amount);
        repository.save(account);
        return account.getBalance();
    }

    @Override
    public double getBalance(Long id) {
        BankAccount account = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account Not Found!"));
        return account.getBalance();
    }
}
