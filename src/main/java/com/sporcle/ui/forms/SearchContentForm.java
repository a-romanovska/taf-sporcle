package com.sporcle.ui.forms;

import com.sporcle.ui.elements.ListElement;
import com.sporcle.ui.elements.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchContentForm extends BaseForm {
    private final By searchResultGameTitle = By.xpath("//div[@class='gameTitle']");
    private final By searchResultGameDescription = By.xpath("//p[@class='gameDesc']");
    private final By noQuizzesFoundMessage = By.xpath("//h2");

    public SearchContentForm(WebElement form) {
        super(form);
    }

    private ListElement getSearchResultGameTitleWhenVisible() {
        return getListElementWhenVisible(searchResultGameTitle);
    }

    private ListElement getSearchResultGameDescriptionWhenVisible() {
        return getListElementWhenVisible(searchResultGameDescription);
    }

    private ValidationMessage getNoQuizzesFoundMessageWhenVisible() {
        return getValidationMessageWhenVisible(noQuizzesFoundMessage);
    }

    public String getSearchResultGameTitleText() {
        return getSearchResultGameTitleWhenVisible().getText();
    }

    public String getSearchResultGameDescriptionText() {
        return getSearchResultGameDescriptionWhenVisible().getText();
    }

    public String getNoQuizzesFoundMessageText() {
        return getNoQuizzesFoundMessageWhenVisible().getText();
    }
}
