package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.pages.*;
import com.nhantran.utils.SeleniumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    public LoginTest() {
        super();
    }

    private String loginContentErrorMessage = "There was a problem with your login and/or errors exist in your form.";
    private String loginAccountErrorMessage = "Invalid username or password. Please try again.";

    @Test(description = "User can log into Railway with valid username and password")
    public void TC001_SuccessToLoginWithValidAccount() {
        homePage.clickTab("Login");
        loginPage.login(validUsername, validPassword);
        SeleniumActions.zoomIn(1.5);
        Assert.assertEquals(homePage.isWelcomeUserMessageDisplayed(), Boolean.TRUE, "Welcome message does not display");
    }

    @Test(description = "User cannot login with blank Username text box")
    public void TC002_ErrorMessageDisplayWhenLoggingInWithBlankUsername() {
        homePage.clickTab("Login");
        loginPage.login("", validUsername);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginContentErrorMessage, "The error message does not match");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC003_ErrorMessageDisplayWhenLoggingInWithInvalidPassword() {
        homePage.clickTab("Login");
        loginPage.login(validUsername, invalidPassword);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginContentErrorMessage, "The error message does not match");
    }

    @Test(description = "System shows message when user enters wrong password many times")
    public void TC004_ErrorMessagesDisplayWhenEnteringWrongPasswordManyTimes() {
        String errorMessageAfter4LoginAttempts = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        homePage.clickTab("Login");
        int i = 1;
        while (i < 6) {
            loginPage.login(validUsername, invalidPassword);
            Assert.assertEquals(loginPage.getLoginErrorMessage(), loginAccountErrorMessage, "The error message does not match");
            i++;
        }
        Assert.assertEquals(loginPage.getLoginErrorMessage(), errorMessageAfter4LoginAttempts, "The error message does not match");
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC005_UserCannotLoginWithUnactivatedAccount() {
        homePage.clickTab("Login");
        loginPage.login(notActiveUsername, notActivePassword);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginAccountErrorMessage, "The error message does not match");
    }

}
