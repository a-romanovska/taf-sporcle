package com.sporcle.api;

import com.sporcle.api.pages.LogInPage;
import com.sporcle.enums.ErrorMessage;
import com.sporcle.enums.FileExtension;
import com.sporcle.enums.Symbol;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailedLogInTest extends BaseTest {
    private final String credentialsSource = "incorrectCredentials" + FileExtension.PROPERTIES.getExtension();
    private final String setWithEmailAndPassword = "set0";
    private final String setWithEmailOnly = "set1";
    private final String setWithPasswordOnly = "set2";
    private final String setWithoutEmailAndPassword = "set3";

    @Test
    public void testLoginWithIncorrectEmailAndIncorrectPassword() {
        logger.info("Start testLoginWithIncorrectEmailAndIncorrectPassword");
        LogInPage loginPage = new LogInPage(credentialsSource, setWithEmailAndPassword);

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(ErrorMessage.LOGIN_INCORRECT_INFORMATION_GENERAL.getMessage(), loginPage.getErrorText()),
                () -> assertEquals(ErrorMessage.LOGIN_INCORRECT_INFORMATION.getMessage(), loginPage.getErrorMessageForEmail()),
                () -> assertEquals(ErrorMessage.LOGIN_INCORRECT_INFORMATION.getMessage(), loginPage.getErrorMessageForPassword())
        );
    }

    @Test
    public void testLoginWithIncorrectEmailAndEmptyPassword() {
        logger.info("Start testLoginWithIncorrectEmailAndEmptyPassword");
        LogInPage loginPage = new LogInPage(credentialsSource, setWithEmailOnly);

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(ErrorMessage.LOGIN_MISSING_EMAIL_OR_PASSWORD.getMessage(), loginPage.getErrorText()),
                () -> assertEquals(Symbol.EMPTY.getSymbol(), loginPage.getErrorMessageForEmail()),
                () -> assertEquals(ErrorMessage.LOGIN_MISSING_PASSWORD.getMessage(), loginPage.getErrorMessageForPassword())
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndIncorrectPassword() {
        logger.info("Start testLoginWithEmptyEmailAndIncorrectPassword");
        LogInPage loginPage = new LogInPage(credentialsSource, setWithPasswordOnly);

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(ErrorMessage.LOGIN_MISSING_EMAIL_OR_PASSWORD.getMessage(), loginPage.getErrorText()),
                () -> assertEquals(ErrorMessage.LOGIN_MISSING_EMAIL.getMessage(), loginPage.getErrorMessageForEmail()),
                () -> assertEquals(Symbol.EMPTY.getSymbol(), loginPage.getErrorMessageForPassword())
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        logger.info("Start testLoginWithEmptyEmailAndEmptyPassword");
        LogInPage loginPage = new LogInPage(credentialsSource, setWithoutEmailAndPassword);

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(ErrorMessage.LOGIN_MISSING_EMAIL_OR_PASSWORD.getMessage(), loginPage.getErrorText()),
                () -> assertEquals(ErrorMessage.LOGIN_MISSING_EMAIL.getMessage(), loginPage.getErrorMessageForEmail()),
                () -> assertEquals(ErrorMessage.LOGIN_MISSING_PASSWORD.getMessage(), loginPage.getErrorMessageForPassword())
        );
    }
}
