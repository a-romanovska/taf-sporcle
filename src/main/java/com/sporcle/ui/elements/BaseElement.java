package com.sporcle.ui.elements;

import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected final WebElement element;
    protected final static String COLOR_PROPERTY_NAME = "color";
    protected final static String BORDER_BOTTOM_COLOR_PROPERTY_NAME = "border-bottom-color";

    protected BaseElement(WebElement element) {
        this.element = element;
    }

    public static String getColorPropertyName() {
        return COLOR_PROPERTY_NAME;
    }

    public static String getBorderBottomColorPropertyName() {
        return BORDER_BOTTOM_COLOR_PROPERTY_NAME;
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
