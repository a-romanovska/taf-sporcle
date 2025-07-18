package com.sporcle.ui.forms;

import com.sporcle.ui.elements.Button;
import com.sporcle.ui.finals.Endpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductBarForm extends BaseForm {
    private final String formXpath = "//nav[@id='product-bar']";
    private final By quizzesButton = By.xpath(formXpath + "//a[@href='" + Endpoints.HOME + "']");
    private final By eventsButton = By.xpath(formXpath + "//a[@href='" + Endpoints.EVENTS + "']");
    private final By quizCreationButton = By.xpath(formXpath + "//a[@href='" + Endpoints.QUIZ_CREATION + "']");
    private final By communityButton = By.xpath(formXpath + "//a[@href='" + Endpoints.COMMUNITY + "']");
    private final By videosButton = By.xpath(formXpath + "//a[@href='" + Endpoints.VIDEOS + "']");
    private final By privateEventsButton = By.xpath(formXpath + "//a[@href='" + Endpoints.PRIVATE_EVENTS + "']");
    private final By removeAdsButton = By.id("remove-ads");
    private final By logInButton = By.id("user-not-logged-in");
    private final By settingsButton = By.id("user-box");

    public ProductBarForm(WebElement form) {
        super(form);
    }

    //get clickable element
    public Button getQuizzesButtonWhenClickable() {
        return (Button) getElementWhenClickable(quizzesButton, Button.class);
    }

    public Button getEventsButtonWhenClickable() {
        return (Button) getElementWhenClickable(eventsButton, Button.class);
    }

    public Button getQuizCreationButtonWhenClickable() {
        return (Button) getElementWhenClickable(quizCreationButton, Button.class);
    }

    public Button getCommunityButtonWhenClickable() {
        return (Button) getElementWhenClickable(communityButton, Button.class);
    }

    public Button getVideosButtonWhenClickable() {
        return (Button) getElementWhenClickable(videosButton, Button.class);
    }

    public Button getPrivateEventsButtonWhenClickable() {
        return (Button) getElementWhenClickable(privateEventsButton, Button.class);
    }

    public Button getRemoveAdsButtonWhenClickable() {
        return (Button) getElementWhenClickable(removeAdsButton, Button.class);
    }

    public Button getLogInButtonWhenClickable() {
        return (Button) getElementWhenClickable(logInButton, Button.class);
    }

    public Button getSettingsButtonWhenClickable() {
        return (Button) getElementWhenClickable(settingsButton, Button.class);
    }

    //click
    //@Step("Click [Quizzes] button on ProductBar")
    public void clickQuizzesButton() {
        getQuizzesButtonWhenClickable().click();
    }

    //@Step("Click [Events] button on ProductBar")
    public void clickEventsButton() {
        getEventsButtonWhenClickable().click();
    }

    //@Step("Click [Quiz creation] button on ProductBar")
    public void clickQuizCreationButton() {
        getQuizCreationButtonWhenClickable().click();
    }

    //@Step("Click [Community] button on ProductBar")
    public void clickCommunityButton() {
        getCommunityButtonWhenClickable().click();
    }

    //@Step("Click [Videos] button on ProductBar")
    public void clickVideosButton() {
        getVideosButtonWhenClickable().click();
    }

    //@Step("Click [Private events] button on ProductBar")
    public void clickPrivateEventsButton() {
        getPrivateEventsButtonWhenClickable().click();
    }

    //@Step("Click [Remove Ads] button on ProductBar")
    public void clickRemoveAdsButton() {
        getRemoveAdsButtonWhenClickable().click();
    }

    //@Step("Click [Log In] button on ProductBar")
    public void clickLogInButton() {
        logger.info("clickLogInButton method start");
        getLogInButtonWhenClickable().click();
        logger.info("logInButton clicked");
    }

    //@Step("Click [Settings] button on ProductBar")
    public void clickSettingsButton() {
        logger.info("clickSettingsButton method start");
        getSettingsButtonWhenClickable().click();
        logger.info("settingsButton clicked");
    }
}
