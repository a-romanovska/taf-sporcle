package com.sporcle.ui.utils;

import com.sporcle.ui.finals.Finals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementUtils {
    private static WebElement getWebElement(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }

    public static WebElement getWebElementWhenConditionIsMet(ExpectedCondition<WebElement> condition, int specifiedTimeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(specifiedTimeoutSeconds));
        return wait.until(condition);
    }

    public static WebElement getWebElementWhenConditionIsMet(ExpectedCondition<WebElement> condition) {
        return getWebElementWhenConditionIsMet(condition, Finals.DEFAULT_EXPLICIT_WAIT_TIMEOUT_SECONDS);
    }

    /*public static boolean checkIfConditionIsMetForWebElementWithSpecifiedTimeout(ExpectedCondition<Boolean> condition, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(condition);
    }*/

    public static boolean isVisible(By locator) {
        return getWebElement(locator).isDisplayed();

        /*ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        WebElement webElement = getWebElementWhenConditionIsMetWithDefaultTimeout(condition);
        return webElement.isDisplayed();*/
        //return checkIfConditionIsMetForWebElementWithSpecifiedTimeout(condition,Finals.DEFAULT_EXPLICIT_WAIT_TIMEOUT_SECONDS);
    }

    /*public static boolean isInvisible(By locator) {
        //ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(locator);
        //return checkIfConditionIsMetForWebElementWithSpecifiedTimeout(condition, Finals.DEFAULT_EXPLICIT_WAIT_TIMEOUT_SECONDS);
        return !isVisible(locator);
    }*/
}
