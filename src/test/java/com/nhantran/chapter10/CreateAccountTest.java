package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.models.User;
import com.nhantran.pages.HomePage;
import com.nhantran.pages.MailboxPage;
import com.nhantran.pages.RegisterPage;
import com.nhantran.pages.RegistrationConfirmationPage;
import com.nhantran.utils.Constants;
import com.nhantran.utils.SeleniumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    MailboxPage mailboxPage = new MailboxPage();
    RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();
    private User alreadyRegistedUser = new User(Constants.VALID_USERNAME, "0987654321", "0987654321", "000000000000");
    private User emptyPasswordPidUser = new User(Constants.VALID_USERNAME, null, null, null);
    private User newUser;

    @Test(description = "User can't create account with an already in-use email")
    public void TC007_FailToCreateAccountWithEmailAlreadyUsed() {
        homePage.clickTab(RailwayTabs.REGISTER);
        registerPage.register(alreadyRegistedUser);
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), "This email address is already in use.", "The error message does not match");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC008_FailToCreateAccountWithEmptyPasswordAndPID() {
        homePage.clickTab(RailwayTabs.REGISTER);
        registerPage.register(emptyPasswordPidUser);
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), "There're errors in the form. Please correct the errors and try again.", "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPassword(), "Invalid password length", "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPID(), "Invalid ID length", "The error message does not match");
    }

    @Test(description = "User create and activate account")
    public void TC009_SuccessToCreateAndActivateAccount() {
        homePage.clickCreateAccountHyperlink();
        String railwayWindow = SeleniumActions.getWindowHandle();
        SeleniumActions.openWebInNewTab(Constants.TEMPORARY_MAIL_URL);
        mailboxPage.clickScrambleAddressCheckbox();
        String mail = mailboxPage.getMail();
        newUser = new User(mail, "1234567890", "1234567890", "11111111111");
        String mailWindow = SeleniumActions.getWindowHandle();
        SeleniumActions.switchToWindow(railwayWindow);
        registerPage.register(newUser);
        SeleniumActions.switchToWindow(mailWindow);
        SeleniumActions.refreshPage();
        mailboxPage.clickConfirmLinkInMail();
        SeleniumActions.switchToRemainingTab(railwayWindow, mailWindow);
        Assert.assertEquals(registrationConfirmationPage.getConfirmationSuccessMessage(), "Registration Confirmed! You can now log in to the site.", "Message does not show");
    }
}
