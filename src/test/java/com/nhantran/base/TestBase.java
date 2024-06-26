package com.nhantran.base;

import com.nhantran.common.Constants;
import com.nhantran.listeners.TestListener;
import com.nhantran.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(TestListener.class)
public class TestBase {

    private void startAUT(String browser, String environment) {
        if (environment.equals("grid")) {
            DriverManager.initRemoteDriver(browser);
        } else {
            DriverManager.initLocalDriver(browser);
        }
        DriverManager.navigateToTestSite(Constants.RAILWAY_URL);
    }

    @Parameters({"browser", "environment"})
    @BeforeMethod
    public void setUp(String browser, String environment) {
        startAUT(browser, environment);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }


}
