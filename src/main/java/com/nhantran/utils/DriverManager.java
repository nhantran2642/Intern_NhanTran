package com.nhantran.utils;

import com.nhantran.common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    public static WebDriver driver;

    public static void initLocalDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        maximizeWindow();
    }

    public static void initRemoteDriver(String browser) {
        try {
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setPlatform(Platform.ANY);
            switch (browser) {
                case "chrome":
                    capability.setBrowserName("chrome");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.merge(capability);
                    break;
                case "firefox":
                    capability.setBrowserName("firefox");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.merge(capability);
                    break;
                case "edge":
                    capability.setBrowserName("MicrosoftEdge");
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.merge(capability);
                    break;
            }
            driver = new RemoteWebDriver(new URL(Constants.NODE_URL), capability);
            maximizeWindow();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void navigateToTestSite(String url) {
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
