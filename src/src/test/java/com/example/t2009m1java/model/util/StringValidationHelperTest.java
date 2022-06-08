package com.example.t2009m1java.model.util;

import com.example.t2009m1java.service.StringValidationHelper;
import org.junit.jupiter.api.Test;

class StringValidationHelperTest {

    @Test
    void checkValidVietnamesePhone() {
        System.out.println(StringValidationHelper.checkValidVietnamesePhone("0399388831JQK"));
    }
}