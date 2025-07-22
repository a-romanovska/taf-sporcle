package com.sporcle.api;

import com.sporcle.finals.ErrorMessages;
import com.sporcle.finals.Finals;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInTest extends BaseTest {
    private final String credentialsSource = "incorrectCredentials" + ".properties";
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
                () -> assertEquals(ErrorMessages.LOGIN_INCORRECT_INFORMATION_TEXT, loginPage.getErrorText()),
                () -> assertEquals(ErrorMessages.LOGIN_INCORRECT_INFORMATION, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(ErrorMessages.LOGIN_INCORRECT_INFORMATION, loginPage.getErrorsPasswordMessage())
        );
    }

    @Test
    public void testLoginWithIncorrectEmailAndEmptyPassword() {
        logger.info("Start testLoginWithIncorrectEmailAndEmptyPassword");
        LogInPage loginPage = new LogInPage(credentialsSource, setWithEmailOnly);

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(ErrorMessages.LOGIN_MISSING_EMAIL_OR_PASSWORD, loginPage.getErrorText()),
                () -> assertEquals(Finals.EMPTY_STRING, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(ErrorMessages.LOGIN_MISSING_PASSWORD, loginPage.getErrorsPasswordMessage())
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndIncorrectPassword() {
        logger.info("Start testLoginWithEmptyEmailAndIncorrectPassword");
        LogInPage loginPage = new LogInPage(credentialsSource, setWithPasswordOnly);

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(ErrorMessages.LOGIN_MISSING_EMAIL_OR_PASSWORD, loginPage.getErrorText()),
                () -> assertEquals(ErrorMessages.LOGIN_MISSING_EMAIL, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(Finals.EMPTY_STRING, loginPage.getErrorsPasswordMessage())
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        logger.info("Start testLoginWithEmptyEmailAndEmptyPassword");
        LogInPage loginPage = new LogInPage(credentialsSource, setWithoutEmailAndPassword);

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(ErrorMessages.LOGIN_MISSING_EMAIL_OR_PASSWORD, loginPage.getErrorText()),
                () -> assertEquals(ErrorMessages.LOGIN_MISSING_EMAIL, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(ErrorMessages.LOGIN_MISSING_PASSWORD, loginPage.getErrorsPasswordMessage())
        );
    }
}
