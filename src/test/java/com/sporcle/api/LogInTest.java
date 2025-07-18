package com.sporcle.api;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInTest {
    private Faker faker;
    private static String EMPTY_VALUE = "";
    private String email;
    private String password;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    @Test
    public void testLoginWithCorrectFormatEmailAndCorrectFormatPassword() {
        LogInModal loginPage = new LogInModal(email, password, true);

        assertAll(
                "Grouped Assertions of User",
                () -> assertEquals(200, loginPage.getStatusCode()),
                () -> assertEquals(LogInModal.ErrorTexts.INCORRECT_LOGIN_INFORMATION_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(LogInModal.ErrorTexts.INCORRECT_LOGIN_INFORMATION_MESSAGE, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(LogInModal.ErrorTexts.INCORRECT_LOGIN_INFORMATION_MESSAGE, loginPage.getErrorsPasswordMessage())//,
                //() -> assertEquals("email", loginPage.getErrorsEmailField()),//в проверке есть смысл только для поиск апо индексам
                //() -> assertEquals("password", loginPage.getErrorsPasswordField())//в проверке есть смысл только для поиск апо индексам
        );
    }

    @Test
    public void testLoginWithCorrectFormatEmailAndEmptyPassword() {//ввести только емейл
        LogInModal loginPage = new LogInModal(faker.internet().emailAddress(), "", false);

        assertAll(
                () -> assertEquals(200, loginPage.getStatusCode()),
                () -> assertEquals(LogInModal.ErrorTexts.MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(EMPTY_VALUE, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(LogInModal.ErrorTexts.MISSING_PASSWORD_MESSAGE, loginPage.getErrorsPasswordMessage())//,
                //есть ли смысл проверять, что сообщения для емейла нет?
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndCorrectFormatPassword() {//ввести только пароль
        LogInModal loginPage = new LogInModal("", faker.internet().password(), false);

        assertAll(
                () -> assertEquals(200, loginPage.getStatusCode()),
                () -> assertEquals(LogInModal.ErrorTexts.MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(LogInModal.ErrorTexts.MISSING_EMAIL_MESSAGE, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(EMPTY_VALUE, loginPage.getErrorsPasswordMessage())
        );
    }

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {//ввести ничего
        LogInModal loginPage = new LogInModal("", "", false);

        assertAll(
                () -> assertEquals(200, loginPage.getStatusCode()),
                () -> assertEquals(LogInModal.ErrorTexts.MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT, loginPage.getErrorText()),
                () -> assertEquals(LogInModal.ErrorTexts.MISSING_EMAIL_MESSAGE, loginPage.getErrorsEmailMessage()),
                () -> assertEquals(LogInModal.ErrorTexts.MISSING_PASSWORD_MESSAGE, loginPage.getErrorsPasswordMessage())
        );
    }

    @Test
    public void testLoginWithCorrectFormatEmailAndIncorrectFormatPassword(){

    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndCorrectFormatPassword(){

    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndIncorrectFormatPassword(){

    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndEmptyPassword(){

    }

    @Test
    public void testLoginWithEmptyEmailAndIncorrectFormatPassword(){

    }
}
