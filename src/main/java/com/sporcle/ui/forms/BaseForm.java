package com.sporcle.ui.forms;

import com.sporcle.ui.driver.DriverManager;
import com.sporcle.ui.elements.BaseElement;
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
        return DriverManager.getObjectWhenVisible(locator, returnElementClass);
    }

    protected BaseElement getElementWhenVisible(By locator, Class<? extends BaseElement> returnElementClass) {
        return DriverManager.getObjectWhenVisible(locator, returnElementClass);
    }
}
