package com.sporcle.ui.forms;

import com.sporcle.ui.elements.BaseElement;
import com.sporcle.ui.utils.WebElementUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseForm {
    protected final WebElement form;

    protected static final Logger logger = LogManager.getLogger();

    protected BaseForm(WebElement form) {
        this.form = form;
    }

    private BaseElement getElementWhenConditionIsMet(ExpectedCondition<WebElement> condition, Class<? extends BaseElement> returnElementClass) {
        WebElement webElement = WebElementUtils.getWebElementWhenConditionIsMet(condition);
        try {
            return returnElementClass.getConstructor(WebElement.class).newInstance(webElement);
        } catch (Exception e) {
            System.out.println("Ошибка при создании элемента: " + returnElementClass.getName());
            return null;
        }
    }

    protected BaseElement getElementWhenClickable(By locator, Class<? extends BaseElement> returnElementClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(locator);
        return getElementWhenConditionIsMet(condition, returnElementClass);
    }

    protected BaseElement getElementWhenVisible(By locator, Class<? extends BaseElement> returnElementClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        return getElementWhenConditionIsMet(condition, returnElementClass);
    }
}
