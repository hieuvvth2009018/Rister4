package com.example.t2009m1java.model.model;

import com.example.t2009m1java.entity.Account;
import com.example.t2009m1java.entity.myenum.AccountStatus;
import com.example.t2009m1java.model.AccountModel;
import com.example.t2009m1java.model.MySqlAccountModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MySqlAccountModelTest {

    private AccountModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlAccountModel();
    }

    @Test
    void save() {
        Account account = new Account();
        account.setUsername("hung01");
        account.setPassword("eyzxcv");
        account.setFullName("Hung");
        account.setStatus(AccountStatus.ACTIVE);
        model.save(account);
    }

    @Test
    void findAll() {
        List<Account> list = model.findAll();
        for (Account ac :
                list) {
            System.out.println(ac.toString());
        }
    }
}