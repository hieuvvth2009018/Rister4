package com.example.t2009m1java.model.entity;

import com.example.t2009m1java.entity.Account;
import com.example.t2009m1java.entity.myenum.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    @BeforeEach
    void setUp() {
        System.out.println("Start running test.");
    }

    @Test
    public void testCreateAccount(){
        Account account = new Account();
        account.setStatus(AccountStatus.ACTIVE);
        System.out.println(account.toString());
    }
}