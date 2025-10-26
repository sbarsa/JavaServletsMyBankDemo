package com.sergiubarsa.mybank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergiubarsa.mybank.services.TransactionService;

public class Application {

    public static TransactionService transactionService = new TransactionService();
    public static ObjectMapper objectMapper = new ObjectMapper();
}
