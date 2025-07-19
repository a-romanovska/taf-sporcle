package com.sporcle.ui.driver;

import com.sporcle.ui.finals.Finals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void open(String URL) {
        getDriver().get(URL);
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getCurrentUrl() {
        if (driver == null) {
            return Finals.EMPTY_STRING;
        } else {
            return driver.getCurrentUrl();
        }
    }

    public static String getCurrentTitle() {
        if (driver == null) {
            return Finals.EMPTY_STRING;
        } else {
            return driver.getTitle();
        }
    }

    private static WebElement getWebElement(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }

    private static <T> T getOrCheckWebElementWhenConditionIsMet(ExpectedCondition<T> condition, int specifiedTimeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(specifiedTimeoutSeconds));
        return wait.until(condition);
    }

    private static <T> T getOrCheckWebElementWhenConditionIsMet(ExpectedCondition<T> condition) {
        return getOrCheckWebElementWhenConditionIsMet(condition, Finals.DEFAULT_EXPLICIT_WAIT_TIMEOUT_SECONDS);
    }

    private static <T> T getObjectWhenConditionIsMet(ExpectedCondition<WebElement> condition, Class<T> returnClass) {
        WebElement webElement = DriverManager.getOrCheckWebElementWhenConditionIsMet(condition);
        try {
            return returnClass.getConstructor(WebElement.class).newInstance(webElement);
        } catch (Exception e) {
            System.out.println("Ошибка при создании объекта: " + returnClass.getName());
            return null;
        }
    }

    public static <T> T getObjectWhenVisible(By locator, Class<T> returnClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        return getObjectWhenConditionIsMet(condition, returnClass);
    }

    private static boolean checkThatObjectBecomesVisible(By locator) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        boolean isVisible = (getOrCheckWebElementWhenConditionIsMet(condition) != null);
        return isVisible;
    }

    private static boolean checkThatObjectBecomesInvisible(By locator) {
        ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(locator);
        boolean isInvisible = getOrCheckWebElementWhenConditionIsMet(condition);
        return isInvisible;
    }

    public static boolean waitForVisibilityState(By locator, boolean shouldBeVisible) {
        if (shouldBeVisible) {
            return checkThatObjectBecomesVisible(locator);
        } else {
            return checkThatObjectBecomesInvisible(locator);
        }
        /*try {
            getObjectWhenVisible(locator, BaseForm.class);
        } catch (Exception e) {
            return false;
        }
        return true;*/
    }
}
