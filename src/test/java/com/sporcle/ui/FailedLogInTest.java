package com.sporcle.ui;

import com.sporcle.User;
import com.sporcle.ui.elements.InputField;
import com.sporcle.ui.elements.Label;
import com.sporcle.ui.elements.ValidationMessage;
import com.sporcle.ui.finals.Colors;
import com.sporcle.ui.finals.ErrorMessages;
import com.sporcle.ui.finals.Finals;
import com.sporcle.ui.forms.LogInForm;
import com.sporcle.ui.forms.ProductBarForm;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class FailedLogInTest extends BaseTest {
    private LogInForm logInForm;
    private String email;
    private String password;
    private User user;

    //Закрытие модального окна
    //Ввод неправильного email или пароля
    //Пустое поле email или пароль
    //Некорректный формат email
    //Проверка чекбокса "Stay signed in"
    //Проверка поведения при вводе слишком длинных данных в поля
    //мб нужно добавитт проверки на то, что поле не загорелось красным и тд? по сути противоположность удачному поведению
    //добавить тест поиска?

    @BeforeEach
    public void setUp() {
        super.setUp();

        ProductBarForm productBarForm = homePage.getProductBarFormWhenVisible();
        productBarForm.clickLogInButton();

        logInForm = homePage.getLogInFormWhenVisible();

        user = new User();
        email = user.getEmail();
        password = user.getPassword();
    }

    @Test
    public void testLoginWithCorrectFormatEmailAndCorrectFormatPassword() {
        logInForm.inputEmail(email);
        logInForm.inputPassword(password);
        logInForm.clickLogInButton();

        checkThatEmailInputFieldBehavesLikeErrorWasFound(ErrorMessages.LOGIN_INCORRECT_INFORMATION);
        checkThatPasswordInputFieldBehavesLikeErrorWasFound(ErrorMessages.LOGIN_INCORRECT_INFORMATION);
    }

    @Test
    public void testLoginWithCorrectFormatEmailAndEmptyPassword() {
        logInForm.inputEmail(email);
        logInForm.clickLogInButton();

        checkThatPasswordInputFieldBehavesLikeErrorWasFound(ErrorMessages.LOGIN_MISSING_PASSWORD);
    }

    @Test
    public void testLoginWithEmptyEmailAndCorrectFormatPassword() {
        logInForm.inputPassword(password);
        logInForm.clickLogInButton();

        checkThatEmailInputFieldBehavesLikeErrorWasFound(ErrorMessages.LOGIN_MISSING_EMAIL);
    }

    //не всегда успевает найти сообщение об ошибке
    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        logInForm.inputEmail(Finals.EMPTY_STRING);
        logInForm.inputPassword(Finals.EMPTY_STRING);
        logInForm.clickLogInButton();
        //добавить ожидание, так как не всегда успевает настроиться цвет/найтись сообщение
        //вроде бы стал работать нормально
        //помогает, но по сути не должно так работать, поэтому подумать над лругим вариантом

        checkThatEmailInputFieldBehavesLikeErrorWasFound(ErrorMessages.LOGIN_MISSING_EMAIL);
        checkThatPasswordInputFieldBehavesLikeErrorWasFound(ErrorMessages.LOGIN_MISSING_PASSWORD);
    }

    /*@Test
    public void testLoginWithCorrectFormatEmailAndIncorrectFormatPassword() {
        Assertions.fail("There is no test description yet");
    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndCorrectFormatPassword() {
        Assertions.fail("There is no test description yet");
    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndIncorrectFormatPassword() {
        Assertions.fail("There is no test description yet");
    }

    @Test
    public void testLoginWithIncorrectFormatEmailAndEmptyPassword() {
        Assertions.fail("There is no test description yet");
    }

    @Test
    public void testLoginWithEmptyEmailAndIncorrectFormatPassword() {
        Assertions.fail("There is no test description yet");
    }*/

    private void checkThatInputFieldBehavesLikeErrorWasFound(InputField inputField, Label label, ValidationMessage validationMessage, String errorMessage) {
        String validationMessageText = validationMessage.getText();
        String labelCurrentColor = label.getCssValueColor();
        String inputFieldCurrentBorderBottomColor = inputField.getCssValueBorderBottomColor();
        String validationMessageColor = validationMessage.getCssValueColor();

        assertAll(
                "Checking that InputField behaves like error was found in it",
                () -> Assertions.assertEquals(errorMessage, validationMessageText, "ValidationMessage text is incorrect"),
                () -> Assertions.assertEquals(Colors.ERROR, labelCurrentColor, "Label color is not Colors.ERROR"),
                () -> Assertions.assertEquals(Colors.ERROR, inputFieldCurrentBorderBottomColor, "InputField border bottom color is not Colors.ERROR"),
                () -> Assertions.assertEquals(Colors.ERROR, validationMessageColor, "ValidationMessage color is not Colors.ERROR")
        );
    }

    @Step("Check that [Email] field turns red AND corresponding error message appears")
    private void checkThatEmailInputFieldBehavesLikeErrorWasFound(String errorMessage) {
        InputField inputField = logInForm.getEmailInputFieldWhenVisible();
        Label label = logInForm.getEmailLabelWhenVisible();
        ValidationMessage validationMessage = logInForm.getEmailValidationMessageWhenVisible();

        checkThatInputFieldBehavesLikeErrorWasFound(inputField, label, validationMessage, errorMessage);
    }

    @Step("Check that [Password] field turns red AND corresponding error message appears")
    private void checkThatPasswordInputFieldBehavesLikeErrorWasFound(String errorMessage) {
        InputField inputField = logInForm.getPasswordInputFieldWhenVisible();
        Label label = logInForm.getPasswordLabelWhenVisible();
        ValidationMessage validationMessage = logInForm.getPasswordValidationMessageWhenVisible();

        checkThatInputFieldBehavesLikeErrorWasFound(inputField, label, validationMessage, errorMessage);
    }
}
