package com.sporcle.ui.forms;

import com.sporcle.ui.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductBarForm extends BaseForm {
    private final String formXpath = "//nav[@id='product-bar']";
    private final By quizzesButton = By.xpath(formXpath + "//a[@href='/']");
    private final By eventsButton = By.xpath(formXpath + "//a[@href='/events/']");
    private final By quizCreationButton = By.xpath(formXpath + "//a[@href='/create/']");
    private final By communityButton = By.xpath(formXpath + "//a[@href='/groups/']");
    private final By videosButton = By.xpath(formXpath + "//a[@href='/videos/']");
    private final By privateEventsButton = By.xpath(formXpath + "//a[@href='/events/private-events/']");
    private final By removeAdsButton = By.id("remove-ads");
    private final By logInButton = By.id("user-not-logged-in");
    private final By settingsButton = By.id("user-box");

    public ProductBarForm(WebElement form) {
        super(form);
    }

    private Button getQuizzesButtonWhenClickable() {
        return (Button) getElementWhenClickable(quizzesButton, Button.class);
    }

    private Button getEventsButtonWhenClickable() {
        return (Button) getElementWhenClickable(eventsButton, Button.class);
    }

    private Button getQuizCreationButtonWhenClickable() {
        return (Button) getElementWhenClickable(quizCreationButton, Button.class);
    }

    private Button getCommunityButtonWhenClickable() {
        return (Button) getElementWhenClickable(communityButton, Button.class);
    }

    private Button getVideosButtonWhenClickable() {
        return (Button) getElementWhenClickable(videosButton, Button.class);
    }

    private Button getPrivateEventsButtonWhenClickable() {
        return (Button) getElementWhenClickable(privateEventsButton, Button.class);
    }

    private Button getRemoveAdsButtonWhenClickable() {
        return (Button) getElementWhenClickable(removeAdsButton, Button.class);
    }

    private Button getLogInButtonWhenClickable() {
        return (Button) getElementWhenClickable(logInButton, Button.class);
    }

    private Button getSettingsButtonWhenClickable() {
        return (Button) getElementWhenClickable(settingsButton, Button.class);
    }

    @Step("Click [Quizzes] button (ProductBar form)")
    public void clickQuizzesButton() {
        getQuizzesButtonWhenClickable().click();
    }

    @Step("Click [Events] button (ProductBar form)")
    public void clickEventsButton() {
        getEventsButtonWhenClickable().click();
    }

    @Step("Click [Quiz creation] button (ProductBar form)")
    public void clickQuizCreationButton() {
        getQuizCreationButtonWhenClickable().click();
    }

    @Step("Click [Community] button (ProductBar form)")
    public void clickCommunityButton() {
        getCommunityButtonWhenClickable().click();
    }

    @Step("Click [Videos] button (ProductBar form)")
    public void clickVideosButton() {
        getVideosButtonWhenClickable().click();
    }

    @Step("Click [Private events] button (ProductBar form)")
    public void clickPrivateEventsButton() {
        getPrivateEventsButtonWhenClickable().click();
    }

    @Step("Click [Remove ads] button (ProductBar form)")
    public void clickRemoveAdsButton() {
        getRemoveAdsButtonWhenClickable().click();
    }

    @Step("Click [Sign In] button (ProductBar form)")
    public void clickLogInButton() {
        getLogInButtonWhenClickable().click();
    }

    @Step("Click [Settings] button (ProductBar form)")
    public void clickSettingsButton() {
        getSettingsButtonWhenClickable().click();
    }
}
