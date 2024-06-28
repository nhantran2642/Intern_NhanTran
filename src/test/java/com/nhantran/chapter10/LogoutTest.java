package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.models.User;
import com.nhantran.pages.HomePage;
import com.nhantran.pages.LoginPage;
import com.nhantran.common.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private User validUser = User.getLoginAccountFromJsonFile("validAccount");

    @Test(description = "User is redirected to Home page after logging out")
    public void TC006_RedirectToHomepageAfterLoggingOut() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        homePage.clickTab(RailwayTabs.FAQ);
        homePage.clickTab(RailwayTabs.LOG_OUT);
        Assert.assertTrue(homePage.isHomePageTitleDisplayed());
        Assert.assertFalse(homePage.isTabDisplayed(RailwayTabs.LOG_OUT));
    }
}
