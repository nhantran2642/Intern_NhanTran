package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.pages.HomePage;
import com.nhantran.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    public LogoutTest() {
        super();
    }

    @Test(description = "User is redirected to Home page after logging out")
    public void TC006_RedirectingToHomepageAfterLoggingOut() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUsername, validPassword);
        homePage.clickTab(RailwayTabs.FAQ);
        homePage.clickTab(RailwayTabs.LOG_OUT);
        Assert.assertEquals(homePage.isHomePageTitleDisplayed(), Boolean.TRUE, "System does not redirect to the Home page");
        Assert.assertEquals(homePage.isTabDisplayed(RailwayTabs.LOG_OUT), Boolean.FALSE, "User still does not log out");
    }
}
