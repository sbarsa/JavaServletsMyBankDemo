package com.sergiubarsa.mybank.model;

import java.util.UUID;

public class Transaction {
    private UUID id;
    private int amount;
    private String timestamp;
    private String reference;

    public Transaction(int amount, UUID id, String reference, String timestamp) {
        this.amount = amount;
        this.id = id;
        this.reference = reference;
        this.timestamp = timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public UUID getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
