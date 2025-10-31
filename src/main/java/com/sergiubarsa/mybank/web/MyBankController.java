package com.sergiubarsa.mybank.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBankController {

    @GetMapping("/transactions")
    public void get() {
        System.out.println("got a get");
    }


}
