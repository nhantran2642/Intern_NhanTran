package com.nhantran.base;

import com.nhantran.common.Constants;
import com.nhantran.listeners.TestListener;
import com.nhantran.utils.DriverManager;
import com.nhantran.utils.JsonFileReader;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(TestListener.class)
public class TestBase {

    private void startAUT(String browser) {
        String url = Constants.RAILWAY_URL;
        switch (browser) {
            case "chrome":
                DriverManager.setChromeDriver(url);
                break;
            case "firefox":
                DriverManager.setFireFoxDriver(url);
                break;
            case "edge":
                DriverManager.setEdgeDriver(url);
                break;
        }
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        startAUT(browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }


}
