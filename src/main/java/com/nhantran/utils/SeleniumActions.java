package com.nhantran.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {

    public static void scrollToElement(By element) {
        ((JavascriptExecutor) DriverManager.driver).executeScript("arguments[0].scrollIntoView(true);", findElement(element));
    }

    public static void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void clickElement(By element) {
        SeleniumActions.findElement(element).click();
    }

    public static WebElement findElement(By element) {
        return DriverManager.driver.findElement(element);
    }

    public static String getElementText(By element) {
        return SeleniumActions.findElement(element).getText();
    }

    public static void sendKeysToElement(By element, String key) {
        SeleniumActions.findElement(element).sendKeys(key);
    }

    public static void zoomIn(Double zoomNumber) {
        ((JavascriptExecutor) DriverManager.driver).executeScript(String.format("document.body.style.zoom = '%f'", zoomNumber));
    }

    public static void clear(By element) {
        findElement(element).clear();
    }
}
