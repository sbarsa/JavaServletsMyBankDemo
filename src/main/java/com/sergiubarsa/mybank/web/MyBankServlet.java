package com.sergiubarsa.mybank.web;

import com.sergiubarsa.mybank.Application;
import com.sergiubarsa.mybank.model.Transaction;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MyBankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            List<Transaction> allTransactions = Application.transactionService.findAll();

            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(Application.objectMapper.writeValueAsString(allTransactions));
        }
    }
}
