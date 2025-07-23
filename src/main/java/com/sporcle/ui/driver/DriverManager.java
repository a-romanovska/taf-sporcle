package com.sporcle.ui.driver;

import com.sporcle.enums.Symbol;
import com.sporcle.ui.Timeouts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final int MORE_THAN_ONE = 2;
    protected static Logger logger = LogManager.getLogger();

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

    public static String getCurrentUrl() {
        if (driver == null) {
            return Symbol.EMPTY.getSymbol();
        } else {
            return driver.getCurrentUrl();
        }
    }

    public static String getCurrentTitle() {
        if (driver == null) {
            return Symbol.EMPTY.getSymbol();
        } else {
            return driver.getTitle();
        }
    }

    public static void switchToNextWindow() {
        getWebElementWhenConditionIsMet(ExpectedConditions.numberOfWindowsToBe(MORE_THAN_ONE));

        Set<String> windowHandles = getDriver().getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
    }

    public static boolean checkVisibilityState(By locator, boolean shouldBeVisible) {
        if (shouldBeVisible) {
            return becomesVisible(locator);
        } else {
            return becomesInvisible(locator);
        }
    }

    private static boolean becomesVisible(By locator) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        boolean isVisible = (getWebElementWhenConditionIsMet(condition) != null);
        return isVisible;
    }

    private static boolean becomesInvisible(By locator) {
        ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(locator);
        boolean isInvisible = getWebElementWhenConditionIsMet(condition);
        return isInvisible;
    }

    public static boolean attributeBecomesExpected(By locator, String attribute, String expectedValue) {
        WebElement webElement = getWebElement(locator);
        ExpectedCondition<Boolean> condition = ExpectedConditions.attributeToBe(webElement, attribute, expectedValue);
        boolean isExpected = getWebElementWhenConditionIsMet(condition);
        return isExpected;
    }

    public static WebElement getWebElement(By locator) {
        return getDriver().findElement(locator);
    }

    public static <T> T getObjectWhenVisible(By locator, Class<T> returnClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        return getObjectWhenConditionIsMet(condition, returnClass);
    }

    public static <T> T getObjectWhenClickable(By locator, Class<T> returnClass) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(locator);
        return getObjectWhenConditionIsMet(condition, returnClass);
    }

    private static <T> T getObjectWhenConditionIsMet(ExpectedCondition<WebElement> condition, Class<T> returnClass) {
        WebElement webElement = DriverManager.getWebElementWhenConditionIsMet(condition);
        try {
            return returnClass.getConstructor(WebElement.class).newInstance(webElement);
        } catch (Exception e) {
            logger.info("Error when trying to create object {}", returnClass.getName());
            return null;
        }
    }

    private static <T> T getWebElementWhenConditionIsMet(ExpectedCondition<T> condition) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Timeouts.DEFAULT_EXPLICIT_WAIT_TIMEOUT_SECONDS));
        return wait.until(condition);
    }
}
