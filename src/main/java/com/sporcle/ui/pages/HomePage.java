package com.sporcle.ui.pages;

import com.sporcle.finals.Endpoints;
import com.sporcle.finals.Titles;
import com.sporcle.ui.forms.LogInForm;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By logInForm = By.id("login-modal");
    private final By settingsForm = By.id("user-dropdown");

    public HomePage() {
        super(Endpoints.HOME, Titles.HOME_PAGE);
    }

    //get visible form
    public LogInForm getLogInFormWhenVisible() {
        return (LogInForm) getFormWhenVisible(logInForm, LogInForm.class);
    }

    //check visibility
    public boolean logInFormIsVisible() {
        return checkVisibilityState(logInForm, true);
    }

    public boolean logInFormIsInvisible() {
        return checkVisibilityState(logInForm, false);
    }

    public boolean settingsFormIsVisible() {
        return checkVisibilityState(settingsForm, true);
    }

    public boolean settingsFormIsInvisible() {
        return checkVisibilityState(settingsForm, false);
    }
}
