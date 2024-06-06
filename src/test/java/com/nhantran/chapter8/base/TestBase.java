package com.nhantran.chapter8.base;

import com.nhantran.utils.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TestBase {

    protected static void startAUT(String browser, String url) {
        if (browser.equals("chrome")){
            setChromeDriver(url);
        } else if (browser.equals("firefox")) {
            setFireFoxDriver(url);
        }
    }

    private static void setChromeDriver(String url) {
        WebDriverManager.chromedriver().setup();
        DriverManager.driver = new ChromeDriver();
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.navigate().to(url);
        DriverManager.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    private static void setFireFoxDriver(String url) {
        WebDriverManager.firefoxdriver().setup();
        DriverManager.driver = new FirefoxDriver();
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.navigate().to(url);
        DriverManager.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    protected static void closeDriver(){
        DriverManager.driver.close();
    }

    protected static void quitDriver(){
        DriverManager.driver.quit();
    }
}
