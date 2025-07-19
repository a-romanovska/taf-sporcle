package com.sporcle.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogInFormTest extends BaseTest {
    //Клик по ссылке "Forgot Password?"
    //Клик по ссылке "Join for Free"
    //проверить возможность перейти на регистрацию и тд

    @BeforeEach
    public void setUp() {
        openLogInForm();
    }

    @Test
    public void testCloseLogInFormViaCloseButton() {
        logInForm.clickCloseButton();
        Assertions.assertTrue(homePage.logInFormIsInvisible());
    }
}
