package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.pages.*;
import com.nhantran.utils.SeleniumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RailwayTestCase extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    BookTicketSuccessPage successPage = new BookTicketSuccessPage();

    public RailwayTestCase() {
        super();
    }

    private String validUsername = properties.getProperty("valid_username");
    private String validPassword = properties.getProperty("valid_password");
    private String invalidPassword = properties.getProperty("invalid_password");
    private String notActiveUsername = properties.getProperty("not_active_username");
    private String notActivePassword = properties.getProperty("not_active_password");
    private String loginContentErrorMessage = "There was a problem with your login and/or errors exist in your form.";
    private String loginAccountErrorMessage = "Invalid username or password. Please try again.";

    @Test(description = "User can log into Railway with valid username and password")
    public void TC1() {
        homePage.clickTab("Login");
        loginPage.login(validUsername, validPassword);
        SeleniumActions.zoomIn(1.5);
        Assert.assertEquals(homePage.checkWelcomeUserMessageDisplay(), Boolean.TRUE, "Welcome message does not display");
    }

    @Test(description = "User cannot login with blank Username text box")
    public void TC2() {
        homePage.clickTab("Login");
        loginPage.login("", validUsername);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginContentErrorMessage, "The error message does not match");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC3() {
        homePage.clickTab("Login");
        loginPage.login(validUsername, invalidPassword);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginContentErrorMessage, "The error message does not match");
    }


    @Test(description = "System shows message when user enters wrong password many times")
    public void TC4() {
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
    public void TC5() {
        homePage.clickTab("Login");
        loginPage.login(notActiveUsername, notActivePassword);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginAccountErrorMessage, "The error message does not match");
    }

    @Test(description = "User is redirected to Home page after logging out")
    public void TC6() {
        homePage.clickTab("Login");
        loginPage.login(validUsername, validPassword);
        homePage.clickTab("FAQ");
        homePage.clickTab("Log out");
        Assert.assertEquals(homePage.checkHomePageTitleDisplay(), Boolean.TRUE, "System does not redirect to the Home page");
        Assert.assertEquals(homePage.checkTabDisplay("Log out"), Boolean.FALSE, "User still does not log out");
    }

    @Test(description = "User can't create account with an already in-use email")
    public void TC7() {
        homePage.clickTab("Register");
        registerPage.register(validUsername, validPassword, validPassword, "0909090909090909");
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), "This email address is already in use.", "The error message does not match");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC8(){
        homePage.clickTab("Register");
        registerPage.register(validUsername, "", "", "");
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), "There're errors in the form. Please correct the errors and try again.", "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPassword(), "Invalid password length", "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPID(), "Invalid ID length", "The error message does not match");
    }
}
