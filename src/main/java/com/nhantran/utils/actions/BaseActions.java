package com.nhantran.utils.actions;

import com.nhantran.utils.Constants;
import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseActions {
    public static void scrollToElement(By element) {
        ((JavascriptExecutor) DriverManager.driver).executeScript("arguments[0].scrollIntoView(true);", findElement(element));
    }

    public static String getElementText(By element) {
        return findElement(element).getText();
    }

    public static WebElement findElement(By element) {
        return DriverManager.driver.findElement(element);
    }

    public static void waitUntilElementVisible(By element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static boolean isElementDisplayed(By element) {
        return findElement(element).isDisplayed();
    }
}
