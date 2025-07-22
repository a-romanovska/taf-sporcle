package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;
import com.sporcle.ui.forms.HomePageContextBarForm;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    protected final By contextBarForm = By.id("context-bar");

    public HomePage() {
        super(Endpoints.HOME, PageTitle.HOME.getTitle());
    }

    public HomePageContextBarForm getContextBarFormWhenVisible() {
        return (HomePageContextBarForm) getFormWhenVisible(contextBarForm, HomePageContextBarForm.class);
    }
}
