package com.sporcle.ui.forms;

import com.sporcle.ui.elements.Button;
import com.sporcle.ui.elements.InputField;
import com.sporcle.ui.elements.Label;
import com.sporcle.ui.elements.ValidationMessage;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInForm extends BaseForm {
    private final By closeButton = By.xpath("//button[@class='modal-close']");
    private final By communityGuidelinesButton = By.xpath("//div[contains(@class,'community-guidelines')]//a");
    private final By continueWithGoogleButton = By.xpath("//button[contains(@class, 'google-signup')]");
    private final By joinSporcleForFree = By.id("switch-to-join-modal");
    private final By continueWithAppleButton = By.id("apple-signin");
    private final By emailLabel = By.xpath("//label[@for='email']");
    private final By emailInputField = By.id("email");
    private final By emailValidationMessage = By.id("email-error");
    private final By passwordLabel = By.xpath("//label[@for='password']");
    private final By passwordInputField = By.id("password");
    private final By passwordValidationMessage = By.id("password-error");
    private final By forgotPasswordButton = By.xpath("//a[@href='/forgot/']");
    private final By goHereButton = By.xpath("//a[@href='/facebook-account/']");
    private final By logInButton = By.id("log-in-button");

    public LogInForm(WebElement form) {
        super(form);
    }

    private Label getEmailLabelWhenVisible() {
        return getLabelWhenVisible(emailLabel);
    }

    private InputField getEmailInputFieldWhenVisible() {
        return getInputFieldWhenVisible(emailInputField);
    }

    public ValidationMessage getEmailValidationMessageWhenVisible() {
        return getValidationMessageWhenVisible(emailValidationMessage);
    }

    private Label getPasswordLabelWhenVisible() {
        return getLabelWhenVisible(passwordLabel);
    }

    private InputField getPasswordInputFieldWhenVisible() {
        return getInputFieldWhenVisible(passwordInputField);
    }

    private ValidationMessage getPasswordValidationMessageWhenVisible() {
        return getValidationMessageWhenVisible(passwordValidationMessage);
    }

    private Button getCloseButtonWhenClickable() {
        return getButtonWhenClickable(closeButton);
    }

    private Button getCommunityGuidelinesButtonWhenClickable() {
        return getButtonWhenClickable(communityGuidelinesButton);
    }

    private Button getContinueWithGoogleButtonWhenClickable() {
        return getButtonWhenClickable(continueWithGoogleButton);
    }

    private Button getContinueWithAppleButtonWhenClickable() {
        return getButtonWhenClickable(continueWithAppleButton);
    }

    private Button getJoinSporcleForFreeButtonWhenClickable() {
        return getButtonWhenClickable(joinSporcleForFree);
    }

    private Button getForgotPasswordButtonWhenClickable() {
        return getButtonWhenClickable(forgotPasswordButton);
    }

    private Button getGoHereButtonWhenClickable() {
        return getButtonWhenClickable(goHereButton);
    }

    private Button getLogInButtonWhenClickable() {
        return getButtonWhenClickable(logInButton);
    }

    public String getEmailValidationMessageText() {
        return getEmailValidationMessageWhenVisible().getText();
    }

    public String getPasswordValidationMessageText() {
        return getPasswordValidationMessageWhenVisible().getText();
    }

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

    public String getEmailInputFieldBorderBottomColorValue() {
        return getEmailInputFieldWhenVisible().getCssValueBorderBottomColor();
    }

    public String getPasswordInputFieldBorderBottomColorValue() {
        return getPasswordInputFieldWhenVisible().getCssValueBorderBottomColor();
    }

    public boolean checkEmailLabelColorValue(String expectedColor) {
        return checkCurrentColor(emailLabel, expectedColor);
    }

    public boolean checkEmailValidationMessageColorValue(String expectedColor) {
        return checkCurrentColor(emailValidationMessage, expectedColor);
    }

    public boolean checkEmailInputFieldBorderBottomColorValue(String expectedColor) {
        return checkCurrentBorderBottomColor(emailInputField, expectedColor);
    }

    public boolean checkPasswordLabelColorValue(String expectedColor) {
        return checkCurrentColor(passwordLabel, expectedColor);
    }

    public boolean checkPasswordValidationMessageColorValue(String expectedColor) {
        return checkCurrentColor(passwordValidationMessage, expectedColor);
    }

    public boolean checkPasswordInputFieldBorderBottomColorValue(String expectedColor) {
        return checkCurrentBorderBottomColor(passwordInputField, expectedColor);
    }

    @Step("Click [Close] button ([Log In] form)")
    public void clickCloseButton() {
        getCloseButtonWhenClickable().click();
    }

    @Step("Click [Community Guidelines] link ([Log In] form)")
    public void clickCommunityGuidelinesButton() {
        getCommunityGuidelinesButtonWhenClickable().click();
    }

    @Step("Click [Continue with Google] button ([Log In] form)")
    public void clickContinueWithGoogleButton() {
        getContinueWithGoogleButtonWhenClickable().click();
    }

    @Step("Click [Continue with Apple] button ([Log In] form)")
    public void clickContinueWithAppleButton() {
        getContinueWithAppleButtonWhenClickable().click();
    }

    @Step("Click [Join Sporcle for Free] button ([Log In] form)")
    public void clickJoinSporcleForFreeButton() {
        getJoinSporcleForFreeButtonWhenClickable().click();
    }

    @Step("Click [Forgot password] button ([Log In] form)")
    public void clickGForgotPasswordButton() {
        getForgotPasswordButtonWhenClickable().click();
    }

    @Step("Click [Go Here] button ([Log In] form)")
    public void clickGoHereButton() {
        getGoHereButtonWhenClickable().click();
    }

    @Step("Click [Log In] button ([Log In] form)")
    @When("Click [Log In] on LogIn form")
    public void clickLogInButton() {
        getLogInButtonWhenClickable().click();
    }

    @Step("Fill [Email] field ([Log In] form)")
    public void inputEmail(String email) {
        logger.info("inputEmail method start");
        getInputFieldWhenClickable(emailInputField).inputValue(email);
        logger.info("email = {}", email);
    }

    @Step("Fill [Password] field ([Log In] form)")
    public void inputPassword(String password) {
        logger.info("inputPassword method start");
        getInputFieldWhenClickable(passwordInputField).inputValue(password);
        logger.info("password = {}", password);
    }
}
