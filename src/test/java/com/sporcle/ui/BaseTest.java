package com.sporcle.ui;

import com.sporcle.ui.pages.BasePage;
import com.sporcle.ui.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;

public class BaseTest {
    protected static final Logger logger = LogManager.getLogger();

    protected HomePage homePage;

    @BeforeEach
    protected void setUp() {
        homePage = new HomePage();
        homePage.open();
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

    //@Step("Check that corresponding page is opened")
    public void checkThatCurrentPageIsExpectedOne(BasePage expectedPage) {
        String expectedUrl = expectedPage.getURL();
        String expectedTitle = expectedPage.getTitle();
        assertAll(
                "Checking that current page is expected one",
                () -> Assertions.assertEquals(expectedUrl, getCurrentUrl(), "URL of current page is not expected one"),
                () -> Assertions.assertEquals(expectedTitle, getCurrentTitle(), "Title of current page is not expected one")
        );
    }
}
