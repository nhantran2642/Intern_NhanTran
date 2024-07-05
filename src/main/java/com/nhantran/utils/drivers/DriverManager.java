package com.nhantran.utils.drivers;

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

    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(RemoteWebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void initLocalDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                setDriver(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                setDriver(new EdgeDriver());
                break;
        }
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
                    setDriver(new RemoteWebDriver(new URL(Constants.NODE_URL), chromeOptions));
                    break;
                case "firefox":
                    capability.setBrowserName("firefox");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.merge(capability);
                    setDriver(new RemoteWebDriver(new URL(Constants.NODE_URL), firefoxOptions));
                    break;
                case "edge":
                    capability.setBrowserName("MicrosoftEdge");
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.merge(capability);
                    setDriver(new RemoteWebDriver(new URL(Constants.NODE_URL), edgeOptions));
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void navigateToTestSite(String url) {
        getDriver().navigate().to(url);
    }

    public static void waitForPageToLoad() {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_WAIT_TIME));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICITLY_WAIT_TIME));
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static void closeDriver() {
        if (getDriver() != null) {
            getDriver().close();
        }
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
