package com.planimate.budget.services;

import com.planimate.budget.entities.Transaction;
import com.planimate.budget.entities.User;
import com.planimate.budget.respositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByUser(user);
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}