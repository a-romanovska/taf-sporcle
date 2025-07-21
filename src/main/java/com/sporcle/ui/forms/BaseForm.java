package com.sporcle.ui.forms;

import com.sporcle.ui.driver.DriverManager;
import com.sporcle.ui.elements.*;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseForm {
    private final By startLoupeButton = By.xpath("//li[@class='main-search']");
    private final String searchMenuXpath = "//div[@id='search-menu']";
    private final By searchInputField = By.xpath(searchMenuXpath + "//input");
    private final By inputLoupeButton = By.xpath(searchMenuXpath + "//button");

    protected final WebElement form;

    protected static final Logger logger = LogManager.getLogger();

    protected BaseForm(WebElement form) {
        this.form = form;
    }

    protected BaseElement getElementWhenClickable(By locator, Class<? extends BaseElement> returnElementClass) {
        return DriverManager.getObjectWhenClickable(locator, returnElementClass);
    }

    protected BaseElement getElementWhenVisible(By locator, Class<? extends BaseElement> returnElementClass) {
        return DriverManager.getObjectWhenVisible(locator, returnElementClass);
    }

    protected BaseElement getElementWhenVisible(By locator) {
        return getElementWhenVisible(locator, BaseElement.class);
    }

    protected Label getLabelWhenVisible(By locator) {
        return (Label) getElementWhenVisible(locator, Label.class);
    }

    protected InputField getInputFieldWhenVisible(By locator) {
        return (InputField) getElementWhenVisible(locator, InputField.class);
    }

    protected ValidationMessage getValidationMessageWhenVisible(By locator) {
        return (ValidationMessage) getElementWhenVisible(locator, ValidationMessage.class);
    }

    protected ListElement getListElementWhenVisible(By locator) {
        return (ListElement) getElementWhenVisible(locator, ListElement.class);
    }

    protected BaseElement getElementWhenClickable(By locator) {
        return getElementWhenClickable(locator, BaseElement.class);
    }

    protected Button getButtonWhenClickable(By locator) {
        return (Button) getElementWhenClickable(locator, Button.class);
    }

    protected InputField getInputFieldWhenClickable(By locator) {
        return (InputField) getElementWhenClickable(locator, InputField.class);
    }

    public Button getStartLoupeButtonWhenClickable() {
        return (Button) getElementWhenClickable(startLoupeButton, Button.class);
    }

    public Button getInputLoupeButtonWhenClickable() {
        return (Button) getElementWhenClickable(inputLoupeButton, Button.class);
    }

    public InputField getSearchInputFieldWhenClickable() {
        return (InputField) getElementWhenClickable(searchInputField, InputField.class);
    }

    public InputField getSearchInputFieldWhenVisible() {
        return (InputField) getElementWhenVisible(searchInputField, InputField.class);
    }

    @Step("Click [Start loupe] button")
    public void clickStartLoupeButton() {
        getStartLoupeButtonWhenClickable().click();
    }

    @Step("Click [Input loupe] button")
    public void clickInputLoupeButton() {
        getInputLoupeButtonWhenClickable().click();
    }

    @Step("Fill [Search bar]")
    public void inputSearchInputField(String searchValue) {
        logger.info("input Search value method start");
        getSearchInputFieldWhenClickable().inputValue(searchValue);
        logger.info("searchValue = {}", searchValue);
    }
}
