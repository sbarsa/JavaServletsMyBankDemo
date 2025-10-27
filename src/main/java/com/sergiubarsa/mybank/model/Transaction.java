package com.sergiubarsa.mybank.model;

import java.time.Instant;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private int amount;
    private Instant timestamp;
    private String reference;
    private String slogan;

    public Transaction(int amount, UUID id, String reference, Instant timestamp, String slogan) {
        this.amount = amount;
        this.id = id;
        this.reference = reference;
        this.timestamp = timestamp;
        this.slogan = slogan;
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

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getSlogan() {
        return slogan;
    }
}
