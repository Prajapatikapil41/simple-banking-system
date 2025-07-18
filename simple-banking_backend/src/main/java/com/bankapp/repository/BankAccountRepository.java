package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {}
