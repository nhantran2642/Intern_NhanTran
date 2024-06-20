package com.nhantran.base;

import com.nhantran.common.Constants;
import com.nhantran.listeners.TestListener;
import com.nhantran.utils.DriverManager;
import com.nhantran.utils.PropertiesFileReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class TestBase {

    private PropertiesFileReader properties;

    public TestBase() {
        String propertyFilePath = Constants.PROPERTY_PATH;
        properties = new PropertiesFileReader(propertyFilePath);
    }

    private void startAUT() {
        String browser = properties.getProperty("browser");
        String url = Constants.RAILWAY_URL;
        if (browser.equals("chrome")) {
            DriverManager.setChromeDriver(url);
        } else if (browser.equals("firefox")) {
            DriverManager.setFireFoxDriver(url);
        }
    }

    @BeforeMethod
    public void setUp() {
        startAUT();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }


}
