package com.bankapp.service;

public interface BankAccountService {
    double deposit(Long id, double amount);
    double withdraw(Long id, double amount);
    double getBalance(Long id);
}
