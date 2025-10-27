package com.sergiubarsa.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergiubarsa.mybank.context.ApplicationConfiguration;
import com.sergiubarsa.mybank.model.Transaction;
import com.sergiubarsa.mybank.services.TransactionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class MyBankServlet extends HttpServlet {

    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        transactionService = ctx.getBean(TransactionService.class);
        objectMapper = ctx.getBean(ObjectMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            List<Transaction> allTransactions = transactionService.findAll();

            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(objectMapper.writeValueAsString(allTransactions));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            int amount = Integer.parseInt(req.getParameter("amount"));
            String reference = req.getParameter("reference");
            transactionService.createTransaction(amount, reference);
        }
    }

}
