package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.models.User;
import com.nhantran.pages.HomePage;
import com.nhantran.pages.LoginPage;
import com.nhantran.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private User validUser = new User(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
    private User invalidUser = new User(Constants.VALID_USERNAME, Constants.INVALID_PASSWORD);
    private User nonActiveUser = new User(Constants.NON_ACTIVE_USERNAME, Constants.NON_ACTIVE_PASSWORD);

    @Test(description = "User can log into Railway with valid username and password")
    public void TC001_SuccessToLoginWithValidAccount() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        Assert.assertEquals(homePage.isTabDisplayed(RailwayTabs.LOG_OUT), Boolean.TRUE);
        Assert.assertEquals(homePage.isWelcomeUserMessageDisplayed(), Boolean.TRUE);
    }

    @DataProvider(name = "loginData")
    public Object[][] dataTestTC002AndTC003() {
        return new Object[][]{
                {new User(null, Constants.VALID_PASSWORD), "There was a problem with your login and/or errors exist in your form."},
                {invalidUser, "There was a problem with your login and/or errors exist in your form."}
        };
    }

    @Test( dataProvider = "loginData", description = "User cannot login with blank Username text box or invalid password")
    public void TC002_003_ErrorMessageDisplayWhenLoggingInWithBlankUsernameOrInvalidPassword(User user, String expectedErrorMessage) {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(user);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), expectedErrorMessage);
    }

    @Test(description = "System shows message when user enters wrong password many times")
    public void TC004_ErrorMessagesDisplayWhenEnteringWrongPasswordManyTimes() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.loginManyTimes(invalidUser, 5);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC005_UserCannotLoginWithUnactivatedAccount() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(nonActiveUser);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), "Invalid username or password. Please try again.");
    }

}
