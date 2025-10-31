package com.sergiubarsa.mybank.web;

import com.sergiubarsa.mybank.model.Transaction;
import com.sergiubarsa.mybank.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyBankController {

    private final TransactionService transactionService;

    public MyBankController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> get() {
        return transactionService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction create(Transaction transaction) {
        return transactionService.createTransaction(transaction.getAmount(),transaction.getReference());
    }


}
