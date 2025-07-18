package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.model.BankAccount;
import com.bankapp.repository.BankAccountRepository;

@SpringBootApplication
public class SimpleBankingApplication implements CommandLineRunner {

    @Autowired
    private BankAccountRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SimpleBankingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Initialize one bank account with 0 balance
        if (repository.count() == 0) {
            BankAccount account = new BankAccount();
            account.setBalance(0);
            repository.save(account);
            System.out.println("Initialized bank account with ID: " + account.getId());
        }
    }
}
