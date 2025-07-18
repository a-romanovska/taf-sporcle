package com.sporcle.ui.forms;

import com.sporcle.ui.elements.Button;
import com.sporcle.ui.elements.InputField;
import com.sporcle.ui.elements.Label;
import com.sporcle.ui.elements.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInForm extends BaseForm {
    private final By closeButton = By.xpath("//button[@class='modal-close']");
    private final By logInButton = By.id("log-in-button");
    private final By emailInputField = By.id("email");
    private final By emailLabel = By.xpath("//label[@for='email']");
    private final By emailValidationMessage = By.id("email-error");
    private final By passwordInputField = By.id("password");
    private final By passwordLabel = By.xpath("//label[@for='password']");
    private final By passwordValidationMessage = By.id("password-error");

    public LogInForm(WebElement form) {
        super(form);
    }

    //get clickable element
    public Button getCloseButtonWhenClickable() {
        return (Button) getElementWhenClickable(closeButton, Button.class);
    }

    public Button getLogInButtonWhenClickable() {
        return (Button) getElementWhenClickable(logInButton, Button.class);
    }

    public InputField getEmailInputFieldWhenClickable() {
        return (InputField) getElementWhenClickable(emailInputField, InputField.class);
    }

    public InputField getPasswordInputFieldWhenClickable() {
        return (InputField) getElementWhenClickable(passwordInputField, InputField.class);
    }

    //get visible element
    public Label getEmailLabelWhenVisible() {
        return (Label) getElementWhenVisible(emailLabel, Label.class);
    }

    public Label getPasswordLabelWhenVisible() {
        return (Label) getElementWhenVisible(passwordLabel, Label.class);
    }

    public InputField getEmailInputFieldWhenVisible() {
        return (InputField) getElementWhenVisible(emailInputField, InputField.class);
    }

    public InputField getPasswordInputFieldWhenVisible() {
        return (InputField) getElementWhenVisible(passwordInputField, InputField.class);
    }

    public ValidationMessage getEmailValidationMessageWhenVisible() {
        return (ValidationMessage) getElementWhenVisible(emailValidationMessage, ValidationMessage.class);
    }

    public ValidationMessage getPasswordValidationMessageWhenVisible() {
        return (ValidationMessage) getElementWhenVisible(passwordValidationMessage, ValidationMessage.class);
    }

    //get text
    public String getEmailValidationMessageText() {
        return getEmailValidationMessageWhenVisible().getText();
    }

    public String getPasswordValidationMessageText() {
        return getPasswordValidationMessageWhenVisible().getText();
    }

    //get color
    public String getEmailLabelColorValue() {
        return getEmailLabelWhenVisible().getCssValueColor();
    }

    public String getPasswordLabelColorValue() {
        return getPasswordLabelWhenVisible().getCssValueColor();
    }

    public String getEmailValidationMessageColorValue() {
        return getEmailValidationMessageWhenVisible().getCssValueColor();
    }

    public String getPasswordValidationMessageColorValue() {
        return getPasswordValidationMessageWhenVisible().getCssValueColor();
    }

    //get border bottom color
    public String getEmailInputFieldBorderBottomColorValue() {
        return getEmailInputFieldWhenVisible().getCssValueBorderBottomColor();
    }

    public String getPasswordInputFieldBorderBottomColorValue() {
        return getPasswordInputFieldWhenVisible().getCssValueBorderBottomColor();
    }

    //click
    public void clickCloseButton() {
        getCloseButtonWhenClickable().click();
    }

    //@Step("Click [Log In] button on LogIn modal")
    public void clickLogInButton() {
        getLogInButtonWhenClickable().click();
    }

    //input
    //@Step("Input Email on LogIn modal")
    public void inputEmail(String email) {
        logger.info("inputEmail method start");
        logger.info("email = {}", email);
        getEmailInputFieldWhenClickable().inputValue(email);
    }

    //@Step("Input Password on LogIn modal")
    public void inputPassword(String password) {
        logger.info("inputPassword method start");
        logger.info("password = {}", password);
        getPasswordInputFieldWhenClickable().inputValue(password);
    }
}
