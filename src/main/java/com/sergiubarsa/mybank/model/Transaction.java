package com.sergiubarsa.mybank.model;

public class Transaction {
    private int id;
    private int amount;
    private String timestamp;
    private String reference;

    public Transaction(int amount, int id, String reference, String timestamp) {
        this.amount = amount;
        this.id = id;
        this.reference = reference;
        this.timestamp = timestamp;
    }
}
