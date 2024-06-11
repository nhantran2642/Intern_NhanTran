package com.nhantran.base;

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

    protected static Properties properties;
    protected static String validUsername;
    protected static String validPassword;
    protected static String invalidPassword;
    protected static String notActiveUsername;
    protected static String notActivePassword;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/nhantran/config/config.properties");
            properties.load(fis);
            validUsername = properties.getProperty("valid_username");
            validPassword = properties.getProperty("valid_password");
            invalidPassword = properties.getProperty("invalid_password");
            notActiveUsername = properties.getProperty("not_active_username");
            notActivePassword = properties.getProperty("not_active_password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("io exception");
        }
    }

    protected static void startAUT() {
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");
        if (browser.equals("chrome")) {
            setChromeDriver(url);
        } else if (browser.equals("firefox")) {
            setFireFoxDriver(url);
        }
    }

    private static void setChromeDriver(String url) {
        WebDriverManager.chromedriver().setup();
        DriverManager.driver = new ChromeDriver();
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverManager.driver.navigate().to(url);
    }

    private static void setFireFoxDriver(String url) {
        WebDriverManager.firefoxdriver().setup();
        DriverManager.driver = new FirefoxDriver();
        DriverManager.driver.manage().window().maximize();
        DriverManager.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverManager.driver.navigate().to(url);
    }

    protected static void closeDriver() {
        DriverManager.driver.close();
    }

    protected static void quitDriver() {
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
