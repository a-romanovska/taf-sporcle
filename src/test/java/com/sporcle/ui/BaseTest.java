package com.sporcle.ui;

import com.sporcle.ui.forms.LogInForm;
import com.sporcle.ui.forms.ProductBarForm;
import com.sporcle.ui.pages.BasePage;
import com.sporcle.ui.pages.ContinueWithApplePage;
import com.sporcle.ui.pages.ContinueWithGooglePage;
import com.sporcle.ui.pages.HomePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;

public class BaseTest {
    protected HomePage homePage;
    protected ProductBarForm productBarForm;
    protected LogInForm logInForm;

    @BeforeEach
    protected void setUp() {
        openHomePage();
    }

    @AfterEach
    public void quitDriver() {
        homePage.quit();
    }

    protected String getCurrentUrl() {
        return BasePage.getCurrentUrl();
    }

    protected String getCurrentTitle() {
        return BasePage.getCurrentTitle();
    }

    protected void switchToNextWindow() {
        BasePage.switchToNextWindow();
    }

    protected void closeCurrentWindow() {
        BasePage.closeCurrentWindow();
    }

    protected void switchToOriginalWindow() {
        BasePage.switchToOriginalWindow();
    }

    @Step("Check that expected page is opened")
    protected void checkThatCurrentPageIsExpectedOne(BasePage expectedPage) {
        String expectedUrl = expectedPage.getURL();
        String expectedTitle = expectedPage.getTitle();

        assertAll(
                "Checking that current page is expected one",
                () -> {
                    if (expectedPage instanceof ContinueWithGooglePage || expectedPage instanceof ContinueWithApplePage) {
                        Assertions.assertTrue(getCurrentUrl().contains(expectedUrl), "URL of current page is not expected one");
                    } else {
                        Assertions.assertEquals(expectedUrl, getCurrentUrl(), "URL of current page is not expected one");
                    }
                },
                () -> Assertions.assertEquals(expectedTitle, getCurrentTitle(), "Title of current page is not expected one")
        );
    }

    //open page
    @Step("Open [Home] page")
    private void openHomePage() {
        homePage = new HomePage();
        homePage.open();
    }

    //open form
    @Step("Open [Product bar] form")
    protected void openProductBarForm() {
        openHomePage();
        productBarForm = homePage.getProductBarFormWhenVisible();
    }

    @Step("Open [Log In] form")
    protected void openLogInForm() {
        openProductBarForm();
        productBarForm.clickLogInButton();
        logInForm = homePage.getLogInFormWhenVisible();
    }

    //check open
    @Step("Check that [Log In] form is opened")
    protected void checkThatLogInFormIsVisible() {
        Assertions.assertTrue(homePage.logInFormIsVisible(), "[Log In] form is not opened");
    }

    @Step("Check that [Settings] form is opened")
    protected void checkThatSettingsFormIsVisible() {
        Assertions.assertTrue(homePage.settingsFormIsVisible(), "[Settings] form is not opened");
    }

    @Step("Check that new window is opened")
    protected void checkThatNewWindowIsOpened(BasePage basePage) {
        switchToNextWindow();
        checkThatCurrentPageIsExpectedOne(basePage);
    }
}
