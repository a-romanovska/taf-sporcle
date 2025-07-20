package com.sporcle.api;

import com.sporcle.finals.Finals;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInTest extends BaseTest {
    @Test
    public void testLoginWithCorrectFormatEmailAndCorrectFormatPassword() {
        logger.info("Start testLoginWithCorrectFormatEmailAndCorrectFormatPassword");
        LogInForm loginPage = new LogInForm("Body-login", "set0");

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(LogInForm.INCORRECT_LOGIN_INFORMATION_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(LogInForm.INCORRECT_LOGIN_INFORMATION_MESSAGE, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(LogInForm.INCORRECT_LOGIN_INFORMATION_MESSAGE, loginPage.getErrorsPasswordMessage())//,
                //() -> assertEquals("email", loginPage.getErrorsEmailField()),//в проверке есть смысл только для поиск апо индексам
                //() -> assertEquals("password", loginPage.getErrorsPasswordField())//в проверке есть смысл только для поиск апо индексам
        );
    }

    @Test
    public void testLoginWithCorrectFormatEmailAndEmptyPassword() {
        logger.info("Start testLoginWithCorrectFormatEmailAndEmptyPassword");
        LogInForm loginPage = new LogInForm("Body-login", "set1");

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(LogInForm.MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(Finals.EMPTY_STRING, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(LogInForm.MISSING_PASSWORD_MESSAGE, loginPage.getErrorsPasswordMessage())//,
                //есть ли смысл проверять, что сообщения для емейла нет?
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndCorrectFormatPassword() {
        logger.info("Start testLoginWithEmptyEmailAndCorrectFormatPassword");
        LogInForm loginPage = new LogInForm("Body-login", "set2");

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(LogInForm.MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(LogInForm.MISSING_EMAIL_MESSAGE, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(Finals.EMPTY_STRING, loginPage.getErrorsPasswordMessage())
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        logger.info("Start testLoginWithEmptyEmailAndEmptyPassword");
        LogInForm loginPage = new LogInForm("Body-login", "set3");

        assertAll(
                () -> assertEquals(HttpURLConnection.HTTP_OK, loginPage.getStatusCode()),
                () -> assertEquals(LogInForm.MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(LogInForm.MISSING_EMAIL_MESSAGE, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(LogInForm.MISSING_PASSWORD_MESSAGE, loginPage.getErrorsPasswordMessage())
        );
    }

    /*@Test
    public void testLoginWithCorrectFormatEmailAndIncorrectFormatPassword() {

    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndCorrectFormatPassword() {

    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndIncorrectFormatPassword() {

    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndEmptyPassword() {

    }

    @Test
    public void testLoginWithEmptyEmailAndIncorrectFormatPassword() {

    }*/
}
