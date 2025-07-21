package com.sporcle.ui.driver;

import com.sporcle.finals.Finals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DriverManager {
    private static WebDriver driver;
    private static String originalWindow;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            originalWindow = driver.getWindowHandle();
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

    public static void closeCurrentWindow() {
        driver.close();
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

    private static <T> T getOrCheckObjectWhenConditionIsMet(ExpectedCondition<T> condition, int specifiedTimeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(specifiedTimeoutSeconds));
        return wait.until(condition);
    }

    private static <T> T getOrCheckObjectWhenConditionIsMet(ExpectedCondition<T> condition) {
        return getOrCheckObjectWhenConditionIsMet(condition, Finals.DEFAULT_EXPLICIT_WAIT_TIMEOUT_SECONDS);
    }

    private static <T> T getOrCheckObjectWhenConditionIsMet(ExpectedCondition<WebElement> condition, Class<T> returnClass) {
        WebElement webElement = DriverManager.getOrCheckObjectWhenConditionIsMet(condition);
        try {
            return returnClass.getConstructor(WebElement.class).newInstance(webElement);
        } catch (Exception e) {
            System.out.println("Ошибка при создании объекта: " + returnClass.getName());
            return null;
        }
    }

    public static <T> T getObjectWhenVisible(By locator, Class<T> returnClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        return getOrCheckObjectWhenConditionIsMet(condition, returnClass);
    }

    public static <T> T getObjectWhenClickable(By locator, Class<T> returnClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(locator);
        return getOrCheckObjectWhenConditionIsMet(condition, returnClass);
    }

    private static boolean checkThatObjectBecomesVisible(By locator) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        boolean isVisible = (getOrCheckObjectWhenConditionIsMet(condition) != null);
        return isVisible;
    }

    private static boolean checkThatObjectBecomesInvisible(By locator) {
        ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(locator);
        boolean isInvisible = getOrCheckObjectWhenConditionIsMet(condition);
        return isInvisible;
    }

    public static boolean waitForVisibilityState(By locator, boolean shouldBeVisible) {
        if (shouldBeVisible) {
            return checkThatObjectBecomesVisible(locator);
        } else {
            return checkThatObjectBecomesInvisible(locator);
        }
    }

    public static void switchToNextWindow() {
        getOrCheckObjectWhenConditionIsMet(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowHandles = getDriver().getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static void switchToOriginalWindow() {
        driver.switchTo().window(originalWindow);
    }
}
