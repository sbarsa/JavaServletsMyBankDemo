package com.sergiubarsa.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sergiubarsa.mybank.services.TransactionService;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

public class ApplicationConfiguration {

    @Bean
    public TransactionService transactionService(Clock clock) {
        return new TransactionService(clock);
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return objectMapper;
    }
}
