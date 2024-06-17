package com.nhantran.base;

import com.nhantran.utils.Constants;
import com.nhantran.utils.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    private Properties properties;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + Constants.PROPERTY_PATH);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("io exception");
        }
    }

    protected void startAUT() {
        String browser = properties.getProperty("browser");
        String url = Constants.RAILWAY_URL;
        if (browser.equals("chrome")) {
            setChromeDriver(url);
        } else if (browser.equals("firefox")) {
            setFireFoxDriver(url);
        }
    }

    private void setChromeDriver(String url) {
        WebDriverManager.chromedriver().setup();
        DriverManager.driver = new ChromeDriver();
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverManager.driver.navigate().to(url);
    }

    private void setFireFoxDriver(String url) {
        WebDriverManager.firefoxdriver().setup();
        DriverManager.driver = new FirefoxDriver();
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverManager.driver.navigate().to(url);
    }

    protected void closeDriver() {
        DriverManager.driver.close();
    }

    protected void quitDriver() {
        DriverManager.driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        startAUT();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
