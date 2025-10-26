package com.sergiubarsa.mybank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sergiubarsa.mybank.services.TransactionService;

import java.time.Clock;

public class Application {

    public static TransactionService transactionService = new TransactionService(Clock.systemDefaultZone());
    public static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}
