package com.nhantran.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class SeleniumActions {

    public static void scrollToElement(By element) {
        ((JavascriptExecutor) DriverManager.driver).executeScript("arguments[0].scrollIntoView(true);", findElement(element));
    }

    public static void selectByText(By element, String text) {
        Select select = new Select(findElement(element));
        select.selectByVisibleText(text);
    }

    public static void selectByValue(By element, String value) {
        Select select = new Select(findElement(element));
        select.selectByValue(value);
    }

    public static String getSelectedOption(By element) {
        Select select = new Select(findElement(element));
        return select.getFirstSelectedOption().getText();
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

    public static void enter(By element, String key) {
        SeleniumActions.findElement(element).sendKeys(key);
    }

    public static void clear(By element) {
        findElement(element).clear();
    }

    public static void openWebInNewTab(String url) {
        DriverManager.driver.switchTo().newWindow(WindowType.TAB);
        DriverManager.driver.navigate().to(url);
    }

    public static void switchToWindow(String windowHandle) {
        DriverManager.driver.switchTo().window(windowHandle);
    }

    public static String getWindowHandle() {
        return DriverManager.driver.getWindowHandle();
    }

    public static void waitUntilElementVisible(By element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void refreshPage() {
        DriverManager.driver.navigate().refresh();
    }

    public static void acceptAlert() {
        DriverManager.driver.switchTo().alert().accept();
    }

    public static void switchToRemainingTab(String windowHandleOfFirstTab, String windowHandleOfSecondTab) {
        Set<String> allTabs = DriverManager.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(windowHandleOfFirstTab) && !tab.equals(windowHandleOfSecondTab)) {
                DriverManager.driver.switchTo().window(tab);
                break;
            }
        }

    }
}
