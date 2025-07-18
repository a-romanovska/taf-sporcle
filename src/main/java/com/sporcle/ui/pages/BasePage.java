package com.sporcle.ui.pages;

import com.sporcle.ui.finals.Endpoints;
import com.sporcle.ui.forms.BaseForm;
import com.sporcle.ui.forms.ProductBarForm;
import com.sporcle.ui.utils.DriverManager;
import com.sporcle.ui.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    protected BaseForm getFormWhenConditionIsMet(ExpectedCondition<WebElement> condition, Class<? extends BaseForm> returnFormClass) {
        WebElement webElement = WebElementUtils.getWebElementWhenConditionIsMet(condition);
        try {
            return returnFormClass.getConstructor(WebElement.class).newInstance(webElement);
        } catch (Exception e) {
            System.out.println("Ошибка при создании формы: " + returnFormClass.getName());
            return null;
        }
    }

    /*protected BaseForm getForm(By locator, Class<? extends BaseForm> returnFormClass) {
        //WebElement webElement = WebElementUtils.getWebElement(locator);
        return getFormWhenConditionIsMet(webElement, returnFormClass);
    }*/

    protected BaseForm getFormWhenVisible(By locator, Class<? extends BaseForm> returnFormClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        //WebElement webElement = WebElementUtils.getWebElementWhenConditionIsMet(condition);
        return getFormWhenConditionIsMet(condition, returnFormClass);
    }

    public ProductBarForm getProductBarFormWhenVisible() {
        return (ProductBarForm) getFormWhenVisible(productBar, ProductBarForm.class);
    }

    protected boolean isVisible(By locator) {
        return WebElementUtils.isVisible(locator);
        /*ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        try {
            WebElementUtils.getWebElementWhenConditionIsMet(condition);
        } catch (TimeoutException e) {
            return false;
        }
        return true;*/
    }
}
