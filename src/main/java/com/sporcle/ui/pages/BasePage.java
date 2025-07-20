package com.sporcle.ui.pages;

import com.sporcle.ui.driver.DriverManager;
import com.sporcle.ui.forms.BaseForm;
import com.sporcle.ui.forms.LogInForm;
import com.sporcle.ui.forms.ProductBarForm;
import com.sporcle.ui.forms.RegistrationForm;
import org.openqa.selenium.By;

public abstract class BasePage {
    protected String URL;
    protected final String title;
    protected static final By productBar = By.id("product-bar");
    protected final By logInForm = By.id("login-modal");
    protected final By registrationForm = By.id("registration-modal");
    protected final By settingsForm = By.id("user-dropdown");

    protected BasePage(String endpoint, String title) {
        this.URL = endpoint;
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public String getTitle() {
        return title;
    }

    public void open() {
        DriverManager.open(URL);
    }

    public void quit() {
        DriverManager.quit();
    }

    public static String getCurrentUrl() {
        return DriverManager.getCurrentUrl();
    }

    public static String getCurrentTitle() {
        return DriverManager.getCurrentTitle();
    }

    protected BaseForm getFormWhenVisible(By locator, Class<? extends BaseForm> returnFormClass) {
        return DriverManager.getObjectWhenVisible(locator, returnFormClass);
    }

    protected boolean checkVisibilityState(By locator, boolean shouldBeVisible) {
        return DriverManager.waitForVisibilityState(locator, shouldBeVisible);
    }

    public ProductBarForm getProductBarFormWhenVisible() {
        return (ProductBarForm) getFormWhenVisible(productBar, ProductBarForm.class);
    }

    public static void switchToNextWindow() {
        DriverManager.switchToNextWindow();
    }

    public static void closeCurrentWindow() {
        DriverManager.closeCurrentWindow();
    }

    public static void switchToOriginalWindow() {
        DriverManager.switchToOriginalWindow();
    }

    //get visible form
    public LogInForm getLogInFormWhenVisible() {
        return (LogInForm) getFormWhenVisible(logInForm, LogInForm.class);
    }

    public RegistrationForm getRegistrationFormWhenVisible() {
        return (RegistrationForm) getFormWhenVisible(registrationForm, RegistrationForm.class);
    }

    //check if visible
    public boolean logInFormIsVisible() {
        return checkVisibilityState(logInForm, true);
    }

    public boolean registrationFormIsVisible() {
        return checkVisibilityState(registrationForm, true);
    }

    public boolean settingsFormIsVisible() {
        return checkVisibilityState(settingsForm, true);
    }

    //check if invisible
    public boolean logInFormIsInvisible() {
        return checkVisibilityState(logInForm, false);
    }

    public boolean registrationFormIsInvisible() {
        return checkVisibilityState(registrationForm, false);
    }

    public boolean settingsFormIsInvisible() {
        return checkVisibilityState(settingsForm, false);
    }
}
