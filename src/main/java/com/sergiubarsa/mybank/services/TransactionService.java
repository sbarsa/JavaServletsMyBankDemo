package com.sergiubarsa.mybank.services;

import com.sergiubarsa.mybank.model.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public void createTransaction(int id, int amount, String timestamp, String reference) {
        Transaction transaction = new Transaction(id, amount, timestamp, reference);

        transactions.add(transaction);
    }

    public List<Transaction> findAll() {
        return Collections.unmodifiableList(transactions);
    }
}
