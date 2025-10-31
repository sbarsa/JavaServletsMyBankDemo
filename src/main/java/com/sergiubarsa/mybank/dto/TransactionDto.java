package com.sergiubarsa.mybank.dto;

public class TransactionDto {
    private int amount;

    private String reference;

    public int getAmount() {
        return amount;
    }

    public String getReference() {
        return reference;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
