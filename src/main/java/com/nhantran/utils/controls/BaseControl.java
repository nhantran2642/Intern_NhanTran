package com.nhantran.utils.controls;

import com.nhantran.common.Constants;
import com.nhantran.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseControl {
    private By locator;

    public BaseControl(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return DriverManager.driver.findElement(this.locator);
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) DriverManager.driver).executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public String getText() {
        return findElement().getText();
    }

    public void waitUntilElementVisible() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(Constants.DRIVER_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public boolean isDisplayed() {
        return findElement().isDisplayed();
    }
}
