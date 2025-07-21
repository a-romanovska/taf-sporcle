package com.sporcle.ui.forms;

import com.sporcle.ui.elements.ListElement;
import com.sporcle.ui.elements.ValidationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchContentForm extends BaseForm {
    private final String searchResultsListXpath = "//ol[@id='searchResults']";
    private final String searchResult1Xpath = searchResultsListXpath + "//li[1]";
    private final By searchResult1GameTitle = By.xpath(searchResult1Xpath + "//div[@class='gameTitle']");
    private final By noQuizzesFoundMessage = By.xpath("//div[@id='columnContainer']//h2");

    public SearchContentForm(WebElement form) {
        super(form);
    }

    public ListElement getSearchResult1GameTitleWhenVisible() {
        return getListElementWhenVisible(searchResult1GameTitle);
    }

    public ValidationMessage getNoQuizzesFoundMessageWhenVisible() {
        return getValidationMessageWhenVisible(noQuizzesFoundMessage);
    }

    //get text
    public String getSearchResult1GameTitleText() {
        return getSearchResult1GameTitleWhenVisible().getText();
    }

    public String getNoQuizzesFoundMessageText() {
        return getNoQuizzesFoundMessageWhenVisible().getText();
    }
}
