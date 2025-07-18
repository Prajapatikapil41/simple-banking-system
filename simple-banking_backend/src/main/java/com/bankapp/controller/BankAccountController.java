package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.service.BankAccountService;

@RestController
@RequestMapping("/api/bank")
@CrossOrigin(origins = "*")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    // Deposit Money
    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accountId, @RequestParam double amount) {
        double balance = service.deposit(accountId, amount);
        return "Deposit successful. Current balance: ₹" + balance;
    }

    // Withdraw Money
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long accountId, @RequestParam double amount) {
        double balance = service.withdraw(accountId, amount);
        return "Withdraw successful. Current balance: ₹" + balance;
    }

    // Check Balance
    @GetMapping("/balance")
    public String getBalance(@RequestParam Long accountId) {
        double balance = service.getBalance(accountId);
        return "Current balance: ₹" + balance;
    }
}
