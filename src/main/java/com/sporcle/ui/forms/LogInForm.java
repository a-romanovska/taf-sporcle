package com.sporcle.ui.forms;

import com.sporcle.ui.elements.Button;
import com.sporcle.ui.elements.InputField;
import com.sporcle.ui.elements.Label;
import com.sporcle.ui.elements.ValidationMessage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInForm extends BaseForm {
    private final By closeButton = By.xpath("//button[@class='modal-close']");
    private final By communityGuidelinesButton = By.xpath("//div[contains(@class,'community-guidelines')]//a");
    private final By continueWithGoogleButton = By.xpath("//button[contains(@class, 'google-signup')]");
    private final By joinSporcleForFree = By.id("switch-to-join-modal");
    private final By continueWithAppleButton = By.id("apple-signin");
    private final By emailInputField = By.id("email");
    private final By emailLabel = By.xpath("//label[@for='email']");
    private final By emailValidationMessage = By.id("email-error");
    private final By passwordInputField = By.id("password");
    private final By passwordLabel = By.xpath("//label[@for='password']");
    private final By passwordValidationMessage = By.id("password-error");
    private final By forgotPasswordButton = By.xpath("//a[@href='/forgot/']");
    private final By goHereButton = By.xpath("//a[@href='/facebook-account/']");
    private final By logInButton = By.id("log-in-button");

    public LogInForm(WebElement form) {
        super(form);
    }

    //get clickable
    public Button getCloseButtonWhenClickable() {
        return getButtonWhenClickable(closeButton);
    }

    public Button getCommunityGuidelinesButtonWhenClickable() {
        return getButtonWhenClickable(communityGuidelinesButton);
    }

    public Button getContinueWithGoogleButtonWhenClickable() {
        return getButtonWhenClickable(continueWithGoogleButton);
    }

    public Button getContinueWithAppleButtonWhenClickable() {
        return getButtonWhenClickable(continueWithAppleButton);
    }

    public Button getJoinSporcleForFreeButtonWhenClickable() {
        return getButtonWhenClickable(joinSporcleForFree);
    }

    public Button getForgotPasswordButtonWhenClickable() {
        return getButtonWhenClickable(forgotPasswordButton);
    }

    public Button getGoHereButtonWhenClickable() {
        return getButtonWhenClickable(goHereButton);
    }

    public Button getLogInButtonWhenClickable() {
        return getButtonWhenClickable(logInButton);
    }

    //get visible
    public InputField getEmailInputFieldWhenVisible() {
        return getInputFieldWhenVisible(emailInputField);
    }

    public InputField getPasswordInputFieldWhenVisible() {
        return getInputFieldWhenVisible(passwordInputField);
    }

    public Label getEmailLabelWhenVisible() {
        return getLabelWhenVisible(emailLabel);
    }

    public Label getPasswordLabelWhenVisible() {
        return getLabelWhenVisible(passwordLabel);
    }

    public ValidationMessage getEmailValidationMessageWhenVisible() {
        return getValidationMessageWhenVisible(emailValidationMessage);
    }

    public ValidationMessage getPasswordValidationMessageWhenVisible() {
        return getValidationMessageWhenVisible(passwordValidationMessage);
    }

    //get text
    public String getEmailValidationMessageText() {
        //return getValidationMessageWhenVisible(emailValidationMessage).getText();
        return getElementWhenVisible(emailValidationMessage).getText();
    }

    public String getPasswordValidationMessageText() {
        //return getValidationMessageWhenVisible(passwordValidationMessage).getText();
        return getElementWhenVisible(passwordValidationMessage).getText();
    }

    //get color
    public String getEmailLabelColorValue() {
        //return getLabelWhenVisible(emailLabel).getCssValueColor();
        return getElementWhenVisible(emailLabel).getCssValueColor();
    }

    public String getPasswordLabelColorValue() {
        //return getLabelWhenVisible(passwordLabel).getCssValueColor();
        return getElementWhenVisible(passwordLabel).getCssValueColor();
    }

    public String getEmailValidationMessageColorValue() {
        //return getValidationMessageWhenVisible(emailValidationMessage).getCssValueColor();
        return getElementWhenVisible(emailValidationMessage).getCssValueColor();
    }

    public String getPasswordValidationMessageColorValue() {
        //return getValidationMessageWhenVisible(passwordValidationMessage).getCssValueColor();
        return getElementWhenVisible(passwordValidationMessage).getCssValueColor();
    }

    //get border bottom color
    public String getEmailInputFieldBorderBottomColorValue() {
        //return getInputFieldWhenVisible(emailInputField).getCssValueBorderBottomColor();
        return getElementWhenVisible(emailInputField).getCssValueBorderBottomColor();
    }

    public String getPasswordInputFieldBorderBottomColorValue() {
        //return getInputFieldWhenVisible(passwordInputField).getCssValueBorderBottomColor();
        return getElementWhenVisible(passwordInputField).getCssValueBorderBottomColor();
    }

    //click
    @Step("Click [Close] button ([Log In] form)")
    public void clickCloseButton() {
        //getButtonWhenClickable(closeButton).click();
        getButtonWhenClickable(closeButton).click();
    }

    @Step("Click [Community Guidelines] link ([Log In] form)")
    public void clickCommunityGuidelinesButton() {
        //getButtonWhenClickable(communityGuidelinesButton).click();
        getButtonWhenClickable(communityGuidelinesButton).click();
    }

    @Step("Click [Continue with Google] button ([Log In] form)")
    public void clickContinueWithGoogleButton() {
        //getButtonWhenClickable(continueWithGoogleButton).click();
        getButtonWhenClickable(continueWithGoogleButton).click();
    }

    @Step("Click [Continue with Apple] button ([Log In] form)")
    public void clickContinueWithAppleButton() {
        //getButtonWhenClickable(continueWithAppleButton).click();
        getButtonWhenClickable(continueWithAppleButton).click();
    }

    @Step("Click [Join Sporcle for Free] button ([Log In] form)")
    public void clickJoinSporcleForFreeButton() {
        getButtonWhenClickable(joinSporcleForFree).click();
    }

    @Step("Click [Forgot password] button ([Log In] form)")
    public void clickGForgotPasswordButton() {
        getButtonWhenClickable(forgotPasswordButton).click();
    }

    @Step("Click [Go Here] button ([Log In] form)")
    public void clickGoHereButton() {
        //getButtonWhenClickable(goHereButton).click();
        getButtonWhenClickable(goHereButton).click();
    }

    @Step("Click [Log In] button ([Log In] form)")
    public void clickLogInButton() {
        //getButtonWhenClickable(logInButton).click();
        getButtonWhenClickable(logInButton).click();
    }

    //input
    @Step("Fill [Email] field ([Log In] form)")
    public void inputEmail(String email) {
        logger.info("inputEmail method start");
        logger.info("email = {}", email);
        getInputFieldWhenClickable(emailInputField).inputValue(email);
    }

    @Step("Fill [Password] field ([Log In] form)")
    public void inputPassword(String password) {
        logger.info("inputPassword method start");
        logger.info("password = {}", password);
        getInputFieldWhenClickable(passwordInputField).inputValue(password);
    }
}
