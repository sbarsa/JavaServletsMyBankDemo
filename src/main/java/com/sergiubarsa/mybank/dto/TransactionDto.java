package com.sergiubarsa.mybank.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TransactionDto {


    @Min(10)
    @Max(100)
    private int amount;

    @NotBlank
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
