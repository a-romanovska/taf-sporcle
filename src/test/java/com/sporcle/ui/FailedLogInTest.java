package com.sporcle.ui;

import com.sporcle.enums.Color;
import com.sporcle.enums.ErrorMessage;
import com.sporcle.enums.Symbol;
import com.sporcle.utils.ColorConverterUtils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class FailedLogInTest extends BaseTest {
    private String email;
    private String password;

    @BeforeEach
    public void setUp() {
        openLogInForm();

        User user = new User();
        email = user.getEmail();
        password = user.getPassword();
    }

    @Test
    public void testLoginWithIncorrectEmailAndIncorrectPassword() {
        logInForm.inputEmail(email);
        logInForm.inputPassword(password);
        logInForm.clickLogInButton();

        checkThatEmailInputFieldBehavesLikeErrorWasFound(ErrorMessage.LOGIN_INCORRECT_INFORMATION.getMessage());
        checkThatPasswordInputFieldBehavesLikeErrorWasFound(ErrorMessage.LOGIN_INCORRECT_INFORMATION.getMessage());
    }

    @Test
    public void testLoginWithIncorrectEmailAndEmptyPassword() {
        logInForm.inputEmail(email);
        logInForm.inputPassword(Symbol.EMPTY.getSymbol());
        logInForm.clickLogInButton();

        checkThatPasswordInputFieldBehavesLikeErrorWasFound(ErrorMessage.LOGIN_MISSING_PASSWORD.getMessage());
    }

    @Test
    public void testLoginWithEmptyEmailAndIncorrectPassword() {
        logInForm.inputEmail(Symbol.EMPTY.getSymbol());
        logInForm.inputPassword(password);
        logInForm.clickLogInButton();

        checkThatEmailInputFieldBehavesLikeErrorWasFound(ErrorMessage.LOGIN_MISSING_EMAIL.getMessage());
    }

    @Test
    public void testLoginWithEmptyEmailAndEmptyPassword() {
        logInForm.inputEmail(Symbol.EMPTY.getSymbol());
        logInForm.inputPassword(Symbol.EMPTY.getSymbol());
        logInForm.clickLogInButton();

        checkThatEmailInputFieldBehavesLikeErrorWasFound(ErrorMessage.LOGIN_MISSING_EMAIL.getMessage());
        checkThatPasswordInputFieldBehavesLikeErrorWasFound(ErrorMessage.LOGIN_MISSING_PASSWORD.getMessage());
    }

    @Step("Check that [Email] field turns red + corresponding error message appears")
    private void checkThatEmailInputFieldBehavesLikeErrorWasFound(String expectedMessage) {
        String labelColor = logInForm.getEmailLabelColorValue();
        String inputFieldBorderBottomColor = logInForm.getEmailInputFieldBorderBottomColorValue();
        String validationMessageColor = logInForm.getEmailValidationMessageColorValue();
        String validationMessageText = logInForm.getEmailValidationMessageText();

        checkThatInputFieldBehavesLikeErrorWasFound(labelColor, inputFieldBorderBottomColor, validationMessageColor, validationMessageText, expectedMessage);
    }

    @Step("Check that [Password] field turns red + corresponding error message appears")
    private void checkThatPasswordInputFieldBehavesLikeErrorWasFound(String expectedMessage) {
        String labelColor = logInForm.getPasswordLabelColorValue();
        String inputFieldBorderBottomColor = logInForm.getPasswordInputFieldBorderBottomColorValue();
        String validationMessageColor = logInForm.getPasswordValidationMessageColorValue();
        String validationMessageText = logInForm.getPasswordValidationMessageText();

        checkThatInputFieldBehavesLikeErrorWasFound(labelColor, inputFieldBorderBottomColor, validationMessageColor, validationMessageText, expectedMessage);
    }

    private void checkThatInputFieldBehavesLikeErrorWasFound(String labelCurrentColorAsRgba, String inputFieldCurrentBorderBottomColorAsRgba, String validationMessageCurrentColorAsRgba, String validationMessageCurrentText, String expectedMessage) {
        String expectedColor = Color.RED_ERROR.getHexCode();
        String labelCurrentColor = ColorConverterUtils.rgbaToHex(labelCurrentColorAsRgba);
        String inputFieldCurrentBorderBottomColor = ColorConverterUtils.rgbaToHex(inputFieldCurrentBorderBottomColorAsRgba);
        String validationMessageColor = ColorConverterUtils.rgbaToHex(validationMessageCurrentColorAsRgba);
        String actualMessage = validationMessageCurrentText;

        assertAll(
                "Checking that InputField behaves like error was found",
                () -> Assertions.assertTrue(labelCurrentColor.startsWith(expectedColor), "Label color is not " + expectedColor),
                () -> Assertions.assertTrue(inputFieldCurrentBorderBottomColor.startsWith(expectedColor), "InputField border bottom color is not " + expectedColor),
                () -> Assertions.assertTrue(validationMessageColor.startsWith(expectedColor), "ValidationMessage color is not " + expectedColor),
                () -> Assertions.assertEquals(expectedMessage, actualMessage, "ValidationMessage text is incorrect"));
    }
}
