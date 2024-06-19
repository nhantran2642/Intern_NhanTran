package com.nhantran.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    public static WebDriver driver;

    public static void setChromeDriver(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        navigateToTestSite(url);
    }

    public static void setFireFoxDriver(String url) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        navigateToTestSite(url);
    }

    public static void navigateToTestSite(String url) {
        maximizeWindow();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to(url);
    }

    private static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
