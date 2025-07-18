package com.sporcle.ui.utils;

import com.sporcle.ui.finals.Finals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    //юзают FindWebElementUtils()
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
}
