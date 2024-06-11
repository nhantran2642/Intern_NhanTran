package com.nhantran.chapter10;

import com.nhantran.base.TestBase;
import com.nhantran.pages.*;
import com.nhantran.utils.DriverManager;
import com.nhantran.utils.SeleniumActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class ResetPasswordTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MailboxPage mailboxPage = new MailboxPage();
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    public ResetPasswordTest() {
        super();
    }

    @Test(description = "Reset password shows error if the new password is same as current")
    public void TC010() {
        String railwayWindow = SeleniumActions.getWindowHandle();
        homePage.clickTab("Login");
        loginPage.clickForgotPasswordLink();
        forgetPasswordPage.getResetPasswordLink(validUsername);
        SeleniumActions.openWebInNewTab("https://www.guerrillamail.com");
        String mailWindow = SeleniumActions.getWindowHandle();
        mailboxPage.setMail(validUsername);
        mailboxPage.clickResetPasswordMail();
        String resetToken = mailboxPage.getResetPasswordToken();
        mailboxPage.clickResetPasswordLinkInMail();

        Set<String> allTabs = DriverManager.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(mailWindow) && !tab.equals(railwayWindow)) {
                DriverManager.driver.switchTo().window(tab);
                break;
            }
        }
        Assert.assertEquals(resetPasswordPage.checkChangePasswordFormDisplayed(), Boolean.TRUE, "Change password form does not displayed");
        Assert.assertEquals(resetPasswordPage.getResetTokenInTextBox(), resetToken, "Reset token does not match");
        resetPasswordPage.resetPassword(validPassword, validPassword);
        Assert.assertEquals(resetPasswordPage.getMessageAboveForm(), "The new password cannot be the same with the current password", "The error message does not match");
    }


    @Test(description = "Reset password shows error if the new password and confirm password doesn't match")
    public void TC011_ErrorMessageDisplayWhenNewPasswordDoesNotMatchConfirmPassword() {
        String railwayWindow = SeleniumActions.getWindowHandle();
        homePage.clickTab("Login");
        loginPage.clickForgotPasswordLink();
        forgetPasswordPage.getResetPasswordLink(validUsername);
        SeleniumActions.openWebInNewTab("https://www.guerrillamail.com");
        String mailWindow = SeleniumActions.getWindowHandle();
        mailboxPage.setMail(validUsername);
        mailboxPage.clickResetPasswordMail();
        String resetToken = mailboxPage.getResetPasswordToken();
        mailboxPage.clickResetPasswordLinkInMail();

        Set<String> allTabs = DriverManager.driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(mailWindow) && !tab.equals(railwayWindow)) {
                DriverManager.driver.switchTo().window(tab);
                break;
            }
        }
        Assert.assertEquals(resetPasswordPage.checkChangePasswordFormDisplayed(), Boolean.TRUE, "Change password form does not displayed");
        Assert.assertEquals(resetPasswordPage.getResetTokenInTextBox(), resetToken, "Reset token does not match");
        resetPasswordPage.resetPassword(validPassword, validPassword + "abc");
        Assert.assertEquals(resetPasswordPage.getMessageAboveForm(), "Could not reset password. Please correct the errors and try again.", "The error message above the form does not match");
        Assert.assertEquals(resetPasswordPage.getMessageNextToConfirmPassword(), "The password confirmation did not match the new password.", "The error message next to the confirm password textbox does not match");
    }
}
