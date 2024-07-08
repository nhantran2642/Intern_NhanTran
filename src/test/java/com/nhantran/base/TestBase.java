package com.nhantran.base;

import com.nhantran.common.Constants;
import com.nhantran.listeners.TestListener;
import com.nhantran.utils.drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

//@Listeners(TestListener.class)
public class TestBase {

    private void startAUT(String browser, String runMode) {
        if (runMode.equals("grid")) {
            DriverManager.initRemoteDriver(browser);
        } else {
            DriverManager.initLocalDriver(browser);
        }
        DriverManager.maximizeWindow();
        DriverManager.waitForPageToLoad();
        DriverManager.navigateToTestSite(Constants.RAILWAY_URL);
    }

    @Parameters({"browser", "runMode"})
    @BeforeMethod
    public void setUp(String browser, String runMode) {
        startAUT(browser, runMode);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }


}
