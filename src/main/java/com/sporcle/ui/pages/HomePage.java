package com.sporcle.ui.pages;

import com.sporcle.finals.Endpoints;
import com.sporcle.finals.Titles;
import com.sporcle.ui.forms.HomePageContextBarForm;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    protected final By contextBarForm = By.id("context-bar");

    public HomePage() {
        super(Endpoints.HOME, Titles.HOME_PAGE);
    }

    //get visible form
    public HomePageContextBarForm getContextBarFormWhenVisible() {
        return (HomePageContextBarForm) getFormWhenVisible(contextBarForm, HomePageContextBarForm.class);
    }
}
