package com.sporcle.ui.pages;

import com.sporcle.ui.driver.DriverManager;
import com.sporcle.ui.finals.Endpoints;
import com.sporcle.ui.forms.BaseForm;
import com.sporcle.ui.forms.ProductBarForm;
import org.openqa.selenium.By;

public abstract class BasePage {
    protected String URL = Endpoints.BASE_URL;
    protected final String title;
    //private final WebDriver driver;
    protected static final By productBar = By.id("product-bar");

    protected BasePage(String endpoint, String title) {
        //driver = DriverManager.getDriver();
        this.URL = URL + endpoint;
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public String getTitle() {
        return title;
    }

    public void open() {
        DriverManager.open(URL);
    }

    public void quit() {
        DriverManager.quit();
    }

    public static String getCurrentUrl() {
        return DriverManager.getCurrentUrl();
    }

    public static String getCurrentTitle() {
        return DriverManager.getCurrentTitle();
    }

    protected BaseForm getFormWhenVisible(By locator, Class<? extends BaseForm> returnFormClass) {
        return DriverManager.getObjectWhenVisible(locator, returnFormClass);
    }

    protected boolean checkVisibilityState(By locator, boolean shouldBeVisible) {
        return DriverManager.waitForVisibilityState(locator, shouldBeVisible);
    }

    public ProductBarForm getProductBarFormWhenVisible() {
        return (ProductBarForm) getFormWhenVisible(productBar, ProductBarForm.class);
    }
}
