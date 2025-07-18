package com.sporcle.ui.elements;

import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected final WebElement element;
    protected final String COLOR_PROPERTY_NAME = "color";
    protected final String BORDER_BOTTOM_COLOR_PROPERTY_NAME = "border-bottom-color";

    protected BaseElement(WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public String getText() {
        return element.getText();
    }

    private String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    public String getCssValueColor() {
        return getCssValue(COLOR_PROPERTY_NAME);
    }

    public String getCssValueBorderBottomColor() {
        return getCssValue(BORDER_BOTTOM_COLOR_PROPERTY_NAME);
    }
}
