package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.models.User;
import com.nhantran.pages.HomePage;
import com.nhantran.pages.LoginPage;
import com.nhantran.utils.Constants;
import com.nhantran.utils.Messages;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private User validUser = new User(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
    private User invalidUser = new User(Constants.VALID_USERNAME, Constants.INVALID_PASSWORD);
    private User inactiveUser = new User(Constants.INACTIVE_USERNAME, Constants.INACTIVE_PASSWORD);

    @Test(description = "User can log into Railway with valid username and password")
    public void TC001_LoginSuccessfullyWithValidAccount() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(validUser);
        Assert.assertTrue(homePage.isTabDisplayed(RailwayTabs.LOG_OUT), "Log out tab does not display");
        Assert.assertTrue(homePage.isWelcomeUserMessageDisplayed(), "Welcome user message does not display");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataTestTC002AndTC003() {
        return new Object[][]{
                {new User(null, Constants.VALID_PASSWORD), Messages.MSG_ERROR_ABOVE_LOGIN_FORM},
                {invalidUser, Messages.MSG_ERROR_ABOVE_LOGIN_FORM}
        };
    }

    @Test(dataProvider = "loginData", description = "User cannot login with blank Username text box or invalid password")
    public void TC002_003_LoginFailWithBlankUsernameOrInvalidPassword(User user, String expectedErrorMessage) {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(user);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), expectedErrorMessage);
    }

    @Test(description = "System shows message when user enters wrong password many times")
    public void TC004_ErrorMessagesDisplayWhenEnteringWrongPasswordManyTimes() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.loginManyTimes(invalidUser, 5);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), Messages.MSG_ERROR_LOGIN_MANY_TIMES);
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC005_LoginFailWithInactivatedAccount() {
        homePage.clickTab(RailwayTabs.LOGIN);
        loginPage.login(inactiveUser);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), Messages.MSG_ERROR_LOGIN_INACTIVE_ACCOUNT);
    }

}
