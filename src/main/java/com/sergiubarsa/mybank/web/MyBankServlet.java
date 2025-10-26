package com.sergiubarsa.mybank.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyBankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print("Hello world");
        }
    }
}
