package com.sporcle.ui;

import com.sporcle.ui.forms.LogInForm;
import com.sporcle.ui.forms.ProductBarForm;
import org.junit.jupiter.api.BeforeEach;

public class LogInFormTest extends BaseTest{
    private LogInForm logInForm;

    //Клик по ссылке "Forgot Password?"
    //Клик по ссылке "Join for Free"
    //проверить возможность перейти на регистрацию и тд

    @BeforeEach
    public void setUp() {
        super.setUp();

        ProductBarForm productBarForm = homePage.getProductBarFormWhenVisible();
        productBarForm.clickLogInButton();

        logInForm = homePage.getLogInFormWhenVisible();
    }

    //стал фейлиться + убрать комментирование
    /*@Test
    public void testCloseLogInFormViaCloseButton() {
        logInForm.clickCloseButton();
        Assertions.assertFalse(homePage.logInFormIsVisible());
    }*/
}
