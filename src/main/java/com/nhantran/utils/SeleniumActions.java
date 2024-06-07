package com.nhantran.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static WebElement findElement(By element) {
        return DriverManager.driver.findElement(element);
    }

    public static String getElementText(WebElement element) {
        return element.getText();
    }

    public static void sendKeysToElement(WebElement element, String key) {
        element.sendKeys(key);
    }

}
