package com.planimate.budget.controllers;

import com.planimate.budget.entities.Transaction;
import com.planimate.budget.entities.User;
import com.planimate.budget.services.TransactionService;
import com.planimate.budget.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;
    @GetMapping
    public List<Transaction> getAllTransactions(Principal principal) {
        User user = userService.findByEmail(principal.getName());
        return transactionService.getTransactionsByUser(user);
    }

    @PostMapping
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        transaction.setUser(user);
        transactionService.addTransaction(transaction);
        return ResponseEntity.ok("Transaction added!");
    }
}
