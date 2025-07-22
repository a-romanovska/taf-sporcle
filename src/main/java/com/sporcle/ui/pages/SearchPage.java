package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.finals.Endpoints;
import com.sporcle.ui.forms.SearchContentForm;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private final By searchContentForm = By.id("content");

    public SearchPage() {
        super(Endpoints.SEARCH, PageTitle.SEARCH.getTitle());
    }

    //get visible form
    public SearchContentForm getSearchContentFormWhenVisible() {
        return (SearchContentForm) getFormWhenVisible(searchContentForm, SearchContentForm.class);
    }
}
