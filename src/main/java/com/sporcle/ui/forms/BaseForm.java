package com.sporcle.ui.forms;

import com.sporcle.ui.driver.DriverManager;
import com.sporcle.ui.elements.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseForm {
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

    protected BaseElement getElementWhenClickable(By locator) {
        return getElementWhenClickable(locator, BaseElement.class);
    }

    protected Button getButtonWhenClickable(By locator) {
        return (Button) getElementWhenClickable(locator, Button.class);
    }

    protected InputField getInputFieldWhenClickable(By locator) {
        return (InputField) getElementWhenClickable(locator, InputField.class);
    }
}
