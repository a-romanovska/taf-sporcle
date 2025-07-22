package com.sporcle.ui;

import com.sporcle.ui.forms.HomePageContextBarForm;
import com.sporcle.ui.forms.LogInForm;
import com.sporcle.ui.forms.ProductBarForm;
import com.sporcle.ui.pages.BasePage;
import com.sporcle.ui.pages.ContinueWithApplePage;
import com.sporcle.ui.pages.ContinueWithGooglePage;
import com.sporcle.ui.pages.HomePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;

public class BaseTest {
    protected HomePage homePage;
    protected ProductBarForm productBarForm;
    protected LogInForm logInForm;
    protected HomePageContextBarForm homePageContextBarForm;
    protected static final Logger logger = LogManager.getLogger();

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

    protected void switchToAnotherWindow() {
        BasePage.switchToAnotherWindow();
    }

    @Step("Open [Home] page")
    public HomePage openHomePage() {
        homePage = new HomePage();
        homePage.open();
        return homePage;
    }

    @Step("Open [Context bar] form")
    public HomePageContextBarForm openContextBarForm() {
        openHomePage();
        homePageContextBarForm = homePage.getContextBarFormWhenVisible();
        return homePageContextBarForm;
    }

    @Step("Open [Product bar] form")
    public ProductBarForm openProductBarForm() {
        openHomePage();
        productBarForm = homePage.getProductBarFormWhenVisible();
        return productBarForm;
    }

    @Step("Open [Log In] form")
    public LogInForm openLogInForm() {
        openProductBarForm();
        productBarForm.clickLogInButton();
        logInForm = homePage.getLogInFormWhenVisible();
        return logInForm;
    }

    @Step("Check that [Log In] form is opened")
    public void checkThatLogInFormIsVisible() {
        Assertions.assertTrue(homePage.logInFormIsVisible(), "[Log In] form is not opened");
    }

    @Step("Check that [Join for Free] form is opened")
    public void checkThatRegistrationFormIsVisible() {
        Assertions.assertTrue(homePage.registrationFormIsVisible(), "[Join for Free] form is not opened");
    }

    @Step("Check that [Settings] form is opened")
    public void checkThatSettingsFormIsVisible() {
        Assertions.assertTrue(homePage.settingsFormIsVisible(), "[Settings] form is not opened");
    }

    @Step("Check that another window is opened")
    protected void checkThatAnotherWindowIsOpened(BasePage basePage) {
        switchToAnotherWindow();
        checkThatCurrentPageIsExpectedOne(basePage);
    }

    @Step("Check that expected page is opened")
    public void checkThatCurrentPageIsExpectedOne(BasePage expectedPage) {
        String expectedUrl = expectedPage.getURL();
        String expectedTitle = expectedPage.getTitle();

        assertAll(
                "Checking that current page is expected one",
                () -> {
                    if (expectedPage instanceof ContinueWithGooglePage || expectedPage instanceof ContinueWithApplePage) {
                        Assertions.assertTrue(getCurrentUrl().startsWith(expectedUrl), "URL of current page is not expected one");
                    } else {
                        Assertions.assertEquals(expectedUrl, getCurrentUrl(), "URL of current page is not expected one");
                    }
                },
                () -> Assertions.assertEquals(expectedTitle, getCurrentTitle(), "Title of current page is not expected one")
        );
    }
}
