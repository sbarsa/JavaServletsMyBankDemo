package com.sergiubarsa.mybank.services;

import com.sergiubarsa.mybank.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TransactionService {

    List<Transaction> transactions = new CopyOnWriteArrayList<>();
    private final Clock clock;
    private final String slogan;

    public TransactionService(Clock clock, @Value("${bank.slogan}") String slogan) {
        this.clock = clock;
        this.slogan = slogan;
    }

    public Transaction createTransaction(int amount, String reference) {
        Instant timestamp = clock.instant();
        UUID uuid = UUID.randomUUID();

        Transaction transaction = new Transaction(amount, uuid, reference, timestamp, slogan );

        transactions.add(transaction);

        return transaction;
    }

    public List<Transaction> findAll() {
        return Collections.unmodifiableList(transactions);
    }
}
