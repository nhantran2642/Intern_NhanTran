package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.pages.*;
import com.nhantran.utils.DriverManager;
import com.nhantran.utils.SeleniumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CreateAccountTest extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    MailboxPage mailboxPage = new MailboxPage();
    RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();

    public CreateAccountTest() {
        super();
    }

    @Test(description = "User can't create account with an already in-use email")
    public void TC007() {
        homePage.clickTab("Register");
        registerPage.register(validUsername, validPassword, validPassword, "0909090909090909");
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), "This email address is already in use.", "The error message does not match");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC008(){
        homePage.clickTab("Register");
        registerPage.register(validUsername, "", "", "");
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), "There're errors in the form. Please correct the errors and try again.", "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPassword(), "Invalid password length", "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPID(), "Invalid ID length", "The error message does not match");
    }

    @Test(description = "User create and activate account")
    public void TC009(){
        homePage.clickCreateAccountHyperlink();
        String registerWindow= SeleniumActions.getWindowHandle();
        SeleniumActions.openWebInNewTab("https://www.guerrillamail.com");
        mailboxPage.clickScrambleAddressCheckbox();
        String mail = mailboxPage.getMail();
        String mailWindow = SeleniumActions.getWindowHandle();
        SeleniumActions.switchToWindow(registerWindow);
        registerPage.register(mail, "1234567890","1234567890", "11111111111");
        SeleniumActions.switchToWindow(mailWindow);
        SeleniumActions.refreshPage();
        mailboxPage.clickConfirmLinkInMail();
        Set<String> allTabs = DriverManager.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(mailWindow) && !tab.equals(registerWindow)) {
                DriverManager.driver.switchTo().window(tab);
                break;
            }
        }
        Assert.assertEquals(registrationConfirmationPage.getConfirmationSuccessMessage(), "Registration Confirmed! You can now log in to the site.", "Message does not show");
    }
}
