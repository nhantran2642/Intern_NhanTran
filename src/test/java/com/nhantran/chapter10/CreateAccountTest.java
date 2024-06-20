package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.enums.RailwayTabs;
import com.nhantran.models.User;
import com.nhantran.pages.HomePage;
import com.nhantran.pages.MailboxPage;
import com.nhantran.pages.RegisterPage;
import com.nhantran.pages.RegistrationConfirmationPage;
import com.nhantran.common.Constants;
import com.nhantran.common.Messages;
import com.nhantran.utils.controls.WindowControl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();
    private MailboxPage mailboxPage = new MailboxPage();
    private RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();
    private User alreadyRegistedUser = new User(Constants.VALID_USERNAME, "0987654321", "0987654321", "000000000000");
    private User emptyPasswordPidUser = new User(Constants.VALID_USERNAME, null, null, null);
    private User newUser;

    @Test(description = "User can't create account with an already in-use email")
    public void TC007_CreateAccountFailWithEmailAlreadyUsed() {
        homePage.clickTab(RailwayTabs.REGISTER);
        registerPage.register(alreadyRegistedUser);
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), Messages.MSG_ERROR_REGISTER_USED_EMAIL, "The error message does not match");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC008_CreateAccountFailWithEmptyPasswordAndPID() {
        homePage.clickTab(RailwayTabs.REGISTER);
        registerPage.register(emptyPasswordPidUser);
        Assert.assertEquals(registerPage.getErrorMessageAboveRegisterForm(), Messages.MSG_ERROR_ABOVE_REGISTER_FORM, "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPassword(), Messages.MSG_ERROR_PASSWORD_LENGTH, "The error message does not match");
        Assert.assertEquals(registerPage.getErrorMessageNextToPID(), Messages.MSG_ERROR_PID_LENGTH, "The error message does not match");
    }

    @Test(description = "User create and activate account")
    public void TC009_CreateAndActiveSuccessfullyAnAccount() {
        homePage.clickCreateAccountHyperlink();
        String railwayWindow = WindowControl.getWindowHandle();
        WindowControl.openSiteInNewTab(Constants.TEMPORARY_MAIL_URL);
        mailboxPage.uncheckScrambleAddressCheckbox();
        String mail = mailboxPage.getMail();
        newUser = new User(mail, "1234567890", "1234567890", "11111111111");
        String mailWindow = WindowControl.getWindowHandle();
        WindowControl.switchToWindow(railwayWindow);
        registerPage.register(newUser);
        WindowControl.switchToWindow(mailWindow);
        WindowControl.refresh();
        mailboxPage.clickConfirmLinkInMail();
        WindowControl.switchToRemainingTab(railwayWindow, mailWindow);
        Assert.assertEquals(registrationConfirmationPage.getConfirmationSuccessMessage(), Messages.MSG_SUCCESS_CONFIRM_REGISTRATION, "The registration confirmation message does not match");
    }
}
