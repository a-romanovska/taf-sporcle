package com.sporcle.ui.pages;

import com.sporcle.finals.Endpoints;
import com.sporcle.finals.Titles;
import com.sporcle.ui.forms.SearchContentForm;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private final By searchContentForm = By.id("content");

    public SearchPage() {
        super(Endpoints.SEARCH, Titles.SEARCH);
    }

    //get visible form
    public SearchContentForm getSearchContentFormWhenVisible() {
        return (SearchContentForm) getFormWhenVisible(searchContentForm, SearchContentForm.class);
    }
}
