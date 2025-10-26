package com.sergiubarsa.mybank.services;

import com.sergiubarsa.mybank.model.Transaction;

import java.time.Clock;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    List<Transaction> transactions = new CopyOnWriteArrayList<>();
    private final Clock clock;

    public TransactionService(Clock clock) {
        this.clock = clock;
    }

    public void createTransaction(int amount, String reference) {
        Instant timestamp = clock.instant();
        UUID uuid = UUID.randomUUID();
        Transaction transaction = new Transaction(amount, uuid, reference, timestamp);

        transactions.add(transaction);
    }

    public List<Transaction> findAll() {
        return Collections.unmodifiableList(transactions);
    }
}
