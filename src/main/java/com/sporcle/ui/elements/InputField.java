package com.sporcle.ui.elements;

import org.openqa.selenium.WebElement;

public class InputField extends BaseElement {
    public InputField(WebElement element) {
        super(element);
    }

    public void inputValue(String value) {
        element.sendKeys(value);
    }
}
