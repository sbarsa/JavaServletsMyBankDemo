package com.sergiubarsa.mybank.services;

import com.sergiubarsa.mybank.model.Transaction;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public void createTransaction(int amount, String reference) {
        Instant timestamp = Instant.now();
        UUID uuid = UUID.randomUUID();
        Transaction transaction = new Transaction(amount, uuid, reference, timestamp);

        transactions.add(transaction);
    }

    public List<Transaction> findAll() {
        return Collections.unmodifiableList(transactions);
    }
}
