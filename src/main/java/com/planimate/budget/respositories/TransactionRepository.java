package com.planimate.budget.respositories;

import com.planimate.budget.entities.Transaction;
import com.planimate.budget.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}